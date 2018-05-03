package com.andersen.myCacheImpl;

public interface Cache <K,V> {
	
	public V get (K key);
	public V put(K key, V value);
	public void remove (K key);
	public void clear();
	public boolean containsKey(K key);
	public int getSize();
	public int getCapacity();
	public void printCache();

}
