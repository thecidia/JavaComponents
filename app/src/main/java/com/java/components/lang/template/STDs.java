package com.java.components.lang.template;

public class STDs { // StringTemplate Delimiter support
	private String startDelimiter;
	private String conditionDelimiter;
	private String endDelimiter;
	private char singleStartDelimiter;

	public STDs(String start, String condition, String end) {
		startDelimiter = start;
		conditionDelimiter = condition;
		endDelimiter = end;
	}

	public STDs(char singleStart) { singleStartDelimiter = singleStart; }

	public String getStartDelimiter() { return startDelimiter; }
	public String getConditionDelimiter() { return conditionDelimiter; }
	public String getEndDelimiter() { return endDelimiter; }
	public char getSingleStartDelimiter() { return singleStartDelimiter; }
}
