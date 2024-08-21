package com.java.components.util.range;

import com.java.components.lang.exception.IndexOutOfBoundsException;

public class RangeIndexOfBoundsException extends IndexOutOfBoundsException {
	public RangeIndexOfBoundsException() {
		super();
	}

	public RangeIndexOfBoundsException(String msg) {
		super(msg);
	}

	public RangeIndexOfBoundsException(Throwable cause) {
		super(cause);
	}

	public RangeIndexOfBoundsException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
