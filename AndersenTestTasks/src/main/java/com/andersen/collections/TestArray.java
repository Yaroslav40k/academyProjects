package com.andersen.collections;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class TestArray {

	CustomArrayList<Integer> list;
	Integer elemToTest;

	@Before
	public void init() {
		list = new CustomArrayList<>();
		elemToTest = 8;

		for (int i = 0; i < 9; i++) {
			list.add((int) (Math.random() * 9));
		}
		list.add(elemToTest);
		System.out.println("New List after adding 10 elems:");
		list.printCustomList();
		
	}

	@Test
	public void deleteElemTest() {
		list.delete(elemToTest);
		System.out.println("||List after deleting  elem " + elemToTest + ":");
		list.printCustomList();

	}

	@Test
	public void getElemByIndexTest() {
		Integer elemToFindIndex = new Random().nextInt(list.length() - 1);
		Integer elem = list.getByIndex(elemToFindIndex);
		System.out.println("||Elem by index " + elemToFindIndex + " is : " + elem);
	}
	
	@Test
	public void getElemByValueTest() {
		Integer elemToFind = list.getByValue(elemToTest);
		System.out.println("||Elem by Value is :"+ elemToFind);
	}
	
	@Test
	public void findMaxTest() {
		Integer max = list.findMax();
		System.out.println("||Max Elem is :"+ max);
	}
	
	@Test
	public void findMinTest() {
		Integer min = list.findMin();
		System.out.println("||Min Elem is :"+ min);
	}
	
	@Test
	public void findAvgTest() {
		Integer avg = list.findAvgOfAll();
		System.out.println("||Avg Elem is :"+ avg);
	}
}
