package com.java.components.util;

/* 
import static com.java.components.Prints.*;

import java.util.*;
import java.util.regex.*;

import com.java.components.lang.StringBuilder;

public class StringTokenizer {
	private String[] tokens;
	private String delimiter;
	private String[] delimiterTokens;
	private int currentPosition = 0;
	private boolean returnDelim;
	private String str;

	public StringTokenizer() {}

	public StringTokenizer(String str) { this(str, " \t\r\f\n"); }

	public StringTokenizer(String str, boolean returnDelim) { this(str, " \t\r\f\n", returnDelim); }

	public StringTokenizer(String str, int limit) { this(str, " \t\r\f\n", limit); }

	public StringTokenizer(String str, String delimiter) { this(str, delimiter, false); }

	public StringTokenizer(String str, String delimiter, int limit) { this(str, delimiter, false, limit); }

	public StringTokenizer(String str, String delimiter, boolean returnDelim) { this(str, delimiter, returnDelim, 0); }

	public StringTokenizer(String str, String delimiter, boolean returnDelim, int limit) {
		StringBuilder sb = new StringBuilder();
		if(delimiter.length() > 1) {
			String[] delimiterParts = (delimiter.replace("|", "\\|")).split("");
			for (int i = 0; i < delimiterParts.length; i++) sb.append(test(delimiterParts[i])).append("|");
			if(sb.length() > 2) sb.delete(sb.length() - 1, sb.length());
		} else sb.append(delimiter);
		this.tokens = str.split(sb.toString(), limit >= 1 ? limit + 1 : 0);
		if(tokens[0].length() == 0) removeToken(0);
		this.delimiter = delimiter;
		this.returnDelim = returnDelim;
		this.currentPosition = 0;
		this.str = str;
		// delimiterTokens = new String[getAllTokensDelimiter().length()];
		if(getAllTokensDelimiter().length() > 1) delimiterTokens = getAllTokensDelimiter().split("");
		else if(delimiter.length() == 1) delimiterTokens[0] = delimiter;
	}

	private String test(String text) {
		switch(text) {
			case "{": { text = "\\{"; break; }
			case "}": { text = "\\}"; break; }
			case "[": { text = "\\["; break; }
			case "]": { text = "\\]"; break; }
			case "(": { text = "\\("; break; }
			case ")": { text = "\\)"; break; }
			case "+": { text = "\\+"; break; }
			case "-": { text = "\\-"; break; }
			case "?": { text = "\\?"; break; }
			case "*": { text = "\\*"; break; }
			case "\\": { text = "\\\\"; break; }
			case "|": { text = "\\|"; break; }
			case ".": { text = "\\."; break; }
		}
		return text;
	}

	public boolean hasNextMoreTokens() { return (currentPosition < tokens.length); }

	public boolean hasPreviouMoreTokens() { return (currentPosition != 0); }

	public void nextIndex() { currentPosition++; }

	public String nextTokenAndSkip(String skip) {
		if (!hasNextMoreTokens()) throw new IllegalArgumentException("No hay más tokens disponibles");
		String skipText = returnDelim ? (
			tokens[currentPosition].equals("") && tokens.length == currentPosition ? tokens[currentPosition + 2] : tokens[currentPosition++] + getTokenDelimiter()
		) : (
			tokens[currentPosition].length() == 0 ? tokens[currentPosition + 2] : tokens[currentPosition++]
		);
		StringBuilder s = new StringBuilder(skipText);
		return s.skip(skip).toString();
	}

	public String nextToken() {
		if (!hasNextMoreTokens()) throw new IllegalArgumentException("No hay más tokens disponibles");
		return returnDelim ? (
			tokens[currentPosition].equals("") && tokens.length == currentPosition ? tokens[currentPosition + 2] : tokens[currentPosition++] + getTokenDelimiter()
		) : (
			tokens[currentPosition].length() == 0 ? tokens[currentPosition + 2] : tokens[currentPosition++]
		);
	}

	public void previouIndex() { currentPosition--; }

	public String previouToken() {
		return previouTokenAndSkip("");
	}

	int i = 0;

	public String previouTokenAndSkip(String skips) {
		if (!hasPreviouMoreTokens()) throw new IllegalArgumentException("No hay menos tokens disponibles");
		--currentPosition;
		if(i == 0) {
			--currentPosition;
			i++;
		}
		String textSkip = returnDelim ? (
			tokens[currentPosition].length() == 0 ? tokens[currentPosition--] : tokens[currentPosition] + getTokenDelimiter()
		) : (
			tokens[currentPosition].length() == 0 ? tokens[currentPosition--] : tokens[currentPosition]
		);
		StringBuilder s = new StringBuilder(textSkip);
		return s.skip(skips).toString();
	}

	public String getToken(String text) {
		while(hasNextMoreTokens()) {
			String token = nextToken();
			if (token != null) {if (text.equals(token)) return token;}
			else break;
		}
		while(hasPreviouMoreTokens()) {
			String token = previouToken();
			if (token != null) {if (text.equals(token)) return token;}
			else break;
		}
		return null;
	}

	public String getToken(int position) {
		while(currentPosition < position) nextIndex();
		while(currentPosition > position) previouIndex();
		return getCurrentToken();
	}

	public String getNextToken(String text) {
		while(hasNextMoreTokens()) {
			String token = nextToken();
			if(text.equals(token)) return token;
		}
		return null;
	}

	public String getNextToken(int position) {
		int c = 0;
		while(hasNextMoreTokens()) {
			String token = nextToken();
			if(position == c) return token;
			else c++;
		}
		return null;
	}

	public String getNextToken(String text, int index) {
		while(hasNextMoreTokens()) {
			String token = nextToken();
			if(text.equals(token))
				if(index == 0) return token;
				else index--;
		}
		return null;
	}

	public String getPreviouToken(String text) {
		while(hasPreviouMoreTokens()) {
			String token = previouToken();
			if(text.equals(token)) return token;
		}
		return null;
	}

	public String getPreviouToken(int position) {
		int c = 0;
		while(hasPreviouMoreTokens()) {
			String token = previouToken();
			if(position == c) return token;
			else c++;
		}
		return null;
	}

	public String getPreviouToken(String text, int index) {
		while(hasNextMoreTokens()) {
			String token = previouToken();
			if(text.equals(token))
				if(index == 0) return token;
				else index--;
		}
		return null;
	}

	public String getNextTokens() {
		StringBuilder sb = new StringBuilder();
		while (hasNextMoreTokens()) sb.append(nextToken());
		return sb.toString();
	}

	public String getNextTokensAndSkip(String textSkip) {
		StringBuilder sb = new StringBuilder();
		while (hasNextMoreTokens()) sb.append(nextToken());
		return new StringBuilder(sb.toString()).skip(textSkip).toString();
	}

	public String getPreviouTokens() {
		StringBuilder sb = new StringBuilder();
		while (hasPreviouMoreTokens()) {
			sb.append(previouToken());
		}
		return sb.toString();
	}

	public String getPreviouTokensAndSkip(String skipText) {
		StringBuilder sb = new StringBuilder();
		while (hasPreviouMoreTokens()) {
			sb.append(previouToken());
		}
		return new StringBuilder(sb.toString()).skip(skipText).toString();
	}

	public String getCurrentToken() { return tokens[currentPosition]; }

	public String getDelimiter() { return delimiter; }

	public String[] getDelimiterToTokens() { return getDelimiter().split(""); }

	public String getAllTokens() {
		StringBuilder sb = new StringBuilder();
		for(String str : tokens) sb.append(returnDelim ? str + getTokenDelimiter() : str);
		sb.delete(sb.length() - 1, sb.length());
		return sb.toString();
	}

	public int getMissingCountTokens() { return getCountTokens() - currentPosition; }

	public int getCountTokens() { return tokens.length; }

	public int getMissingCountTokensDelimiter() { return getCountTokens() - currentPosition; }

	public int getCountTokensDelimiter() { return delimiterTokens.length; }

	public String nextTokenDelimiter() { return delimiterTokens[currentPosition++]; }

	public String previouTokenDelimiter() { return delimiterTokens[--currentPosition]; }

	public String getCurrentTokenDelimiter() { return delimiterTokens[currentPosition]; }

	public String getAllTokensDelimiter() {
		String delimiter = this.delimiter;
		StringBuilder sb = new StringBuilder();
		if (delimiter.length() > 1) {
			String[] parts = delimiter.split("");
			for (int i = 0; i < parts.length; i++)
				sb.append(test(parts[i]) + "|");
			if(sb.length() > 2)
				sb.delete(sb.length() - 1, sb.length());
			delimiter = sb.toString();
		} else
			delimiter = test(delimiter);
		Matcher matcher = Pattern.compile(delimiter).matcher(str);
		StringBuilder sb2 = new StringBuilder();
		while(matcher.find())  sb2.append(matcher.group());
		return sb2.toString();
	}

	public int getCountTokenDelimiters() { return getAllTokensDelimiter().length(); }

	public String getTokenDelimiter() {
		String delimiters = delimiterTokens[currentPosition > delimiterTokens.length ? delimiterTokens.length : currentPosition];
		return test(delimiters);
	}

	public StringTokenizer addDelimiter(String delimiter) {
		StringBuilder sb = new StringBuilder();
		if(delimiter.length() > 1) {
			String[] delimiterParts = test(delimiter).split("");
			for (int i = 0; i < delimiterParts.length; i++)
				sb.append(test(delimiterParts[i])).append("|");
			String[] delimiterParts2 = test(getTokenDelimiter()).split("");
			for (int i = 0; i < delimiterParts2.length; i++)
				sb.append(test(delimiterParts2[i])).append("|");	
			if(sb.length() > 2)
				sb.delete(sb.length() - 1, sb.length());
		} else {
			sb.append(delimiter).append("|");
			String[] delimiterParts = test(getTokenDelimiter()).split("");
			for (int i = 0; i < delimiterParts.length; i++)
				sb.append(test(delimiterParts[i])).append("|");	
			if(sb.length() > 2)
				sb.delete(sb.length() - 1, sb.length());
		}
		StringBuilder sb2 = new StringBuilder();
		sb2.append(str);
		String[] newTokens = sb2.toString().split(sb.toString());
		tokens = newTokens;
		return this;
	}

	public StringTokenizer setDelimiter(String delimiter) {
		StringBuilder sb = new StringBuilder();
		if(delimiter.length() > 1) {
			String[] delimiterParts = (delimiter.replace("|", "\\|")).split("");
			for (int i = 0; i < delimiterParts.length; i++) sb.append(delimiterParts[i].replace("*", "\\*")).append("|");
			if(sb.length() > 2) sb.delete(sb.length() - 1, sb.length());
		} else sb.append(delimiter);
		StringBuilder sb2 = new StringBuilder();
		sb2.append(str);
		String[] newTokens = sb2.toString().split(sb.toString());
		tokens = newTokens;
		return this;
	}

	@Deprecated
	public void removeToken(int positionRemoveToken) {
		ArrayList<String> tokenList = new ArrayList<>(Arrays.asList(tokens));
		tokenList.remove(positionRemoveToken);
		tokens = tokenList.toArray(new String[0]);
	}

	@Deprecated
	public void addToken(int positionAddToken, String Token) {
		ArrayList<String> tokenList = new ArrayList<>(Arrays.asList(tokens));
		tokenList.add(positionAddToken, Token);
		tokens = tokenList.toArray(new String[0]);
	}
} */