package com.andersen.algoritms;

import java.util.ArrayList;
import java.util.Iterator;

public class QuickSort {

	ArrayList<Integer> numbersList;
	int numbersListSize;

	private void sort(ArrayList<Integer> list) {
		if (list == null) {
			throw new NullPointerException();
		}
		numbersList = list;
		numbersListSize = list.size() - 1;
		this.quickSort(0, numbersListSize);
	}

	private void quickSort(int low, int high) {
		int currentLow = low, currentHigh = high;
		int pivot = numbersList.get(low + (high - low) / 2);
		while (currentLow <= currentHigh) {
			while (numbersList.get(currentLow) < pivot) {
				currentLow++;
			}
			while (numbersList.get(currentHigh) > pivot) {
				currentHigh--;
			}

			if (currentLow <= currentHigh) {
				this.exchange(currentLow, currentHigh);
				currentLow++;
				currentHigh--;
			}
		}
		if (low < currentHigh)
			quickSort(low, currentHigh);
		if (currentLow < high)
			quickSort(currentLow, high);
	}

	private void exchange(int i, int j) {
		int temp = numbersList.get(i);
		numbersList.set(i, numbersList.get(j));
		numbersList.set(j, temp);
	}

	private static void printArray(ArrayList<Integer> list) {
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.print(integer + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		QuickSort sorter = new QuickSort();
		ArrayList<Integer> someArray = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			someArray.add((int) (Math.random() * 100));
		}
		printArray(someArray);
		sorter.sort(someArray);
		printArray(someArray);
	}

}
