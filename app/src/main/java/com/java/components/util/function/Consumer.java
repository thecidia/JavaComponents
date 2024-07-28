package com.java.components.util.function;

@FunctionalInterface
public interface Consumer {
	void accept();

	default Consumer andThen(Consumer after) {
		return () -> {
			accept();
			after.accept();
		};
	}
}
