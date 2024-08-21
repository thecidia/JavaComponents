package com.java.components.lang.exception;

import com.java.components.lang.CompilerTaskException;

public class EmptyPointerException extends CompilerTaskException {
	public EmptyPointerException() {
		super();
	}

	public EmptyPointerException(Throwable cause) {
		super(cause);
	}

	public EmptyPointerException(String msg) {
		super(msg);
	}

	public EmptyPointerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public EmptyPointerException(int msg) {
		this(String.valueOf(msg));
	}

	public EmptyPointerException(int msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public EmptyPointerException(byte msg) {
		this(String.valueOf(msg));
	}

	public EmptyPointerException(byte msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public EmptyPointerException(short msg) {
		this(String.valueOf(msg));
	}

	public EmptyPointerException(short msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public EmptyPointerException(long msg) {
		this(String.valueOf(msg));
	}

	public EmptyPointerException(long msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public EmptyPointerException(float msg) {
		this(String.valueOf(msg));
	}

	public EmptyPointerException(float msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public EmptyPointerException(double msg) {
		this(String.valueOf(msg));
	}

	public EmptyPointerException(double msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public EmptyPointerException(char msg) {
		this(String.valueOf(msg));
	}

	public EmptyPointerException(char msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public EmptyPointerException(boolean msg) {
		this(String.valueOf(msg));
	}

	public EmptyPointerException(boolean msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public EmptyPointerException(CharSequence msg) {
		this(String.valueOf(msg));
	}

	public EmptyPointerException(CharSequence msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}
}
