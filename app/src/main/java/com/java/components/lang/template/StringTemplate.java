package com.java.components.lang.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.java.components.lang.CompilerTaskException;

public class StringTemplate { // StringTemplate Support
	// ---------- CreateObj : Start ---------- \\
	public static final String NAME = "StringTemplate";
	private static final String TAG = NAME;
	public static final String VERSION = "1.0.0";
	private Map<Object, Object> replacements;
	private StringTemplateDelimiter delimiter = new StringTemplateDelimiter("${", ":", "};");
	private String start = this.delimiter.getStartDelimiter();
	private String condition = this.delimiter.getConditionDelimiter();
	private String end = this.delimiter.getEndDelimiter();
	private StringTemplateDelimiter singleDelimiter = new StringTemplateDelimiter('$');
    private Character stdcs = this.singleDelimiter.getSingleStartDelimiter();
	private String template;
	// ---------- CreateObj : End ---------- \\

	// ---------- Constructor|ctor : Start ---------- \\
	public StringTemplate() {}
	
	public StringTemplate(String str) {
		this.template = str;
		this.replacements = new HashMap<>();
	}

	public StringTemplate(List<?> list) {
		StringBuilder stringBuilder = new StringBuilder();
		for(Object obj : list) {
			stringBuilder.append(obj);
		}
		this.template = stringBuilder.toString();
	}

	public StringTemplate(Object[] objArr) {
		StringBuilder stringBuilder = new StringBuilder();
		for(Object obj : objArr) {
			stringBuilder.append(obj);
		}
		this.template = stringBuilder.toString();
	}

	public StringTemplate(String str, StringTemplateDelimiter sTDs) {
		this.delimiter = sTDs;
		this.template = str;
		this.replacements = new HashMap<>();
	}

	public StringTemplate(List<?> list, StringTemplateDelimiter sTDs) {
		this.delimiter = sTDs;
		StringBuilder stringBuilder = new StringBuilder();
		for(Object obj : list) {
			stringBuilder.append(obj);
		}
		this.template = stringBuilder.toString();
	}

	public StringTemplate(Object[] objArr, StringTemplateDelimiter sTDs) {
		this.delimiter = sTDs;
		StringBuilder stringBuilder = new StringBuilder();
		for(Object obj : objArr) {
			stringBuilder.append(obj);
		}
		this.template = stringBuilder.toString();
	}
	// ---------- Constructor|ctor : Start ---------- \\

	// ---------- Delimiter : Start ---------- \\
	public StringTemplate setDelimiter(StringTemplateDelimiter sTDs) {
        this.delimiter = sTDs;
        return this;
    }

	public StringTemplate setStartDelimiters(String str) {
        this.condition = str;
        return this;
    }

	public StringTemplate setConditionsDelimiters(String str) {
        this.start = str;
        return this;
    }

	public StringTemplate setEndDelimiters(String str) {
        this.end = str;
        return this;
    }
    
    public StringTemplate setSingleStartDelimiters(Character c) {
        this.stdcs = c;
        return this;
    }
	// ---------- Delimiter : End ---------- \\

	// ---------- set : Start ---------- \\
	public StringTemplate set(String str, String obj) {
		if (str == null) {
			throw new CompilerTaskException("The template '" + str + "' it is not found or does not exist.", new Exception[] {
				new NoSuchElementException(),
				new IllegalArgumentException(),
				new IllegalAccessException()
			});
		} else if (str.startsWith(".")) {
			throw new CompilerTaskException("The template you want to find start with '.'", new Exception[] {
				new IllegalArgumentException(),
				new IllegalAccessException()
			});
			// throw new IllegalArgumentException("Your 'Template' start with in '.'");
		} else if (str.endsWith(".")) {
			throw new CompilerTaskException("The template you want to find end with '.'", new Exception[] {
				new IllegalArgumentException(),
				new IllegalAccessException()
			});
			// throw new IllegalArgumentException("Your 'Template' end with in '.'");
		} else {
			this.replacements.put(str, obj);
			return this;
		}
	}

	public StringTemplate set(String str, List<?> list) {
		if (str == null) {
			throw new NoSuchElementException("template not found!");
		} else if (str.startsWith(".")) {
			throw new IllegalArgumentException("Your 'Template' start with in '.'");
		} else if (str.endsWith(".")) {
			throw new IllegalArgumentException("Your 'Template' end with in '.'");
		} else {
			StringBuilder stringBuilder = new StringBuilder();
			for(Object obj : list) {
				stringBuilder.append(obj);
			}
			this.replacements.put(str, stringBuilder);
			return this;
		}
	}

	public StringTemplate set(String str, Object... objArray) {
		if (str == null) {
			throw new NoSuchElementException("template not found!");
		} else if (str.startsWith(".")) {
			throw new IllegalArgumentException("Your 'Template' start with in '.'");
		} else if (str.endsWith(".")) {
			throw new IllegalArgumentException("Your 'Template' end with in '.'");
		} else {
			StringBuilder stringBuilder = new StringBuilder();
			for(Object obj : objArray) {
				stringBuilder.append(obj);
			}
			this.replacements.put(str, stringBuilder);
			return this;
		}
	}

	public StringTemplate set(String[] strArray, String str2) {
		for(String str : strArray) {
			if (str == null) {
				throw new NoSuchElementException("template not found!");
			} else if (str.startsWith(".")) {
				throw new IllegalArgumentException("Your 'Template' start with in '.'");
			} else if (str.endsWith(".")) {
				throw new IllegalArgumentException("Your 'Template' end with in '.'");
			} else {
				this.replacements.put(str, str2);
			}
		}
		return this;
	}

	public StringTemplate set(String[] strArray, Object... objArray) {
		for(String str : strArray) {
			if (str == null) {
				throw new NoSuchElementException("template not found!");
			} else if (str.startsWith(".")) {
				throw new IllegalArgumentException("Your 'Template' start with in '.'");
			} else if (str.endsWith(".")) {
				throw new IllegalArgumentException("Your 'Template' end with in '.'");
			} else {
				StringBuilder stringBuilder = new StringBuilder();
				for(Object obj : objArray) {
					stringBuilder.append(obj);
				}
				this.replacements.put(str, stringBuilder);
			}
		}
		return this;
	}

	public StringTemplate set(String[] strArray, List<?> list) {
		for(String str : strArray) {
			if (str == null) {
				throw new NoSuchElementException("template not found!");
			} else if (str.startsWith(".")) {
				throw new IllegalArgumentException("Your 'Template' start with in '.'");
			} else if (str.endsWith(".")) {
				throw new IllegalArgumentException("Your 'Template' end with in '.'");
			} else {
				StringBuilder stringBuilder = new StringBuilder();
				for(Object obj : list) {
					stringBuilder.append(obj);
				}
				this.replacements.put(str, stringBuilder);
			}
		}
		return this;
	}

	public StringTemplate set(List<String> list, String str2) {
		for(String str : list) {
			if (str == null) {
				throw new NoSuchElementException("template not found!");
			} else if (str.startsWith(".")) {
				throw new IllegalArgumentException("Your 'Template' start with in '.'");
			} else if (str.endsWith(".")) {
				throw new IllegalArgumentException("Your 'Template' end with in '.'");
			} else {
				this.replacements.put(str, str2);
			}
		}
		return this;
	}

	public StringTemplate set(List<String> list, Object... objArray) {
		for(String str : list) {
			if (str == null) {
				throw new NoSuchElementException("template not found!");
			} else if (str.startsWith(".")) {
				throw new IllegalArgumentException("Your 'Template' start with in '.'");
			} else if (str.endsWith(".")) {
				throw new IllegalArgumentException("Your 'Template' end with in '.'");
			} else {
				StringBuilder stringBuilder = new StringBuilder();
				for(Object obj : objArray) {
					stringBuilder.append(obj);
				}
				this.replacements.put(str, stringBuilder);
			}
		}
		return this;
	}

	public StringTemplate set(List<String> list, List<?> list2) {
		for(String str : list) {
			if (str == null) {
				throw new NoSuchElementException("template not found!");
			} else if (str.startsWith(".")) {
				throw new IllegalArgumentException("Your 'Template' start with in '.'");
			} else if (str.endsWith(".")) {
				throw new IllegalArgumentException("Your 'Template' end with in '.'");
			} else {
				StringBuilder stringBuilder = new StringBuilder();
				for(Object obj : list2) {
					stringBuilder.append(obj);
				}
				this.replacements.put(str, stringBuilder);
			}
		}
		return this;
	}

	// ---------- set : End ---------- \\

	// ---------- add|append : Start ---------- \\
	public StringTemplate append(Object obj) {
		this.template += obj.toString();
		return this;
	}

	public StringTemplate append(Object... objArr) {
		for (Object obj : objArr) {
			this.template += obj.toString();
		}
		return this;
	}

	public StringTemplate append(List<?> list) {
		for (Object obj : list) {
			this.template += obj.toString();
		}
		return this;
	}
	// ---------- add|append : End ---------- \\

	// ---------- remove : Start ---------- \\
	public StringTemplate remove(String str) {
		if (str == null) {
			throw new NoSuchElementException("template not found!");
		} else if (str.startsWith(".")) {
			throw new IllegalArgumentException("Your 'Template' start with in '.'");
		} else if (str.endsWith(".")) {
			throw new IllegalArgumentException("Your 'Template' end with in '.'");
		} else {
			this.replacements.remove(str);
			return this;
		}
	}

	public StringTemplate remove(Object... objArray) {
		for(Object obj : objArray) {
			if (obj == null) {
				throw new NoSuchElementException("template not found!");
			} else if (((String)obj).startsWith(".")) {
				throw new IllegalArgumentException("Your 'Template' start with in '.'");
			} else if (((String)obj).endsWith(".")) {
				throw new IllegalArgumentException("Your 'Template' end with in '.'");
			} else {
				this.replacements.remove(obj);
			}
		}
		return this;
	}

	public StringTemplate remove(List<?> list) {
		for(Object obj : list) {
			if (obj == null) {
				throw new NoSuchElementException("template not found!");
			} else if (((String)obj).startsWith(".")) {
				throw new IllegalArgumentException("Your 'Template' start with in '.'");
			} else if (((String)obj).endsWith(".")) {
				throw new IllegalArgumentException("Your 'Template' end with in '.'");
			} else {
				this.replacements.remove(obj);
			}
		}
		return this;
	}
	// ---------- remove : End ---------- \\

	// ---------- clear : Start ---------- \\
	public void clearAll() {
		this.replacements.clear();
		this.template = "";
	}

	public StringTemplate clearTemplate() {
		this.template = "";
		return this;
	}

	public StringTemplate clearSets() {
		this.replacements.clear();
		return this;
	}

	public StringTemplate clearDelimiter() {
		this.delimiter = new StringTemplateDelimiter("${", ":", "}");
		this.singleDelimiter = new StringTemplateDelimiter('$');
		return this;
	}
	// ---------- clear : End ---------- \\

	// ---------- Compiler : Start ---------- \\
	public String fillTemplate(Object... arg) {
		Matcher matcher1 = Pattern.compile(Pattern.quote(this.condition) + "(.*?)" + Pattern.quote(this.end)).matcher(this.template);
		StringBuffer stringBuffer = new StringBuffer();
		while (matcher1.find()) {
			String[] split = (matcher1.group(1) != null ? matcher1.group(1) : "").split(this.start);
			Object obj = split[0];
			String str = split.length > 1 ? split[1] : split.length == 1 ? null : split[2];
			String str2 = split.length > 2 ? split[2] : null;
			String str3 = this.replacements.get(obj).toString();
			if (str3 == null && str != null) {
				str3 = str;
			}
			if (str != null) {
				str3 = str2 != null ? applyFormat(str2, str3) : applyFormat(str, str3);
			}
			matcher1.appendReplacement(stringBuffer, str3 != null ? Matcher.quoteReplacement(str3) : "NOT-ARGS");
		}
		matcher1.appendTail(stringBuffer);
		Matcher matcher2 = Pattern.compile(Pattern.quote(this.stdcs.toString()) + "\\d+").matcher(stringBuffer.toString());
		stringBuffer = new StringBuffer();
		while (matcher2.find()) {
			int index = Integer.parseInt(matcher2.group().substring(1));
			if (index >= 0 && index < arg.length) {
				if (!arg[index].toString().contains(":")) matcher2.appendReplacement(stringBuffer, Matcher.quoteReplacement(arg[index].toString()));
				else {
					String[] splits = arg[index].toString().split(this.start);
					String str = splits[0];
					String str2 = splits[1];
                    String[] formatter = str2.split(",");
                    for(int i = 0; i < formatter.length; ++i) {
                    	if(str != null) {
					    	str = applyFormat(formatter[i] != null ? formatter[i] : "", str);
					    	matcher2.appendReplacement(stringBuffer, str);
				    	} else {
					    	matcher2.appendReplacement(stringBuffer, str);
				    	}
                    }
				}
			} else {
				matcher2.appendReplacement(stringBuffer, "NOT-ARGS");
			}
		}
		matcher2.appendTail(stringBuffer);
		return stringBuffer.toString();
	}

	private String applyFormat(String str, String str2) {
		if (str.equals("uppercase")) return str2.toUpperCase();
		if (str.equals("lowercase")) return str2.toLowerCase();
		if (str.equals("reverse")) return new StringBuilder(str2).reverse().toString();
		if (str.startsWith("decimals(") && str.endsWith(")")) {
			try {
				int decimalPlaces = Integer.parseInt(str.substring(9, str.length() - 1));
				try { return String.format("%." + decimalPlaces + "f", (Double) Double.parseDouble(str2)); } catch (NumberFormatException e) { return "\"Format Invalid\" or \"Wrong Number Format\" in: '" + str2 + "' or '" + e.getLocalizedMessage() + "'"; }
			} catch (NumberFormatException e) {
				return "Invalid number of decimal places: " + e.getMessage();
			}
		}
		return str2;
	}
	// ---------- Compiler : End ---------- \\
}
	// ---------- NAME : Start ---------- \\

	// ---------- NAME : End ---------- \\