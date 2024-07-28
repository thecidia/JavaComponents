package com.java.components.util;

import com.java.components.lang.ConfigurationException;

public class IndexOutOfBoundsListException extends ConfigurationException {
	public IndexOutOfBoundsListException(String message) {
		super(message);
	}
	
	public IndexOutOfBoundsListException(Throwable cause) {
		super(cause);
	}
	
	public IndexOutOfBoundsListException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
