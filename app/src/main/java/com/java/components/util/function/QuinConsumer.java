package com.java.components.util.function;

@FunctionalInterface
public interface QuinConsumer<A, B, C, D, E> {
	void accept(A a, B b, C c, D d, E e);

	default QuinConsumer<A, B, C, D, E> andThen(QuinConsumer<A, B, C, D, E> after) {
		return (a, b, c, d, e) -> {
			accept(a, b, c, d, e);
			after.accept(a, b, c, d, e);
		};
	}
}
