package com.java.components.lang;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.java.components.lang.exception.IndexOutOfBoundsException;
import com.java.components.lang.exception.NullPointerException;

public class System {

    public static void arrayCopy(Object src, int srcPos, Object dest, int destPos, int length) {
        if (src == null || dest == null) {
            throw new NullPointerException("Source or destination array is null");
        }
        if (!src.getClass().isArray() || !dest.getClass().isArray()) {
            throw new ArrayStoreException("Source or destination is not an array");
        }
        int srcLength = Array.getLength(src);
        int destLength = Array.getLength(dest);
        if (srcPos < 0 || destPos < 0 || length < 0 ||
            srcPos + length > srcLength || destPos + length > destLength) {
            throw new IndexOutOfBoundsException("Index out of bounds or length is invalid");
        }
        if (src == dest && srcPos < destPos && destPos < srcPos + length) {
            for (int i = length - 1; i >= 0; i--) {
                Array.set(dest, destPos + i, Array.get(src, srcPos + i));
            }
        } else {
            for (int i = 0; i < length; i++) {
                Array.set(dest, destPos + i, Array.get(src, srcPos + i));
            }
        }
    }

    public static void arrayCopy(Object src, Object dest, int length) {
        arrayCopy(src, 0, dest, 0, length);
    }

    public static void arrayCopy(Object src, Object dest) {
        arrayCopy(src, 0, dest, 0, Array.getLength(src));
    }

    public static <T> void listCopy(ArrayList<T> src, int srcPos, ArrayList<T> dest, int destPos, int length) {
        if (src == null || dest == null) {
            throw new NullPointerException("Source or destination list is null");
        }
        int srcLength = src.size();
        int destLength = dest.size();
        if (srcPos < 0 || destPos < 0 || length < 0 ||
            srcPos + length > srcLength || destPos + length > destLength) {
            throw new IndexOutOfBoundsException("Index out of bounds or length is invalid");
        }
        for (int i = 0; i < length; i++) {
            dest.set(destPos + i, src.get(srcPos + i));
        }
    }

    public static <T> void listCopy(ArrayList<T> src, ArrayList<T> dest, int length) {
        listCopy(src, 0, dest, 0, length);
    }

    public static <T> void listCopy(ArrayList<T> src, ArrayList<T> dest) {
        listCopy(src, 0, dest, 0, src.size());
    }

	public static char[] toCharArray(String[] strings) {
        String string = String.join("", strings);
        return string.toCharArray();
	}
}
