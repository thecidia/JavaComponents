package com.java.components.lang.exception;

public class UnimplementedMethodException extends UnimplementedException {
	public UnimplementedMethodException() {
		super();
	}

	public UnimplementedMethodException(Throwable cause) {
		super(cause);
		this.suppressed = new Throwable[] { cause };
	}

	public UnimplementedMethodException(String msg) {
		super(msg);
		this.message = msg;
	}

	public UnimplementedMethodException(String msg, Throwable cause) {
		super(msg, cause);
		this.suppressed = new Throwable[] { cause };
		this.message = msg;
	}

	public UnimplementedMethodException(String msg, Throwable[] cause) {
		super(msg, cause[0]);
		this.suppressed = cause;
		this.message = msg;
	}

	public UnimplementedMethodException(int msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedMethodException(int msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedMethodException(byte msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedMethodException(byte msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedMethodException(short msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedMethodException(short msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedMethodException(long msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedMethodException(long msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedMethodException(float msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedMethodException(float msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedMethodException(double msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedMethodException(double msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedMethodException(char msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedMethodException(char msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedMethodException(boolean msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedMethodException(boolean msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedMethodException(CharSequence msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedMethodException(CharSequence msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}
}

