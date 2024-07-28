package com.java.components.util.range;

public class RangeInteger {
	private int number;

	public RangeInteger(int number) {
		this.number = number;
	}

	public RangeInteger(int number, int step) {
		this.number = number;
	}

	public boolean isRange(int min, int max) {
		return isRange(number, min, max);
	}

	public static boolean isRange(int number, int min, int max) {
		return number >= min && number <= max;
	}

	public static boolean isRange(RangeInteger range, int min, int max) {
		return range.number >= min && range.number <= max;
	}
}