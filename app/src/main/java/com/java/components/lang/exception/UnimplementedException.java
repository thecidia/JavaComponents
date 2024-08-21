package com.java.components.lang.exception;

import com.java.components.lang.CompilerTaskException;

public class UnimplementedException extends CompilerTaskException {
	public UnimplementedException() {
		super();
	}

	public UnimplementedException(Throwable cause) {
		super(cause);
		this.suppressed = new Throwable[] { cause };
	}

	public UnimplementedException(String msg) {
		super(msg);
		this.message = msg;
	}

	public UnimplementedException(String msg, Throwable cause) {
		super(msg, cause);
		this.suppressed = new Throwable[] { cause };
		this.message = msg;
	}

	public UnimplementedException(String msg, Throwable[] cause) {
		super(msg, cause[0]);
		this.suppressed = cause;
		this.message = msg;
	}

	public UnimplementedException(int msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedException(int msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedException(byte msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedException(byte msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedException(short msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedException(short msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedException(long msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedException(long msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedException(float msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedException(float msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedException(double msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedException(double msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedException(char msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedException(char msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedException(boolean msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedException(boolean msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedException(CharSequence msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedException(CharSequence msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}
}

