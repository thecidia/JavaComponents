package com.java.components.lang.exception;

import com.java.components.lang.CompilerTaskException;

public class NullPointerException extends CompilerTaskException {
	public NullPointerException() {
		super();
	}

	public NullPointerException(Throwable cause) {
		super(cause);
	}

	public NullPointerException(String msg) {
		super(msg);
	}

	public NullPointerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NullPointerException(int msg) {
		this(String.valueOf(msg));
	}

	public NullPointerException(int msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NullPointerException(byte msg) {
		this(String.valueOf(msg));
	}

	public NullPointerException(byte msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NullPointerException(short msg) {
		this(String.valueOf(msg));
	}

	public NullPointerException(short msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NullPointerException(long msg) {
		this(String.valueOf(msg));
	}

	public NullPointerException(long msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NullPointerException(float msg) {
		this(String.valueOf(msg));
	}

	public NullPointerException(float msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NullPointerException(double msg) {
		this(String.valueOf(msg));
	}

	public NullPointerException(double msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NullPointerException(char msg) {
		this(String.valueOf(msg));
	}

	public NullPointerException(char msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NullPointerException(boolean msg) {
		this(String.valueOf(msg));
	}

	public NullPointerException(boolean msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NullPointerException(CharSequence msg) {
		this(String.valueOf(msg));
	}

	public NullPointerException(CharSequence msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}
}
