package com.java.components.lang;

public class Objects extends java.lang.Object {
	public static Clazz<Objects> clazz = new Clazz<>(Objects.class);

    @Override
	public String toString() {
		return toClassString();
	}

	protected String toClassString() {
		return "@" + getClass().getSimpleName() + "=" + getClass().getName() + ":" + Integer.toHexString(hashCode());
	}

	public StringBuilders toStringBuilder() {
		return new StringBuilders(
			toClassString()
		);
	}

	public int getId() {
		return 0;
	}

	public Clazz<?> getClazz() {
		return new Clazz<>(Objects.class);
	}
}