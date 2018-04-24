package com.andersen.multithreading;

public class ReverseHello {
	private static int threadCount = 50;

	public static void main(String[] args) throws InterruptedException {

		Thread th = createThread();
		th.start();
		th.join();
	}

	private static Thread createThread() {
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				if (threadCount > 0) {
					Thread newThread = createThread();
					threadCount--;
					newThread.start();
					try {
						newThread.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Hello from " + Thread.currentThread().getName());
			}
		});
		return th;
	}
}
