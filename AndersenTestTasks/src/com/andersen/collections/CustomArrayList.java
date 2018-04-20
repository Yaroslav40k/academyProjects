package com.andersen.collections;

public class CustomArrayList<E> {

	private static final int DEFAULT_CAPACITY = 5;
	private Object[] elements;
	private int size;

	public CustomArrayList() {
		this.elements = new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}

	private void ensureCapacity() {
		if (this.size == elements.length) {
			this.enlargeArray();
		}
	}

	private void enlargeArray() {
		System.out.println("Enlarging Array...");
		Object[] elementsTMP = new Object[this.elements.length * 2];
		for (int i = 0; i < this.elements.length; i++) {
			elementsTMP[i] = this.elements[i];
		}
		this.elements = elementsTMP;
	}

	public boolean add(E elem) {
		this.ensureCapacity();
		if (isEnoughCopies(elem)) {
			this.elements[this.size++] = elem;
			return true;
		} else {
			return false;
		}
	}

	private boolean isEnoughCopies(E elem) {
		int copiesCount = 0;
		for (int i = 0; i < elements.length; i++) {
			if (elem.equals(elements[i])) {
				copiesCount++;
				if (copiesCount == 2) {
					return false;
				}
			}
		}
		return true;
	}

	public E get(int index) {
		rangeCheck(index);
		return (E) this.elements[index];
	}

	public boolean set(E elem) {
		for (int i = 0; i < elements.length; i++) {
			if (elem.equals(elements[i])) {
				elements[i] = elem;
				return true;
			}
		}
		return false;
	}

	public boolean delete(E elem) {
		for (int i = 0; i < elements.length; i++) {
			if (elem.equals(elements[i])) {
				elements[i] = null;
				return true;
			}
		}
		return false;
	}

	private void rangeCheck(int index ) {		
		if (index > this.size) {
			throw new IndexOutOfBoundsException("I feel disturbance in the Array!");
		}
	}

	public int length() {
		return size;
	}
}
