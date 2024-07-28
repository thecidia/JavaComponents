package com.java.components.lang.template;

public class StringTemplateDelimiter {
	private String start;
	private String condition;
	private String end;

	public StringTemplateDelimiter(String start, String condition, String end) {
		this.start = start;
		this.condition = condition;
		this.end = end;
	}

	public String getStartDelimiter() { return start; }
	public String getConditionDelimiter() { return condition; }
	public String getEndDelimiter() { return end; }

	private char singleStart;

	public StringTemplateDelimiter(char singleStart) { this.singleStart = singleStart; }

	public char getSingleStartDelimiter() { return singleStart; }
}
