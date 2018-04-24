package com.andersen.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedInteger {
	private static AtomicInteger atomInt = new AtomicInteger(0);
	private static int notAtomInt = 0;

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 100; i++) {
			Thread th = new Thread(new Runnable() {
				@Override
				public void run() {
					atomInt.incrementAndGet();
					notAtomInt++;
				}
			});
			th.start();
			th.join();
		}
		System.out.println("AtomicInt "+atomInt);
		System.out.println("Not an AtomicInt "+ notAtomInt);
	}

	
}
