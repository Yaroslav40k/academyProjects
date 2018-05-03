package com.andersen.myCacheImpl;

import java.nio.file.Path;
import java.util.Map;

public class OverAllCacheImpl<K> implements Cache<K, Object> {

	private static final int DEFAULT_OVERALL_CAPACITY = RamCache.DEFAULT_CAPACITY+StorageCache.DEFAULT_CAPACITY;
	private int overAllCapacity;
	private RamCache<K, Object> ramCache;
	private StorageCache<K> storageCache;

	public OverAllCacheImpl() {
		overAllCapacity = DEFAULT_OVERALL_CAPACITY;
		ramCache = new RamCache<K, Object>();
		storageCache = new StorageCache<>();
	}

	public OverAllCacheImpl(Strategy strategy, int ramCapacity, int storageCapacity, String basePathForStorage) {
		overAllCapacity = ramCapacity + storageCapacity;
		ramCache = new RamCache<K, Object>(ramCapacity);
		storageCache = new StorageCache<>(storageCapacity, basePathForStorage);
	}

	@Override
	public Object get(K key) {
		Object objToFind = ramCache.get(key);
		if (objToFind == null) {
			objToFind = storageCache.get(key);
			if (objToFind != null) {
				moveToRamCache(key, objToFind);
			}
		}
		return objToFind;
	}

	@Override
	public Object put(K key, Object value) {
		if (ramCache.getSize() == ramCache.getCapacity()) {
			Map.Entry<K, Object> eldest = ramCache.getEldest();
			storageCache.put(eldest.getKey(), eldest.getValue());
		}
		ramCache.put(key, value);
		return value;
	}

	@Override
	public void remove(K key) {
		if (ramCache.containsKey(key)) {
			ramCache.remove(key);
		} else {
			storageCache.remove(key);
		}

	}

	@Override
	public void clear() {
		ramCache.clear();
		storageCache.clear();
	}

	@Override
	public int getSize() {
		return ramCache.getSize() + storageCache.getSize();
	}

	@Override
	public int getCapacity() {
		return overAllCapacity;
	}
	
	public Path getPath(K key) {
		return storageCache.getPath(key);
	}

	@Override
	public void printCache() {
		System.out.println("<=====RAM=====>");
		ramCache.printCache();
		System.out.println("<====STORAGE=====>");
		storageCache.printCache();
	}

	@Override
	public boolean containsKey(K key) {
		if (ramCache.containsKey(key) || storageCache.containsKey(key)) {
			return true;
		}
		return false;
	}

	private void moveToRamCache(K key, Object value) {
		ramCache.put(key, value);
		storageCache.remove(key);
	}
	
	

}
