package com.java.components.util.function;

@FunctionalInterface
public interface BiConsumer<A, B> {
	void accept(A a, B b);

	default BiConsumer<A, B> andThen(BiConsumer<A, B> after) {
		return (a, b) -> {
			accept(a, b);
			after.accept(a, b);
		};
	}
}
