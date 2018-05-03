package com.andersen.myCacheImpl;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map.Entry;

public class StorageCache<K> implements Cache<K, Object> {

	static final int DEFAULT_CAPACITY = 20;
	private static final String DEFAULT_PATH = "src/com/andersen/files/temp";
	private ImprovedLinkedHashMap<K, Path> data;
	private String basePathForStorage;
	private int capacity;

	public StorageCache() {
		this.basePathForStorage = DEFAULT_PATH;
		this.capacity = DEFAULT_CAPACITY;
		create(capacity, basePathForStorage);
	}

	public StorageCache(int capacity, String basePathForStorage) {
		this.capacity = capacity;
		this.basePathForStorage = basePathForStorage;
		create(capacity, basePathForStorage);
	}

	private void create(final int capacity, String basePath) {
		data = new ImprovedLinkedHashMap<K, Path>(capacity);
		Path path = Paths.get(basePath);
		if (Files.exists(path)) {
			try {
				Utils.removeRecursive(path);
				Files.createDirectory(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Object get(K key) {
		Object result = null;
		Path path = data.get(key);
		if (path != null && Files.isReadable(path)) {
			try {
				byte[] buf = Files.readAllBytes(path);
				ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf));
				result = in.readObject();
			} catch (IOException | ClassCastException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Object put(K key, Object value) {
		Path path = getPath(key);
		try {
			FileOutputStream file = new FileOutputStream(path.toFile());
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(value);
			out.close();
			data.put(key, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public void remove(K key) {
		removeFile(key);
		data.remove(key);
	}

	@Override
	public void clear() {
		try {
			removeAllFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		for (Entry<K, Path> entry : data.entrySet()) {
			System.out.println("KEY: " + entry.getKey() + "||" + " VALUE: " + entry.getValue().toString());
		}
	}

	public static <K> String getFileName(K key) {
		if (key instanceof String) {
			return key.toString();
		}
		return Integer.toHexString(key.hashCode());
	}

	public Path getPath(K key) {
		return Paths.get(basePathForStorage, getFileName(key));
	}

	private boolean removeFile(K key) {
		try {
			return Files.deleteIfExists(getPath(key));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private void removeAllFiles() throws IOException {
		Path path = Paths.get(basePathForStorage);
		if (Files.exists(path)) {
			Utils.removeRecursive(path);
		}
	}

	@Override
	public boolean containsKey(K key) {
		return data.containsKey(key);
	}
}
