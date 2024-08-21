package com.java.components.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class CheckedException extends Exception {
	private Throwable causing;
	private int level;
	public static final int LOWLEVELEXCEPTION = 0;
	public static final int MEDIUMLEVELEXCEPTION = 1;
	public static final int HIGHLEVELEXCEPTION = 2;

	public CheckedException() {
		super();
	}

	public CheckedException(String msg) {
		super(msg);
	}
	public CheckedException(String msg, int level) {
		super(msg);
		this.level = level;
	}

	public CheckedException(Throwable cause) {
		super((Throwable) null);
		this.causing = cause;
	}

	public CheckedException(Throwable cause, int level) {
		super((Throwable) null);
		this.causing = cause;
		this.level = level;
	}

	public CheckedException(String msg, Throwable cause) {
		super(msg, null);
		this.causing = cause;
	}

	public Throwable getCausing() {
		return causing;
	}

	public CheckedException(String msg, Throwable cause, int level) {
		super(msg, null);
		this.causing = cause;
		this.level = level;
	}

	public Class<?> getSuperClassCausing() {
		return causing == null ? null : causing.getClass().getSuperclass();
	}

	public int getLevel() {
		return level;
	}

	@Override
	public String toString() {
		String c = "for " + getClass().getSimpleName() + " (" + getClass().getName() + ")";
		String m = getLocalizedMessage();
		String l = (getLevel() == LOWLEVELEXCEPTION ? "Level: LowLevelException (Not Critical only Error basic)" : getLevel() == MEDIUMLEVELEXCEPTION ? "Level MediumLevelException (Low Critical)" : getLevel() == HIGHLEVELEXCEPTION ? "Level: HighLevelException (High Critical)" : "");
		String u = "Type Exception: Checked Exception";
		String f = m == null ? c : c + ":\n\t" + m;
		f += getCausing() != null ? "\nCaused by: " + getCausing().getClass().getSimpleName() + " (" + getCausing().getClass().getName() + (l != null ? "\n\t" + l + "," : "") + (u != null ? "\n\t" + u + ":" : "") : "";
		return f;
	}

	@Override
	public void printStackTrace(PrintWriter s) {
		s.println(this);
		StackTraceElement[] stackTrace = getStackTrace();
		for (StackTraceElement element : stackTrace) {
			s.println("\t\tError in: " + element);
		}
	}

	@Override
	public void printStackTrace(PrintStream s) {
		s.println(this);
		StackTraceElement[] stackTrace = getStackTrace();
		for (StackTraceElement element : stackTrace) {
			s.println("\t\tError in: " + element);
		}
	}
}
