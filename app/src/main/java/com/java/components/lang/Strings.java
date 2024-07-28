package com.java.components.lang;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;

import com.java.components.util.function.*;

public class Strings {
	private String text;

	public Strings(String text) { this.text = text; }

	public Strings() {}
	public String append(String str) {
		String text = this.text;
		return text += str;
	}

	public String appends(String... strs) { return concats(strs); }

	public String concats(String... args) {
		String text = this.text;
		for (int i = 0; i < args.length; i++) text += args[i]; 
		return text;
	}

	public String append(String str, int index) { return text.substring(0, index) + str + text.substring(index, text.length()); }

	public String appends(int index, String... strs) {
		StringBuilder sb = new StringBuilder();
		sb.append(text.substring(0, index));
		for (String s : strs) sb.append(s);
		sb.append(text.substring(index, text.length()));
		return sb.toString();
	}

	public String delete(int index) { return text.substring(0, index) + text.substring(index + 1, text.length()); }

	public String delete(int startIndex, int endIndex) {
		if(endIndex > startIndex) {
			int temp = startIndex;
			startIndex = endIndex;
			endIndex = temp;
		}
		return text.substring(0, startIndex) + text.substring(endIndex, text.length());
	}

	public String padStart(String text) {
		StringBuilder stringBuilder = new StringBuilder(text);
		stringBuilder.append(this.text);
		return stringBuilder.toString();
	}

	public String padEnd(String text) {
		StringBuilder stringBuilder = new StringBuilder(this.text);
		stringBuilder.append(text);
		return stringBuilder.toString();
	}

	public String repeat(int count) {
		StringBuilder stringBuilder = new StringBuilder(this.text);
		for (int i = 0; i < count; i++) stringBuilder.append(this.text);
		return stringBuilder.toString();
	}

	public String repeat(String text, int count) {
		StringBuilder stringBuilder = new StringBuilder(this.text);
		for (int i = 0; i < count; i++) stringBuilder.append(text);
		return stringBuilder.toString();
	}

	public boolean startsWith(char c) { return startsWith(c, 0); }

	public boolean startsWith(char c, int fromIndex) { return c == this.text.charAt(fromIndex == 0 ? 0 : fromIndex - 1); }

	public boolean endsWith(char c) { return endsWith(c, 1); }

	public boolean endsWith(char c, int fromIndex) { return startsWith(c, (this.text.length() + 1) - fromIndex); }

	public boolean startsWithIgnoreCase(String start) { return text.toLowerCase().startsWith(start.toLowerCase()); }

	public boolean endsWithIgnoreCase(String end) { return text.toLowerCase().endsWith(end.toLowerCase()); }

	public boolean startsEndsWith(String start, String end) { return text.startsWith(start) && text.endsWith(end); }

	public boolean startsEndsWith(String start, int toffsetStart, String end) { return text.startsWith(start, toffsetStart) && text.endsWith(end); }

	public boolean startsEndsWith(String start, String end, int toffsetEnd) { return text.startsWith(start) && endsWith(end, toffsetEnd); }

	public boolean startsEndsWith(String start, int toffsetStart, String end, int toffsetEnd) { return text.startsWith(start, toffsetStart) && endsWith(end, toffsetEnd); }

	public boolean startsEndsWith(int toffsetAll, String start, String end) { return text.startsWith(start, toffsetAll) && endsWith(end, toffsetAll); }

	@Deprecated public boolean startsEndsWith(int toffsetAll, String start, int toffsetStart, String end, int toffsetEnd) { return text.startsWith(start, toffsetAll + toffsetStart) && endsWith(end, toffsetAll + toffsetEnd); }

	@Deprecated public boolean startsEndsWith(int toffsetAll, String start, String end, int toffsetEnd) { return text.startsWith(start, toffsetAll) && endsWith(end, toffsetAll + toffsetEnd); }

	@Deprecated public boolean startsEndsWith(int toffsetAll, String start, int toffsetStart, String end) { return text.startsWith(start, toffsetAll + toffsetStart) && endsWith(end, toffsetAll); }

	public boolean middlesWith(String middle) {
		int textLength = text.length();
		int middleLength = middle.length();
		if(textLength < middleLength) return false;
		int middleIndex = (textLength - middleLength) / 2;
		return text.substring(middleIndex, middleIndex + middleLength).equals(middle);
	}

	public boolean middlesWithIgnoreCase(String middle) {
		int textLength = text.length();
		int middleLength = middle.length();
		if(textLength < middleLength) return false;
		int middleIndex = (textLength - middleLength) / 2;
		return text.substring(middleIndex, middleIndex + middleLength).toLowerCase().equals(middle.toLowerCase());
	}

	public String replaceBegin(String targetBegin, String replacement) {
		if(text.startsWith(targetBegin)) return replacePrefix(targetBegin.length(), replacement);
		return text;
	}

	public String replaceEnd(String targetEnd, String replacement) {
		if(text.endsWith(targetEnd)) return replaceSuffix(shortLength(targetEnd.length()), replacement);
		return text;
	}

	public String replacePrefix(int start, String replacement) { return replace(0, start, replacement); }

	public String replaceSuffix(int end, String replacement) { return replace(shortLength(end), text.length(), replacement); }

	String escapeToNormal(String escapeText) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < escapeText.length(); i++) {
			switch (escapeText.charAt(i)) {
				case '?': { builder.append("\\" + escapeText.charAt(i)); break; }
				case '+': { builder.append("\\" + escapeText.charAt(i)); break; }
				case '-': { builder.append("\\" + escapeText.charAt(i)); break; }
				case '*': { builder.append("\\" + escapeText.charAt(i)); break; }
				case '(': { builder.append("\\" + escapeText.charAt(i)); break; }
				case ')': { builder.append("\\" + escapeText.charAt(i)); break; }
				case '[': { builder.append("\\" + escapeText.charAt(i)); break; }
				case ']': { builder.append("\\" + escapeText.charAt(i)); break; }
				case '{': { builder.append("\\" + escapeText.charAt(i)); break; }
				case '}': { builder.append("\\" + escapeText.charAt(i)); break; }
				case '\\': { builder.append("\\" + escapeText.charAt(i) + escapeText.charAt(i)); break; }
				case '|': { builder.append("\\" + escapeText.charAt(i)); break; }
				case '$': { builder.append("\\" + escapeText.charAt(i)); break; }
				default: { builder.append(escapeText.charAt(i)); break; }
			}
		}
		return builder.toString();
	}

	public String replaceAll(String target, OneFunction<String, String> replacer) {
		Matcher matcher = Pattern.compile(target).matcher(this.text);
		StringBuffer result = new StringBuffer();
		while(matcher.find()) {
			String match = matcher.group();
			String replacement = replacer.apply(match);
			matcher.appendReplacement(result, escapeToNormal(replacement));
		}
		matcher.appendTail(result);
		return result.toString();
	}

	public String replace(String targetArray[], String replacementArray[]) {
		if(targetArray.length != replacementArray.length) throw new CompilerTaskException("Irregular pair in the arrays parameters.");
		String text = this.text;
		for(int i = 0; i < targetArray.length; i++) text = text.replace(targetArray[i], replacementArray[i]);
		return text;
	}

	public String replace(String targetArray[], String replacement) {
		String text = this.text;
		for(int i = 0; i < targetArray.length; i++) text = text.replace(targetArray[i], replacement);
		return text;
	}

	public String replace(String target, String replacement, int countReplace) {
		String text = this.text;
		replacement = replacement.replace("$&", target);
		while (countReplace > 0) {
			text = text.replaceFirst(target, replacement);
			countReplace--;
		}
		return text;
	}

	public String replace(String target, int position, String replacement) {
		String text = this.text;
		replacement = replacement.replace("$&", target);
		int startIndex = text.indexOf(target);
		while (position > 0 && startIndex != -1) {
			startIndex = text.indexOf(target, startIndex + 1);
			position--;
		}
		if(startIndex == -1) return text;
		StringBuilder stringBuilder = new StringBuilder(text);
		stringBuilder.replace(startIndex, startIndex + target.length(), replacement);
		return stringBuilder.toString();
	}

	public String replace(String target, int position, String replacement, int countReplace) {
		String text = this.text;
		replacement = replacement.replace("$&", target);
		while (countReplace > 0) {
			text = replace(target, position, replacement);
			countReplace--;
		}
		return text;
	}

	public String replaceFirst(String target, String replacement, int countReplace) {
		String text = this.text;
		replacement = replacement.replace("$&", target);
		while (countReplace > 0) {
			text = text.replaceFirst(target, replacement);
			countReplace--;
		}
		return text;
	}

	public String replaceLast(String target, String replacement) {
		String text = this.text;
		replacement = replacement.replace("$&", target);
		int index = text.indexOf(target, text.indexOf(target) + target.length());
		if (index < 0) return text;
		text = text.substring(0, index) + replacement + text.substring(index + target.length());
		return text;
	}

	public String replace(int start, int end, String replacement) {
		String text = this.text;
		String temp = replacement.replace("$&", "").replaceAll(" *", "");
		replacement = replacement.replace("$&", temp);
		String subtext = text.substring(start, end);
		text = text.replaceFirst(subtext, replacement);
		return text;
	}

	public String replaceLast(String target, String replacement, int countReplace) {
		String text = this.text;
		replacement = replacement.replace("$&", target);
		while (countReplace > 0) {
			countReplace--;
			text = replaceLast(target, replacement);
		}
		return text;
	}

	public int indexOf(int position, String str) { return indexOf(position, str, 0); }

	public int indexOf(int position, String str, int fromIndex) {
		int startIndex = text.indexOf(str, fromIndex);
		while (position > 0) {
			startIndex = text.indexOf(str, startIndex + 1);
			position--;
		}
		return startIndex;
	}

	public int indexOf(String str, boolean indexInvert) {
		int startIndex = text.indexOf(str);
		return indexInvert ? startIndex + str.length() : startIndex;
	}

	public String[] split(int splitIndex) { return split(splitIndex, 0); }

	public boolean endsWith(String suffix, int toffset) { return text.startsWith(suffix, text.length() - suffix.length() - toffset); }

	public String[] split(int splitIndex, int splitCount) {
		String text = this.text;
		int missing = text.length() % splitIndex;
		String[] result = new String[splitCount == 0 ? (missing != 0 ? (text.length() / splitIndex) + 1 : text.length() / splitIndex) : splitCount];
		for (int i = 0; i < result.length; i++) {
			int j = (i + 1) * splitIndex;
			result[i] = text.substring(i * splitIndex, j < text.length() ? j : text.length());
		}
		return result;
	}

	public String[] cut(int cutIndex) { return split(cutIndex, 2); }

	public String slide(int startIndex) {
		if(startIndex < 0) return slide(0, -startIndex);
		return slide(startIndex, text.length());
	}

	public String slide(int startIndex, int endIndex) {
		if(startIndex <= 0 && endIndex <= 0) {
			if(startIndex > endIndex) return substring(text.length() + endIndex, text.length() + startIndex, false);
			return substring(text.length() + startIndex, text.length() + endIndex,false);
		} else {
			if(startIndex > endIndex) return substring(endIndex, startIndex, false);
			return substring(startIndex, endIndex, false);
		}
	}

	public int lastIndexOf(String str, boolean indexInvert) {
		int startIndex = text.lastIndexOf(str);
		return indexInvert ? startIndex + str.length() : startIndex;
	}

	public String prefix(int prefix) { return text.substring(0, prefix); }

	public String suffix(int suffix) { return text.substring(text.length() - suffix, text.length()); }

	public String substring(String string) { return substring(string, false); }

	public String substring(String string, boolean substringInvert) {
		String text = this.text;
		int indexStart = text.indexOf(string);
		int indexEnd = indexStart + string.length();
		text = substring(indexStart, indexEnd, substringInvert);
		return text;
	}

	public String substring(int startIndex, int endIndex, boolean substringInvert) {
		String text = this.text;
		return substringInvert ? text.substring(0, startIndex) + text.substring(endIndex) : text.substring(startIndex, endIndex);
	}

	public String substr(int index, int length) { return substring(index, index + length, false); }

	public String substr(int index) { return substring(index, text.length(), false); }

	public boolean containsIgnoreCase(String subString) { return text.toLowerCase().contains(subString.toLowerCase()); }

	// public String formatted(Object... args) { return new Formatter().format(text, args); }
	
	// public static String format(String format, Object... args) { return new Strings(format).formatted(args); }

	public static String join(CharSequence prefix, CharSequence suffix, CharSequence delimiter, CharSequence... args) { return join(prefix, suffix, delimiter, 0, args); }

	public static String join(CharSequence delimiter, int limit, CharSequence... args) { return join("", "", delimiter, limit + 1, args); }

	public static String join(CharSequence prefix, CharSequence suffix, CharSequence delimiter, int limit, CharSequence... args) { return join(prefix, suffix, delimiter, -1, limit + 1, args); }

	public static String join(CharSequence prefix, CharSequence suffix, CharSequence delimiter, int limitLengthCharSequence, int limit, CharSequence... args) {
		StringBuilder parts = new StringBuilder();
		limit = limit == 0 ? args.length : limit;
		for(int i = 0; i < limit; i++) if(limitLengthCharSequence == args[i].length() || limitLengthCharSequence == -1) parts.append(((String) prefix) + ((String) args[i]) + ((String) suffix) + ((String) delimiter));
		if(parts.length() > 2) parts.delete(parts.length() - 1, parts.length());
		return parts.toString();
	}

	public ArrayList<Character> toCharArrayList() {
		char[] chars = new char[text.length()];
		for(int i = 0; i < text.length(); i++) chars[i] = text.charAt(i);
		ArrayList<Character> result = new ArrayList<>();
		for(int i = 0; i < text.length(); i++) result.add(chars[i]);
		return result;
	}

	public HashMap<Integer, Character> toCharHashMap() {
		char[] chars = new char[text.length()];
		for(int i = 0; i < text.length(); i++) chars[i] = text.charAt(i);
		HashMap<Integer, Character> map = new HashMap<>();
		for (int i = 0; i < chars.length; i++) map.put(i, chars[i]);
		return map;
	}

	public boolean isNull() { return this.text == null; }

	public static boolean isNull(String str) { return str == null; }

	public String reverse() { return new StringBuilder(text).reverse().toString(); }

	public static String reverse(String str) { return new StringBuilder(str).reverse().toString(); }

	public String difference(String other) {
		StringBuilder diff = new StringBuilder();
		for(int i = 0; i < Math.min(text.length(), other.length()); i++) if(text.charAt(i) != other.charAt(i)) diff.append(text.charAt(i) + " != " + other.charAt(i) + ", index: " + i + "\n");
		if(other.length() > text.length()) diff.append(other.substring(text.length()));
		return diff.toString();
	}

	public boolean isLowerCase() {
		for(char c : text.toCharArray()) if(Character.isLetter(c) && !Character.isLowerCase(c)) return false; 
		return true;
	}

	public boolean isUpperCase() {
		for(char c : text.toCharArray()) if(Character.isLetter(c) && !Character.isUpperCase(c)) return false;
		return true;
	}

	public char firstCharacter() { return text.charAt(0); }

	public char lastCharacter() { return text.charAt(text.length() - 1); }

	public char middleCharacter() { return text.charAt(text.length() / 2); }

	public String skip(String delimiter) {
		String text = this.text;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < delimiter.length(); i++) {
			switch (delimiter.charAt(i)) {
				case '?': { builder.append("\\" + delimiter.charAt(i) + "|"); break; }
				case '+': { builder.append("\\" + delimiter.charAt(i) + "|"); break; }
				case '-': { builder.append("\\" + delimiter.charAt(i) + "|"); break; }
				case '*': { builder.append("\\" + delimiter.charAt(i) + "|"); break; }
				case '(': { builder.append("\\" + delimiter.charAt(i) + "|"); break; }
				case ')': { builder.append("\\" + delimiter.charAt(i) + "|"); break; }
				case '[': { builder.append("\\" + delimiter.charAt(i) + "|"); break; }
				case ']': { builder.append("\\" + delimiter.charAt(i) + "|"); break; }
				case '{': { builder.append("\\" + delimiter.charAt(i) + "|"); break; }
				case '}': { builder.append("\\" + delimiter.charAt(i) + "|"); break; }
				case '\\': { builder.append("\\" + delimiter.charAt(i) + delimiter.charAt(i) + "|"); break; }
				case '|': { builder.append("\\" + delimiter.charAt(i) + "|"); break; }
				case '$': { builder.append("\\" + delimiter.charAt(i) + "|"); break; }
				default: { builder.append(delimiter.charAt(i) + "|"); break; }
			}
		}
		if (builder.length() > 1) builder.delete(builder.length() - 1, builder.length());
		text = text.replaceAll(builder.toString(), "");
		return text;
	}

	public String template(Object clazz) {
		Matcher matcher = Pattern.compile(Pattern.quote("${") + "(.*?)" + Pattern.quote("};")).matcher(text);
		StringBuffer stringBuilder = new StringBuffer();
		while(matcher.find()) {
			Field[] fields = clazz.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				if(field.getName().equals(matcher.group(1))) {
					try {
						Object valueField = field.get(clazz);
						setValue(matcher, stringBuilder, valueField);
					} catch (Exception e) {}
				}
			}
		}
		matcher.appendTail(stringBuilder);
		return stringBuilder.toString();
	}

	private void setValue(Matcher matcher, StringBuffer stringBuilder, Object valueField) {
		if (valueField instanceof String v) matcher.appendReplacement(stringBuilder,  v);
		else if (valueField instanceof Character v) matcher.appendReplacement(stringBuilder,  String.valueOf(v));
		else if (valueField instanceof Boolean v) matcher.appendReplacement(stringBuilder,  String.valueOf(v));
		else if (valueField instanceof Integer v) matcher.appendReplacement(stringBuilder,  String.valueOf(v));
		else if (valueField instanceof Short v) matcher.appendReplacement(stringBuilder,  String.valueOf(v));
		else if (valueField instanceof Byte v) matcher.appendReplacement(stringBuilder,  String.valueOf(v));
		else if (valueField instanceof Long v) matcher.appendReplacement(stringBuilder,  String.valueOf(v));
		else if (valueField instanceof Double v) matcher.appendReplacement(stringBuilder,  String.valueOf(v));
		else if (valueField instanceof Float v) matcher.appendReplacement(stringBuilder,  String.valueOf(v));
	}

	public int shortLength(int cutLength) { return text.length() - cutLength; }

	@Override
	public String toString() { return text; }
}
