package com.java.components.util.function;

@FunctionalInterface
public interface OneFunction<R, F> {
	R apply(F f);
}
