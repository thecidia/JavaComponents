package com.java.components.util;

import com.java.components.lang.CompilerTaskException;
import com.java.components.lang.StringBuilders;

import java.util.Arrays;

public class Array<T> {
	private T[] values;
	private int max;
	private int min;
	
	@SafeVarargs
	public Array(int minMax, boolean isMin, T... values) {
		if(isMin) {
			this.min = minMax;
			if (values.length < minMax) { throw new CompilerTaskException("Array length must be greater than " + minMax); }
		} else {
			this.max = minMax;
			if (values.length > minMax) { throw new CompilerTaskException("Array length must be less than " + minMax); }
		}
		this.values = values;
	}

	@SafeVarargs
	public Array(int min, int max, T... values) {
		this.min = min;
		this.max = max;
		if (max != -1 && values.length > max) { throw new CompilerTaskException("Array length must be less than " + max); }
		if (min != -1 && values.length < min) { throw new CompilerTaskException("Array length must be greater than " + min); }
		this.values = values;
	}

	@SafeVarargs public Array(T... values) { this(-1, -1, values); }

	@SuppressWarnings("unchecked")
	public Array() { this(-1, -1, (T[]) new Object[0]); }
	
	public Array<T> subArray(int min, int max, boolean isMin) {
		if (isMin) {
			if (min < 0 || max > values.length - 1 || max - min < 0) { return new Array<T>(); }
			return new Array<T>(min, max - min, Arrays.copyOfRange(values, min, max + 1));
		}
		if (max < 0 || min > values.length - 1 || max - min < 0) { return new Array<T>(); }
		return new Array<T>(max - min, min, Arrays.copyOfRange(values, max - min, min + 1));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		if (obj.getClass() != this.getClass()) { return false; }
		@SuppressWarnings("unchecked")
		Array<T> other = (Array<T>) obj;
		if (this.values.length != other.values.length) { return false; }
		for (int i = 0; i < this.values.length; i++) { if (!this.values[i].equals(other.values[i])) { return false; } }
		return true;
	}
	
	public int indexOf(T value) {
		if (values.length == 0) { return -1; }
		return indexOf(value, 0);
	}
	
	public int indexOf(T value, int start) {
		if (values.length == 0) { return -1; }
		for (int i = start; i < values.length; i++) { if (values[i].equals(value)) { return i; } }
		return -1;
	}
	
	public int lastIndexOf(T value) {
		if (values.length == 0) { return -1; }
		return lastIndexOf(value, values.length - 1);
	}
	
	public int lastIndexOf(T value, int start) {
		if (values.length == 0) { return -1; }
		for (int i = start; i >= 0; i--) { if (values[i].equals(value)) { return i; } }
		return -1;
	}

	public T get(int index) {
		if (index < 0 || index >= values.length) { throw new IndexOutOfBoundsException("Index " + index + " is out of range of the array."); }
		return values[index];
	}

	public T[] getArray() {
		return values;
	}

	public int size() { return values.length; }

	public int length() { return values.length; }

	public T set(int index, T element) {
		if (index < 0 || index >= values.length) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of range of the array.");
		}
		if (index < max || min > index) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of range of the limited of maximum and minimun.");
		}
		T old = values[index];
		values[index] = element;
		return old;
	}

	public void fill(T element) { Arrays.fill(values, element); }

	@SuppressWarnings("unchecked")
	public T[] copyOfRange(int min, int max) {
		if (max > values.length) { max = values.length; }
		if (min > max) { return (T[]) new Object[0]; }
		T[] arr = (T[]) new Object[max - min];
		System.arraycopy(values, min, arr, 0, arr.length);
		return arr;
	}
	
	public String toString(String delimiter) {
		StringBuilders sb = new StringBuilders();
		int iMax = values.length - 1;
		if (iMax < 0) { return "[]"; }
		for (int i = 0; i < iMax; i++) {
			sb.append(values[i]);
			if (i == iMax) { return sb.append(']').toString(); }
			sb.append(delimiter);
		}
		return sb.append(values[iMax]).toString();
	}
	
	@Override
	public String toString() { return toString(", "); }
}

