package com.andersen.collections;

import org.junit.Test;

public class TestArray {

	@Test
	public void testCustomArray() {
		System.out.println("This is test!");
		CustomArrayList<String> firstCustomList = new CustomArrayList<>();
		System.out.println("Array size " + firstCustomList.length());

		for (int i = 0; i < 10; i++) {
			for (int y = 0; y < 3; y++) {
				firstCustomList.add(i + " String");
				System.out.println(i + " String trying to add...");
			}
			System.out.println("current elems in array "+firstCustomList.length());

		}
		System.out.println();
		System.out.println("Array size " + firstCustomList.length());
	}
}
