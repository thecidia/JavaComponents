package com.java.components.lang.exception;

import com.java.components.lang.CompilerTaskException;

public class NumberNegativeException extends CompilerTaskException{
	public NumberNegativeException() {
		super();
	}

	public NumberNegativeException(Throwable cause) {
		super(cause);
		this.suppressed = new Throwable[] { cause };
	}

	public NumberNegativeException(String msg) {
		super(msg);
		this.message = msg;
	}

	public NumberNegativeException(String msg, Throwable cause) {
		super(msg, cause);
		this.suppressed = new Throwable[] { cause };
		this.message = msg;
	}

	public NumberNegativeException(String msg, Throwable[] cause) {
		super(msg, cause[0]);
		this.suppressed = cause;
		this.message = msg;
	}

	public NumberNegativeException(int msg) {
		this(String.valueOf(msg));
	}

	public NumberNegativeException(int msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NumberNegativeException(byte msg) {
		this(String.valueOf(msg));
	}

	public NumberNegativeException(byte msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NumberNegativeException(short msg) {
		this(String.valueOf(msg));
	}

	public NumberNegativeException(short msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NumberNegativeException(long msg) {
		this(String.valueOf(msg));
	}

	public NumberNegativeException(long msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NumberNegativeException(float msg) {
		this(String.valueOf(msg));
	}

	public NumberNegativeException(float msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NumberNegativeException(double msg) {
		this(String.valueOf(msg));
	}

	public NumberNegativeException(double msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NumberNegativeException(char msg) {
		this(String.valueOf(msg));
	}

	public NumberNegativeException(char msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NumberNegativeException(boolean msg) {
		this(String.valueOf(msg));
	}

	public NumberNegativeException(boolean msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public NumberNegativeException(CharSequence msg) {
		this(String.valueOf(msg));
	}

	public NumberNegativeException(CharSequence msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}
}
