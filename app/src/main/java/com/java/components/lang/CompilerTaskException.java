package com.java.components.lang;

public class CompilerTaskException extends IllegalStateException {
	public CompilerTaskException() {
		super();
	}

	public CompilerTaskException(Throwable cause) {
		super(cause);
	}

	public CompilerTaskException(String msg) {
		super(msg);
	}

	public CompilerTaskException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CompilerTaskException(int msg) {
		this(String.valueOf(msg));
	}

	public CompilerTaskException(int msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public CompilerTaskException(byte msg) {
		this(String.valueOf(msg));
	}

	public CompilerTaskException(byte msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public CompilerTaskException(short msg) {
		this(String.valueOf(msg));
	}

	public CompilerTaskException(short msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public CompilerTaskException(long msg) {
		this(String.valueOf(msg));
	}

	public CompilerTaskException(long msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public CompilerTaskException(float msg) {
		this(String.valueOf(msg));
	}

	public CompilerTaskException(float msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public CompilerTaskException(double msg) {
		this(String.valueOf(msg));
	}

	public CompilerTaskException(double msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public CompilerTaskException(char msg) {
		this(String.valueOf(msg));
	}

	public CompilerTaskException(char msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public CompilerTaskException(boolean msg) {
		this(String.valueOf(msg));
	}

	public CompilerTaskException(boolean msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public CompilerTaskException(CharSequence msg) {
		this(String.valueOf(msg));
	}

	public CompilerTaskException(CharSequence msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}
}
