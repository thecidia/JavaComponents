package com.java.components.lang.template;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.java.components.lang.CompilerTaskException;

public class STs { // StringTemplate support
	// ---------- Create Field : Start ---------- \\
	public static final String FullName = "StringTemplate support";
	public static final String Name = "STs";
	public static final String Version = "1.0.0";
	private Map<Object, Object> replacement;
	private STDs std = new STDs("${", ":", "};");
	private String stds = this.std.getStartDelimiter();
	private String stde = this.std.getEndDelimiter();
	private String stdc = this.std.getConditionDelimiter();
	private STDs stdc2 = new STDs('$');
	private Character stdcs = this.stdc2.getSingleStartDelimiter();
	private String template;
	// ---------- Create Field : End ---------- \\

	// ---------- Constructor : Start ---------- \\
	public STs() { this(""); }

	public STs(String text) {
		this.template = text;
		this.replacement = new HashMap<>();
	}

	public STs(List<?> list) {
		this(list.toArray());
	}

	public STs(Object... arrays) {
		StringBuilder sb = new StringBuilder();
		for(Object o : arrays) sb.append(o);
		this.template = sb.toString();
		this.replacement = new HashMap<>();
	}
	// ---------- Constructor : End ---------- \\

	// ---------- Delimiter : Start ---------- \\
	public STs setStartDelimiter(String start) {
		this.stds = start;
		return this;
	}
	
	public STs setDonditionDelimiter(String condition) {
		this.stdc = condition;
		return this;
	}
	public STs setEndDelimiter(String end) {
		this.stde = end;
		return this;
	}
	public STs setSingleStartDelimiter(char singelStart) {
		this.stdcs = singelStart;
		return this;
	}

	// ---------- Delimiter : End ---------- \\

	// ---------- Set : Start ---------- \\
	public STs set(Object key, Object obj) {
		if(key == null) throw new CompilerTaskException("the 'key' is null");
		if(((String) key).startsWith(".")) throw new CompilerTaskException("your 'key' start with in '.'");
		if(((String) key).endsWith(".")) throw new CompilerTaskException("your 'key' end with in '.'");
		this.replacement.put(key, obj);
		return this;
	}

	public STs set(Object key, Object... objs) {
		if(key == null) throw new CompilerTaskException("the 'key' is null");
		if(((String) key).startsWith(".")) throw new CompilerTaskException("your 'key' start with in '.'");
		if(((String) key).endsWith(".")) throw new CompilerTaskException("your 'key' end with in '.'");
		StringBuilder sb = new StringBuilder();
		for(Object obj : objs) sb.append(obj);
		this.replacement.put(key, sb.toString());
		return this;
	}

	public STs set(Object key, List<?> objs) { return set(key, objs.toArray()); }
	// ---------- Set : Start ---------- \\
	
	// ---------- Append : End ---------- \\
	public STs append(Object addText) {
		this.template = new StringBuilder(template).append(addText).toString();
		return this;
	}

	public STs append(Object... addText) {
		StringBuilder sb = new StringBuilder(template);
		for(Object obj : addText) sb.append(obj);
		this.template = sb.toString();
		return this;
	}

	public STs append(List<?> addText) { return append(addText.toArray()); }
	// ---------- Append : End ---------- \\
	
	// ---------- Remove : End ---------- \\
	public STs remove(String key) {
		if(key == null) throw new CompilerTaskException("the 'key' is null");
		if(key.startsWith(".")) throw new CompilerTaskException("your 'key' start with in '.'");
		if(key.endsWith(".")) throw new CompilerTaskException("your 'key' end with in '.'");
		this.replacement.remove(key);
		return this;
	}

	public STs remove(Object... keys) {
		for(Object key : keys) {
			if(key == null) throw new CompilerTaskException("the 'key' is null");
			if(((String) key).startsWith(".")) throw new CompilerTaskException("your 'key' start with in '.'");
			if(((String) key).endsWith(".")) throw new CompilerTaskException("your 'key' end with in '.'");
			this.replacement.remove(((String) key));
		}
		return this;
	}

	public STs remove(List<?> keys) { return remove(keys.toArray()); }
	// ---------- Remove : End ---------- \\

	// ---------- Clear : End ---------- \\
	public void clearAll() {
		clearText();
		clearTemplate();
		clearDelimiter();
	}

	private STs clearText() {
		this.template = "";
		return this;
	}

	private STs clearTemplate() {
		this.replacement.clear();
		return this;
	}

	private STs clearDelimiter() {
		this.std = new STDs("${", ":", "};");
		this.stdc2 = new STDs('$');
		return this;
	}
	// ---------- Clear : End ---------- \\

	// ---------- Compiler : End ---------- \\
	public String fillTemplate(Object... arg) {
		Matcher matcher1 = Pattern.compile(Pattern.quote(this.stds) + "(.*?)" + Pattern.quote(this.stde)).matcher(this.template);
		StringBuffer stringBuffer = new StringBuffer();
		while(matcher1.find()) {
			String[] splits = (matcher1.group(1) != null ? matcher1.group(1) : "").split(this.stdc);
			Object get = splits[0];
			String formatOrdefault = splits.length > 1 ? splits[1] : splits.length == 0 ? null : splits[0];
			String format = splits.length > 2 ? splits[2] : null;
			String replace = (String) this.replacement.get(get);
			if(replace == null && formatOrdefault != null) replace = formatOrdefault;
			if(formatOrdefault != null) replace = (format != null) ? applyFormat(format, replace) : applyFormat(formatOrdefault, replace);
			matcher1.appendReplacement(stringBuffer, replace != null ? Matcher.quoteReplacement(replace) : "NOT-ARGUMENT");
		}
		matcher1.appendTail(stringBuffer);

		Matcher matcher2 = Pattern.compile(Pattern.quote(this.stdcs.toString()) + "\\d+").matcher(stringBuffer.toString());
		stringBuffer = new StringBuffer();
		while(matcher2.find()) {
			int index = Integer.parseInt(matcher2.group().substring(1));
			if(index >= 0 && index < arg.length) {
				if(!arg[index].toString().contains(":")) matcher2.appendReplacement(stringBuffer, Matcher.quoteReplacement(arg[index].toString()));
				else {
					String[] split = arg[index].toString().split(this.stdcs.toString());
					String replace = split[0];
					String formats = split[1];
					String[] formatter = formats.split(", *");
					for(String format : formatter) {
						if(replace != null) {
							replace = applyFormat(format != null ? format : "", replace);
							matcher2.appendReplacement(stringBuffer, replace);
						} else matcher2.appendReplacement(stringBuffer, replace);
					}
				}
			} else matcher2.appendReplacement(stringBuffer, "NOT-ARGUMENT");
		}
		matcher2.appendTail(stringBuffer);
		return stringBuffer.toString();
	}

	private String applyFormat(String formatType, String text) {
		if(formatType.equalsIgnoreCase("UpperCase")) return text.toUpperCase();
		if(formatType.equalsIgnoreCase("LowerCase")) return text.toLowerCase();
		if(formatType.equalsIgnoreCase("Reverse")) return new StringBuilder(text).reverse().toString();
		return text;
	}
	// ---------- Compiler : End ---------- \\
}
	// ---------- Name : Start ---------- \\
	// ---------- Name : End ---------- \\