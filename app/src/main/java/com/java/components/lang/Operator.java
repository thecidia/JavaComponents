package com.java.components.lang;

public class Operator {
	public static <T> boolean equals(T equalTo, @SuppressWarnings("unchecked") T... args) {
		for (Object object : args) {
			if(!equalTo.equals(object)) {
				return false;
			}
		}
		return true;
	}

	public static <T> boolean equal(T equalTo, T arg) {
		return equalTo.equals(arg);
	}

	public static int squareRoot(int number) {
		int i = 0;
		for (; i < number; i++) {
			if (i * i == number) {
				break;
			} else if (i * i > number) {
				i -= 1;
				break;
			}
		}
		return i;
	}

	public static int factor(int i) {
		for (int n = i; n > 0; n--) {
			i *= n;
		}
		if(i == 0) i = 1;
		return i;
	}

	public static int exponent(int i, int i2) {
		for (; i2 > 0; i2--) {
			i *= i;
		}
		return i;
	}
}
