package com.java.components.util.function;

@FunctionalInterface
public interface OneConsumer<A> {
	void accept(A a);

	default OneConsumer<A> andThen(OneConsumer<A> after) {
		return (a) -> {
			accept(a);
			after.accept(a);
		};
	}
}
