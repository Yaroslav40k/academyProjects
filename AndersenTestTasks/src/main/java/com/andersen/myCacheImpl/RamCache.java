package com.andersen.myCacheImpl;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.andersen.myCacheImpl.maps.ImprovedLinkedHashMap;

import java.util.Set;


/*	 "RAM"(Random Access Memory) cache implementation.
 *	 By default can hold max of 10 objectives. 
 *
 *  */


public class RamCache<K, V> implements Cache<K, V> {

    static final int DEFAULT_CAPACITY = 10;
	private ImprovedLinkedHashMap<K, V> data;

	public RamCache() {
		this.data = new ImprovedLinkedHashMap<>(DEFAULT_CAPACITY);
	}

	public RamCache(int   initCapacity) {
		this.data = new ImprovedLinkedHashMap<>(initCapacity);
	}

	@Override
	public V get(K key) {
		return data.get(key);
	}

	@Override
	public V put(K key, V value) {		
		data.put(key, value);
		return value;
	}

	@Override
	public void remove(K key) {
		data.remove(key);

	}

	@Override
	public void clear() {
		data.clear();
	}

	@Override
	public int getSize() {
		return data.size();
	}

	@Override
	public int getCapacity() {
		return data.getCapacity();
	}

	@Override
	public void printCache() {
		for (Entry<K, V> entry : data.entrySet()) {
			System.out.println("KEY: "+entry.getKey() + "||" + " VALUE: "+ entry.getValue().toString());
		}

	}

	@Override
	public boolean containsKey(K key) {
		return data.containsKey(key);
	}
	
	public Map.Entry<K, V>  getEldest(){
		Map.Entry<K, V> eldest = null;
		Set<Entry<K, V>> keys = data.entrySet();
		Iterator<Entry<K, V>> iter = keys.iterator();
		eldest = iter.next();		
		return eldest;
	}

}
