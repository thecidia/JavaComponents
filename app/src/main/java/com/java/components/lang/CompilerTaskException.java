package com.java.components.lang;

import java.io.PrintStream;

public class CompilerTaskException extends RuntimeException {
	protected Throwable[] suppressed;
	public Throwable[] getSuppresseds() {
		return suppressed;
	}

	protected String message;

	@Override
	public String getMessage() {
		return message;
	}

	public CompilerTaskException() {
		super();
	}

	public CompilerTaskException(Throwable cause) {
		super((String) null);
		this.suppressed = new Throwable[] { cause };
	}

	public CompilerTaskException(String msg) {
		super(msg);
		this.message = msg;
	}

	public CompilerTaskException(String msg, Throwable cause) {
		super(msg, null);
		this.suppressed = new Throwable[] { cause };
		this.message = msg;
	}

	public CompilerTaskException(String msg, Throwable[] cause) {
		super(msg, null);
		this.suppressed = cause;
		this.message = msg;
	}

	@Override
	public String toString() {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		sb.append("An exception was found in '");
		if (getStackTrace() != null) {
			sb.append(getStackTrace()[getStackTrace().length - 1].getClassName().substring(getStackTrace()[getStackTrace().length - 1].getClassName().lastIndexOf(".") + 1, getStackTrace()[getStackTrace().length - 1].getClassName().length())).append(".java");
		}
		sb.append(" type: ").append(getClass().getSimpleName()).append(" (").append(getClass().toString().replace("class ", "")).append("): ");
		if (message != null){
			if (!message.contains("\n")) {
				sb.append("\n  Message: ").append(message);
			} else {
				sb.append("\n  Message:");
				String[] lines = message.split("\n");
				for (String line : lines) {
					sb.append("\n    ").append(line);
				}
			}
		}
		if (getStackTrace()[getStackTrace().length - 1] != null) {
			sb.append("\n  Line: ").append(getStackTrace()[getStackTrace().length - 1].getLineNumber());
			int tmp = getStackTrace()[getStackTrace().length - 1].toString().indexOf('.', 18);
			sb.append("\n  Location: ").append(getStackTrace()[getStackTrace().length - 1].toString().substring(0, tmp)).append("");
		}
		if (suppressed != null) {
			sb.append("\nCaused by: ");
			for (Throwable e : suppressed) {
				sb.append("\n  ").append(e.getClass().getSimpleName()).append(" (").append(e.getClass().toString().replace("class ", "")).append("),");
			}
			if (sb.length() > 2) sb.delete(sb.length() - 1, sb.length());
		}
		sb.append("\nError:");
		// sb.append(getPrintStackTrace());
		return sb.toString();
	}

	public String getPrintStackTrace() {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		if (getStackTrace() != null) {
			StackTraceElement[] stackTraceElements = getStackTrace();
			for (StackTraceElement e : stackTraceElements) {
				int tmp = e.toString().indexOf('.', 18);
				String className = e.toString().substring(tmp + 1, e.toString().length());
				String packageName  = e.toString().substring(0, tmp);
				sb.append("\n  ").append(className).append(": ").append(packageName);
			}
		}
		return sb.toString();
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
