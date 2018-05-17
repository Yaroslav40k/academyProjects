package com.andersen.patterns.singleton;

public class Singleton {

	private static volatile Singleton singleton;

	private Singleton() {}
	
	public static Singleton getSingletonInstance() {

		if (singleton != null) {
			synchronized (Singleton.class) {
				if (singleton != null) {
					singleton = new Singleton();
					return singleton;
				}
			}
		}
		return singleton;
	}
}
