package com.java.components.util.function;

@FunctionalInterface
public interface BiFunction<R, F, S> {
	R apply(F f, S s);
}
