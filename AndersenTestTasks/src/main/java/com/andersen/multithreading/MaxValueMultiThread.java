package com.andersen.multithreading;

/**
 * This thread finds the max value in a subsection of an array.
 */
public class MaxValueMultiThread extends Thread {
	private int lo, hi;
	private int[] arr;
	private int max;

	public MaxValueMultiThread(int[] arr, int lo, int hi) {
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

		// Create and start many threads.
		MaxValueMultiThread[] ts = new MaxValueMultiThread[10];
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 4; i++) {
			ts[i] = new MaxValueMultiThread(arr, (i * len) / 4, ((i + 1) * len / 4));
			ts[i].start();
		}

		// Wait for the threads to finish and check their results.
		for (int i = 0; i < 4; i++) {
			ts[i].join();
			System.out.println(ts[i].getName() + " found max value of " + ts[i].max);
			if (ts[i].max > max) {
				max = ts[i].max;
			}
		}
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
