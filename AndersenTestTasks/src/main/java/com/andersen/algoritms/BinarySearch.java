package com.andersen.algoritms;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {

		int[] taskNumberArray = { 1, 2, 3, 4, 5, 6, 7 };
		for (int i = 1; i < 8; i++) {
			System.out.println(binarySearch(taskNumberArray, i));
		}

	}

	public static String binarySearch(int[] numbersArray, int key) {
		Arrays.sort(numbersArray);
		int low = 0;
		int high = numbersArray.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			int guess = numbersArray[mid];
			if (guess == key) {
				return "number was found in array";
			}
			if (guess < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return " no such number in array";
	}
}
