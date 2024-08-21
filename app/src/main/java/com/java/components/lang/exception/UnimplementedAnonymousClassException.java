package com.java.components.lang.exception;

public class UnimplementedAnonymousClassException extends UnimplementedException {
	public UnimplementedAnonymousClassException() {
		super();
	}

	public UnimplementedAnonymousClassException(Throwable cause) {
		super(cause);
		this.suppressed = new Throwable[] { cause };
	}

	public UnimplementedAnonymousClassException(String msg) {
		super(msg);
		this.message = msg;
	}

	public UnimplementedAnonymousClassException(String msg, Throwable cause) {
		super(msg, cause);
		this.suppressed = new Throwable[] { cause };
		this.message = msg;
	}

	public UnimplementedAnonymousClassException(String msg, Throwable[] cause) {
		super(msg, cause[0]);
		this.suppressed = cause;
		this.message = msg;
	}

	public UnimplementedAnonymousClassException(int msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedAnonymousClassException(int msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedAnonymousClassException(byte msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedAnonymousClassException(byte msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedAnonymousClassException(short msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedAnonymousClassException(short msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedAnonymousClassException(long msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedAnonymousClassException(long msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedAnonymousClassException(float msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedAnonymousClassException(float msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedAnonymousClassException(double msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedAnonymousClassException(double msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedAnonymousClassException(char msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedAnonymousClassException(char msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedAnonymousClassException(boolean msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedAnonymousClassException(boolean msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplementedAnonymousClassException(CharSequence msg) {
		this(String.valueOf(msg));
	}

	public UnimplementedAnonymousClassException(CharSequence msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}
}
