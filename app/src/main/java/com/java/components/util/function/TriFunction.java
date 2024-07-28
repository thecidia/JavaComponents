package com.java.components.util.function;

public interface TriFunction<R, F, S, T> {
	R apply(F f, S s, T t);
}
