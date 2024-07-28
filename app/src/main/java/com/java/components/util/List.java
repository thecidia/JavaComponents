package com.java.components.util;

import java.util.Iterator;

import com.java.components.lang.CompilerTaskException;

public class List<T> implements Iterable<T> {
	private ListNode<T> head;
	private int size = 0;
	private int min = -1;
	private int max = -1;

	@SuppressWarnings("hiding")
	public class ListNode<T> {
		T value;
		ListNode<T> next;

		ListNode(T value) {
			this.value = value;
			this.next = null;
		}
	}

	public List() {}

	public List(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@SafeVarargs
	public List(T... datas) {
		this(-1, -1, datas);
	}

	@SafeVarargs
	public List(int min, int max, T... datas) {
		this.min = min;
		this.max = max;
		for (T data : datas) { addLast(data); }
	}

	public void addFirst(T data) {
		checkCapacity(1);
		ListNode<T> node = new ListNode<>(data);
		node.next = this.head;
		this.head = node;
		this.size++;
	}

	public void addLast(T data) {
		checkCapacity(1);
		ListNode<T> node = new ListNode<>(data);
		if (this.head == null) {
			this.head = node;
		} else {
			ListNode<T> current = this.head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
		this.size++;
	}

	public void insert(int index, T data) {
		checkCapacity(1);
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsListException("Index out of bounds: " + index + " of size: " + this.size);
		}
		ListNode<T> node = new ListNode<>(data);
		if (index == 0) {
			this.head = node;
		} else {
			ListNode<T> current = this.head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			node.next = current.next;
			current.next = node;
		}
		this.size++;
	}

	public T get(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsListException("Index out of bounds: " + index + " of size: " + this.size);
		}
		ListNode<T> current = this.head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.value;
	}

	public int size() { return this.size; }

	public T remove(int index) {
		checkCapacity(-1);
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsListException("Index out of bounds: " + index + " of size: " + this.size);
		}
		T data;
		if (index == 0) {
			data = this.head.value;
			this.head = this.head.next;
		} else {
			ListNode<T> current = this.head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			data = current.next.value;
			current.next = current.next.next;
		}
		this.size--;
		return data;
	}

	public boolean remove(T data) {
		checkCapacity(-1);
		if (this.head == null) { return false; }
		if (this.head.value.equals(data)) {
			this.head = this.head.next;
			this.size--;
			return true;
		}
		ListNode<T> current = this.head;
		while (current.next != null) {
			if (current.next.value.equals(data)) {
				current.next = current.next.next;
				this.size--;
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public void clear() {
		this.head = null;
		this.size = 0;
	}

	public boolean isEmpty() { return this.size == 0; }

	public boolean contains(T data) {
		ListNode<T> current = this.head;
		while (current != null) {
			if (current.value.equals(data)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public Iterator<T> iterator() {
		return new ListIterator<>(this);
	}

	private void checkCapacity(int increment) {
		if (this.min > this.size + increment && this.min != -1) {
			throw new CompilerTaskException("Your List<" + this.head.value.getClass().getSimpleName() + "> length " + (this.size) + " must be less than " + min);
		}
		if (this.max >= 0 && this.size + increment > this.max) {
			throw new CompilerTaskException("Your List<" + this.head.value.getClass().getSimpleName() + "> length " + (this.size) + " must be less than " + max);
		}
	}

	@SuppressWarnings({"hiding", "unused"})
	public class ListIterator<T> implements Iterator<T> {
		private ListNode<T> current;
		private ListNode<T> lastReturned;
		private List<T> list;
	
		@SuppressWarnings("unchecked")
		ListIterator(List<T> list) {
			this.list = list;
			this.current = (ListNode<T>) list.head;
			this.lastReturned = null;
		}
	
		public boolean hasNext() {
			return this.current != null;
		}
	
		public T next() {
			if (!hasNext()) {
				throw new IndexOutOfBoundsListException("No more elements");
			}
			T data = this.current.value;
			this.lastReturned = this.current;
			this.current = this.current.next;
			return data;
		}
	}
}