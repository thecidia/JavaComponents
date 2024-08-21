package com.java.components.lang;

import static com.java.components.Prints.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class Clazz<T> extends Objects {
	private static Class<?> clazz;
	private ClassLoader classLoader;

	public Clazz() {
		this(null);
	}

	@SuppressWarnings("static-access")
	public Clazz(Class<T> clazz) {
		this.clazz = clazz;
        componentType = null;
	}

    private Clazz(ClassLoader loader, Clazz<?> arrayComponentType) {
        classLoader = loader;
        componentType = arrayComponentType;
    }

	@Override
	public String toString() {
		String kind = isInterface() ? "interface " : (isPrimitive() ? "" : "class ");
		return kind.concat(this.getName());
	}

	public final String getName() {
		return clazz.getName();
	}

	public final static boolean isInterface() {
		return clazz.isInterface();
	}

	public final static <T> boolean isInterface(Class<T> clazz) throws ClassNotFoundException {
		return clazz.isInterface();
	}

	public final static boolean isInterface(String name) throws ClassNotFoundException {
		return Class.forName(name).isInterface();
	}

	public final static boolean isPrimitive() {
		return clazz.isPrimitive();
	}

	public final static <T> boolean isPrimitive(Class<T> clazz) throws ClassNotFoundException {
		return clazz.isPrimitive();
	}

	public final static boolean isPrimitive(String name) throws ClassNotFoundException {
		return Class.forName(name).isPrimitive();
	}

	public final static <T> boolean isPrimitive(Class<T> clazz, String name) throws ClassNotFoundException {
		return clazz.isPrimitive() || Class.forName(name).isPrimitive();
	}

	public final static <T> Class<T> forName(String name) throws ClassNotFoundException {
		return (Class<T>) Class.forName(name);
	}

	public final static <T> Class<T> forName(String name, boolean initialize) throws ClassNotFoundException {
		return (Class<T>) Class.forName(name, initialize, null);
	}

	public final static <T> Class<T> forName(String name, boolean initialize, ClassLoader loader) throws ClassNotFoundException {
		return (Class<T>) Class.forName(name, initialize, loader);
	}

	public final static <T> Class<T> forName(String name, ClassLoader loader) throws ClassNotFoundException {
		return (Class<T>) Class.forName(name, true, loader);
	}

	public final static <T> Class<T> forName(String name, boolean initialize, ClassLoader loader, Class<T> parent) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method privateMethod = clazz.getDeclaredMethod("forName", String.class, boolean.class, ClassLoader.class, Class.class);
		privateMethod.setAccessible(true);
		return (Class<T>) privateMethod.invoke(null, name, initialize, loader, parent);
	}

	public final static <T> Class<T> forName(Module module, String name) {
		return (Class<T>) Class.forName(module, name);
	}

	public final static <T> Class<T> forName(Module module, String name, boolean initialize) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method privateMethod = clazz.getDeclaredMethod("forName", Module.class, String.class, boolean.class);
		privateMethod.setAccessible(true);
		return (Class<T>) privateMethod.invoke(null, module, name, initialize);
	}

	public final static <T> boolean isArray(Class<T> clazz) throws ClassNotFoundException {
		return clazz.isArray();
	}

	public final static <T> boolean isList(Class<T> clazz) throws ClassNotFoundException {
		return clazz.isAssignableFrom(java.util.List.class);
	}

	public final static <T> boolean isMap(Class<T> clazz) throws ClassNotFoundException {
		return clazz.isAssignableFrom(java.util.Map.class);
	}

	public final boolean isArray() {
		return clazz.isArray();
	}

	public final static boolean isSuperclass(Object obj) {
		return clazz.isInstance(obj);
	}

	public final static <T> boolean isSuperclass(Class<T> clazz, Object obj) {
		return clazz.isInstance(obj);
	}

	public final static boolean isClass(Object obj) {
		return obj.getClass().toGenericString().contains("class");
	}

	public final boolean isClass() {
		return clazz.toGenericString().contains("class");
	}

	public final static boolean isEnum(Object obj) {
		return obj.getClass().isEnum();
	}

	public final boolean isEnum() {
		return clazz.isEnum();
	}

	public final static boolean isEnumeration(Object obj) {
		return isEnum(obj);
	}

	public final boolean isEnumeration() {
		return clazz.isEnum();
	}

	public final static boolean isRecord(Object obj) {
		return obj.getClass().isRecord();
	}

	public final boolean isRecord() {
		return clazz.isRecord();
	}

	public final static boolean isAnnotation(Object obj) {
		return obj.getClass().isAnnotation();
	}

	public final boolean isAnnotation() {
		return clazz.isAnnotation();
	}

	public String toGenericString(boolean withGetPackage) {
		if (isPrimitive()) {
			return toString();
		} else {
			StringBuilders sb = new StringBuilders();
			Clazz<?> component = this;
			int arrayDepth = 0;

			if (isArray()) {
				do {
					arrayDepth++;
					component = component.getComponentType();
				} while (component.isArray());
				sb.append(component.getName());
			} else {
				// Class modifiers are a superset of interface modifiers
				int modifiers = component.getModifiers() & Modifier.classModifiers();
				if (modifiers != 0) {
					sb.append(Modifier.toString(modifiers));
					sb.append(' ');
				}

				if (isAnnotation()) {
					sb.append('@');
				}
				if (isInterface()) { // Note: all annotation interfaces are interfaces
					sb.append("interface");
				} else {
					if (isEnum())
						sb.append("enum");
					else if (isRecord())
						sb.append("record");
					else
						sb.append("class");
				}
				sb.append(' ');
				if (withGetPackage) {
					sb.append(getName());
				} else {
					sb.append(getSimpleName());
				}
			}

			TypeVariable<?>[] typeparms = component.getTypeParameters();
			if (typeparms.length > 0) {
				sb.append(Arrays.stream(typeparms).map(Clazz::typeVarBounds).collect(Collectors.joining(",", "<", ">")));
			}

			if (arrayDepth > 0)
				sb.append("[]".repeat(arrayDepth));

			return sb.toString();
		}
	}

	public String toGenericString() {
		return toGenericString(true);
	}

	public String toGenreicStringWithoutPackage() {
		return toGenericString(false);
	}

	static String typeVarBounds(TypeVariable<?> typeVar) {
		Type[] bounds = typeVar.getBounds();
		if (bounds.length == 1 && bounds[0].equals(Object.class)) {
			return typeVar.getName();
		} else {
			return typeVar.getName() + " extends " + Arrays.stream(bounds).map(Type::getTypeName).collect(Collectors.joining(" & "));
		}
	}

    public TypeVariable<?>[] getTypeParameters() {
        return clazz.getTypeParameters();
    }

    public Clazz<?> getComponentType() {
        if (isArray()) {
            return componentType;
        } else {
            return null;
        }
    }

    private final Clazz<?> componentType;

    public int getModifiers() {
        return clazz.getModifiers();
    }

    @Override
    public int getId() {
        return 1;
    }

    public String getSimpleName() {
        return clazz.getSimpleName();
    }

    @Override
    public Clazz<T> getClazz() {
        return this;
    }
}
