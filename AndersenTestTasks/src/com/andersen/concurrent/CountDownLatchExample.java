package com.andersen.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(5);

		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 5; i > 0; i--) {
					System.out.println(i + " seconds to launch!");
					latch.countDown();
				}
			}
		});
		th.start();
		try {
			latch.await();
			System.out.println("Launch!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
