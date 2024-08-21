package com.java.components.lang.exception;

import com.java.components.lang.CompilerTaskException;

public class UncheckedException extends CompilerTaskException {

	public UncheckedException() {
		super();
	}

	public UncheckedException(String msg) {
		super(msg);
	}

	public UncheckedException(Throwable cause) {
		super(cause);
	}


	public UncheckedException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
