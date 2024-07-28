package com.java.components.lang;

import java.lang.reflect.Method;

public class Clazz<T> {
	private static Class<?> clazz;

	public Clazz() {}

	public Clazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public String toString() {
		String kind = isInterface() ? "interface " : (isPrimitive() ? "" : "class ");
		return kind.concat(this.getName());
	}

	public String getName() {
		return clazz.getName();
	}
	
	public static Class<?> getClazz() {
		return clazz;
	}
	
	public static boolean isInterface() {
		return clazz.isInterface();
	}

	public static boolean isInterface(Class<?> clazz) {
		return clazz.isInterface();
	}

	public static boolean isInterface(String name) throws ClassNotFoundException {
		return Class.forName(name).isInterface();
	}

	public static boolean isPrimitive() {
		return clazz.isPrimitive();
	}

	public static boolean isPrimitive(Class<?> clazz) {
		return clazz.isPrimitive();
	}

	public static boolean isPrimitive(String name) throws ClassNotFoundException {
		return Class.forName(name).isPrimitive();
	}

	public static boolean isPrimitive(Class<?> clazz, String name) throws ClassNotFoundException {
		return clazz.isPrimitive() || Class.forName(name).isPrimitive();
	}

	public static Class<?> forName(String name, boolean initialize) {
		try {
			return Class.forName(name, initialize, null);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	public static Class<?> forName(String name, boolean initialize, ClassLoader loader) {
		try {
			return Class.forName(name, initialize, loader);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	public static Class<?> forName(String name, ClassLoader loader) {
		try {
			return Class.forName(name, true, loader);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	public static Class<?> forName(String name, boolean initialize, ClassLoader loader, Class<?> parent) throws ClassNotFoundException {
		try {
			Method privateMethod = clazz.getDeclaredMethod("forName");
			privateMethod.setAccessible(true);
			return (Class<?>) privateMethod.invoke(null, name, initialize, loader, parent);
		} catch(Exception e) {
			return null;
		}
	}

	public static Class<?> forName(String name) {
		try {
			return Class.forName(name);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	public static boolean isArray(Class<?> clazz) {
		return clazz.isArray();
	}

	public static boolean isList(Class<?> clazz) {
		return clazz.isAssignableFrom(java.util.List.class);
	}

	public static boolean isMap(Class<?> clazz) {
		return clazz.isAssignableFrom(java.util.Map.class);
	}
}
