package com.java.components.lang.exception;

public class UnimplmentedConstructorException extends UnimplementedMethodException {
	public UnimplmentedConstructorException() {
		super();
	}

	public UnimplmentedConstructorException(Throwable cause) {
		super(cause);
		this.suppressed = new Throwable[] { cause };
	}

	public UnimplmentedConstructorException(String msg) {
		super(msg);
		this.message = msg;
	}

	public UnimplmentedConstructorException(String msg, Throwable cause) {
		super(msg, cause);
		this.suppressed = new Throwable[] { cause };
		this.message = msg;
	}

	public UnimplmentedConstructorException(String msg, Throwable[] cause) {
		super(msg, cause[0]);
		this.suppressed = cause;
		this.message = msg;
	}

	public UnimplmentedConstructorException(int msg) {
		this(String.valueOf(msg));
	}

	public UnimplmentedConstructorException(int msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplmentedConstructorException(byte msg) {
		this(String.valueOf(msg));
	}

	public UnimplmentedConstructorException(byte msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplmentedConstructorException(short msg) {
		this(String.valueOf(msg));
	}

	public UnimplmentedConstructorException(short msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplmentedConstructorException(long msg) {
		this(String.valueOf(msg));
	}

	public UnimplmentedConstructorException(long msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplmentedConstructorException(float msg) {
		this(String.valueOf(msg));
	}

	public UnimplmentedConstructorException(float msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplmentedConstructorException(double msg) {
		this(String.valueOf(msg));
	}

	public UnimplmentedConstructorException(double msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplmentedConstructorException(char msg) {
		this(String.valueOf(msg));
	}

	public UnimplmentedConstructorException(char msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplmentedConstructorException(boolean msg) {
		this(String.valueOf(msg));
	}

	public UnimplmentedConstructorException(boolean msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}

	public UnimplmentedConstructorException(CharSequence msg) {
		this(String.valueOf(msg));
	}

	public UnimplmentedConstructorException(CharSequence msg, Throwable cause) {
		this(String.valueOf(msg), cause);
	}
}


