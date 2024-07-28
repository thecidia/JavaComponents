package com.java.components.lang.template;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.java.components.lang.ConfigurationException;

import com.java.components.lang.StringBuilder;

import java.util.HashMap;
import java.util.List;

public class StringTemplate {
	private Map<Object, Object> replacement;
	private StringTemplateDelimiter std = new StringTemplateDelimiter("${", ":", "};");
	private String stds = this.std.getStartDelimiter();
	private String stdc = this.std.getConditionDelimiter();
	private String stde = this.std.getEndDelimiter();
	private StringTemplateDelimiter stdc2 = new StringTemplateDelimiter('$');
	private Character stdcs = this.stdc2.getSingleStartDelimiter();
	private String template;

	public StringTemplate() { this(""); }

	public StringTemplate(String template) {
		this.template = template;
		this.replacement = new HashMap<>();
	}

	public StringTemplate(Object... objs) {
		StringBuilder sb = new StringBuilder();
		for (Object obj : objs) { sb.append(obj.toString()); }
		this.template = sb.toString();
		this.replacement = new HashMap<>();
	}

	public StringTemplate(List<?> list) { this(list.toArray()); }

	public StringTemplate set(Object key, Object value) {
		if (key == null) throw new ConfigurationException("Key cannot be null.");
		if (((String) key).isEmpty()) throw new ConfigurationException("Key cannot be empty.");
		if (((String) key).startsWith(".")) throw new ConfigurationException("Key cannot start with '.'.");
		if (((String) key).endsWith(".")) throw new ConfigurationException("Key cannot end with '.'.");
		this.replacement.put(key, value);
		return this;
	}

	public String fillTemplate(Object... args) {
		Matcher matcher = Pattern.compile(Pattern.quote(stds) + "(.*?)" + Pattern.quote(stde)).matcher(this.template);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			String[] splits = (matcher.group(1) != null) ? matcher.group(1).split(stdc) : new String[0];
			String formatOrDefault = (splits.length > 1) ? splits[1] : (splits.length == 0) ? splits[0] : "";
			String format = (splits.length > 2) ? splits[2] : "";
			String replace = (String) this.replacement.get(splits[0]);
			if (replace == null && formatOrDefault != null) { replace = formatOrDefault; } 
			if (formatOrDefault != null) { replace = (format != null) ? applyFormat(format, replace) : applyFormat(formatOrDefault, replace); }
			matcher.appendReplacement(sb, replace != null ? Matcher.quoteReplacement(replace) : "NOT-ARGUMENT");
		}
		matcher.appendTail(sb);

		Matcher matcher2 = Pattern.compile(Pattern.quote(stdcs.toString()) + "\\d").matcher(sb.toString());
		sb = new StringBuffer();
		while (matcher2.find()) {
			int index = Integer.parseInt(matcher2.group(0).substring(1));
			if(index >= 0 && index < args.length) {
				if (!args[index].toString().contains(stde)) { matcher2.appendReplacement(sb, Matcher.quoteReplacement(args[index].toString())); }
				else {
					String[] splits = args[index].toString().split(stde);
					String replace = splits[0];
					String format = (splits.length > 1) ? splits[1] : "";
					String[] formatter = format.split(", *");
					for (String formats : formatter) {
						if (replace != null) {
							replace = applyFormat(formats, replace);
							matcher2.appendReplacement(sb, Matcher.quoteReplacement(replace));
						} else {
							matcher2.appendReplacement(sb, Matcher.quoteReplacement(replace));
						}
					}
				}
			} else { matcher2.appendReplacement(sb, Matcher.quoteReplacement("NOT-ARGUMENT")); }
		}
		matcher2.appendTail(sb);
		return sb.toString();
	}

	private String applyFormat(String formatType, String text) {
		switch (formatType) {
			case "UpperCase": return text.toUpperCase();
			case "LowerCase": return text.toLowerCase();
			case "UpperCaseFirst": return text.substring(0, 1).toUpperCase() + text.substring(1);
			case "LowerCaseFirst": return text.substring(0, 1).toLowerCase() + text.substring(1);
			case "UpperCaseFirstLowerCase": return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
			case "LowerCaseFirstUpperCase": return text.substring(0, 1).toLowerCase() + text.substring(1).toUpperCase();
			case "Reverse": return new StringBuilder(text).reverse().toString();
			default: return text;
		}
	}
}
