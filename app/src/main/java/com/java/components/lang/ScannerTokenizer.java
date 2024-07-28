package com.java.components.lang;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ScannerTokenizer {
	private String[][] tokens;
	private int currentPositionLine;
	private int currentPositionToken;

	public ScannerTokenizer(String text) {
		this(text, " ");
	}

	private ScannerTokenizer(String text, String delimiter) {
		StringBuilder delimiterBuilder = new StringBuilder();
		if (delimiter.length() > 0) {
			for (int i = 0; i < delimiter.length(); i++) {
				if (!(delimiter.charAt(i) == '\n' && delimiter.charAt(i) == '\r')) {
					delimiterBuilder.append(delimiter.charAt(i) + "|");
				} else if (delimiter.charAt(i) == '\n' && delimiter.charAt(i) == '\r') {
					i++;
				}
			}
		}
		if (delimiterBuilder.length() > 2) {
			delimiterBuilder.delete(delimiterBuilder.length() - 1, delimiterBuilder.length());
		}
		delimiter = delimiterBuilder.toString();
		String[] lines = text.split("\r?\n");
		List<List<String>> subTokens = new ArrayList<>();
		for (String line : lines) {
			List<String> words = Arrays.asList(line.split(delimiter));
			subTokens.add(words);
		}
		tokens = subTokens.toArray(new String[0][]);
		currentPositionLine = 0;
		currentPositionToken = 0;
	}

	public boolean hasNext() {
		return (currentPositionLine < tokens.length) && (currentPositionToken < tokens[currentPositionLine].length);
	}

	public String next() {
		if(currentPositionLine >= tokens.length) {
			return null;
		}
		StringBuilder token = new StringBuilder();
		while (currentPositionToken < tokens[currentPositionLine].length) {
			token.append(tokens[currentPositionLine][currentPositionToken]);
			currentPositionToken++;
		}
		currentPositionLine++;
		currentPositionToken = 0;
		return token.toString();
	}
}
