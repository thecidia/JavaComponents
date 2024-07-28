package com.java.components.util.function;

public interface QuadFunction<R, F, S, T, U> {
	R apply(F f, S s, T t, U u);
}
