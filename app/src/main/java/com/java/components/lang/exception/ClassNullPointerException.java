package com.java.components.lang.exception;

import com.java.components.lang.CompilerTaskException;

public class ClassNullPointerException extends CompilerTaskException {
	public ClassNullPointerException() {
		super();
	}

	public ClassNullPointerException(Throwable cause) {
		super(cause);
	}

	public ClassNullPointerException(String msg) {
		super(msg);
	}

	public ClassNullPointerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ClassNullPointerException(int msg) {
		this(String.valueOf(msg));
	}

	public ClassNullPointerException(int msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public ClassNullPointerException(byte msg) {
		this(String.valueOf(msg));
	}

	public ClassNullPointerException(byte msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public ClassNullPointerException(short msg) {
		this(String.valueOf(msg));
	}

	public ClassNullPointerException(short msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public ClassNullPointerException(long msg) {
		this(String.valueOf(msg));
	}

	public ClassNullPointerException(long msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public ClassNullPointerException(float msg) {
		this(String.valueOf(msg));
	}

	public ClassNullPointerException(float msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public ClassNullPointerException(double msg) {
		this(String.valueOf(msg));
	}

	public ClassNullPointerException(double msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public ClassNullPointerException(char msg) {
		this(String.valueOf(msg));
	}

	public ClassNullPointerException(char msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public ClassNullPointerException(boolean msg) {
		this(String.valueOf(msg));
	}

	public ClassNullPointerException(boolean msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public ClassNullPointerException(CharSequence msg) {
		this(String.valueOf(msg));
	}

	public ClassNullPointerException(CharSequence msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}
}