package com.andersen.multithreading;

public class MaxValueOneThread extends Thread {
	private int lo, hi;
	private int[] arr;
	private int max;

	public MaxValueOneThread(int[] arr, int lo, int hi) {
		this.lo = lo;
		this.hi = hi;
		this.arr = arr;
		this.max = arr[0];
	}

	@Override
	public void run() {
		for (int i = lo; i < hi; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println(Thread.currentThread().getName() + " has finished their work");
	}

	public static int maxValue(int[] arr) throws InterruptedException {
		int len = arr.length;
		int max = arr[0];

		// Create and start 1 threads.
		long startTime = System.currentTimeMillis();
		MaxValueOneThread ts = new MaxValueOneThread(arr, 0, len);
		ts.start();
		// Wait for the threads to finish and check their results.
		ts.join();
		System.out.println(ts.getName() + " found max value of " + ts.max);
		max = ts.max;
		long endTime = System.currentTimeMillis();
		System.out.println("Total time spent " + (((double)endTime - startTime)/1000));
		return max;
	}

	public static void main(String[] args) throws InterruptedException {
		int[] arr = new int[100000000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10000);
		}
		int sum = maxValue(arr);
		System.out.println("Max: " + sum);
	}
}
