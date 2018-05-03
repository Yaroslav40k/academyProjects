package com.andersen.myCacheImpl;

import java.util.LinkedHashMap;
import java.util.Map;

public class ImprovedLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 1L;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private static final boolean LRU_ACCESS_ORDER = true;
	private int capacity;

	public ImprovedLinkedHashMap(int capacity) {
		super(capacity, DEFAULT_LOAD_FACTOR, LRU_ACCESS_ORDER);
		this.capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > capacity;
	}

	public int getCapacity() {
		return capacity;
	}
}
