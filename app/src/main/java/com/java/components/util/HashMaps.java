package com.java.components.util;

import java.util.*;

import com.java.components.lang.CompilerTaskException;

public class HashMaps<K, V> extends HashMap<K, V> {
	private int min = -1;
	private int max = -1;

	public HashMaps(HashMap<K, V> map, int min, int max) {
		super(map);
		this.min = min;
		this.max = max;
		checkCapacity(map.size());
	}

	public HashMaps(float factor) {
		super(16, factor);
	}

	public HashMaps() {}

	public HashMaps(int initialCapacity) {
		super(initialCapacity);
	}

	public HashMaps(int initialCapacity, float factor) {
		super(initialCapacity, factor);
	}

	public HashMaps(int initialCapacity, float factor, int min, int max) {
		super(initialCapacity, factor);
		this.min = min;
		this.max = max;
		checkCapacity(size());
	}

	public HashMaps(int initialCapacity, float factor, HashMap<K, V> map, int min, int max) {
		super(initialCapacity, factor);
		this.min = min;
		this.max = max;
		checkCapacity(map.size());
		putAll(map);
	}

	public HashMaps(HashMap<K, V> map) {
		super(map);
		checkCapacity(map.size());
	}

	@SafeVarargs
	public HashMaps(HashMap<K, V>... map) {
		int subSize = 0;
		for (HashMap<K, V> m : map) {
			putAll(m);
			subSize += m.size();
		}
		checkCapacity(subSize);
	}

	public void checkCapacity(int increment) {
		if (min != -1 && increment < min) {
			throw new CompilerTaskException("Map size must be greater than " + min);
		}
		if (max != -1 && size() + increment > max) {
			throw new CompilerTaskException("Map size must be less than " + max);
		}
	}

	public Object getKey(V value, int index) {
		return getKey(value, null, index);
	}

	public Object getKey(V value, V defaults, int index) {
		if (index < 1) {
			throw new CompilerTaskException("Index must be greater than 0");
		}
		int i = 0;
		for(Map.Entry<K, V> entry : entrySet()) {
			i++;
			if(entry.getValue().equals(value) && i == index)
				return entry.getKey();
		}
		return defaults;
	}

	public Object getKey(V value) {
		return getKey(value, 1);
	}

	public Object getKey(V value, V defaults) {
		return getKey(value, defaults, 1);
	}

	public int indexOf(V value) {
		int i = 0;
		for(Map.Entry<K, V> entry : entrySet()) {
			i++;
			if(entry.getValue().equals(value))
				return i;
		}
		return -1;
	}

	// public void remove(V value) {
	//	 checkCapacity(-1);
	//	 for(Map.Entry<K, V> entry : entrySet()) {
	//		 if(entry.getValue().equals(value)) {
	//			 remove(entry.getKey());
	//			 return;
	//		 }
	//	 }
	// }

	public void remove(int index) {
		checkCapacity(-1);
		if (index < 1) {
			throw new CompilerTaskException("Index must be greater than 0");
		}
		int i = 0;
		for(Map.Entry<K, V> entry : entrySet()) {
			i++;
			if(i == index) {
				remove(entry.getKey());
				return;
			}
		}
	}

	public void clear() {
		checkCapacity(-size());
		clear();
	}

	public boolean contains(V value) {
		return indexOf(value) != -1;
	}

	public int shortSize(int subSize) {
		if (subSize < 0) {
			throw new CompilerTaskException("Sub size must be greater than 0");
		} else if (subSize > size()) {
			throw new CompilerTaskException("Sub size must be less than " + size());
		}
		return size() - subSize;
	}
}

