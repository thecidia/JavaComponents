package com.java.components.util;

import com.java.components.lang.CompilerTaskException;
import com.java.components.lang.exception.EmptyPointerException;
import com.java.components.lang.exception.NullPointerException;

public class Union {
	private Object value;
	private Class<?>[] types;

	public Union(Class<?>... types) {
		if (types == null) { throw new NullPointerException(); }
		if (types.length == 0) { throw  new EmptyPointerException(); }
		this.types = types;
	}

	public void set(Object value) {
		if (value == null) { throw new NullPointerException(); }
		for (Class<?> type : this.types) {
			if (value.getClass() == type) {
				this.value = value;
				return;
			}
		}
		throw new CompilerTaskException();
	}

	public Object get() { return this.value; }
}
