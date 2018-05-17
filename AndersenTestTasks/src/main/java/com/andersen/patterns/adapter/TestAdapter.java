package com.andersen.patterns.adapter;

import java.util.ArrayList;

import org.junit.Test;

public class TestAdapter {
	
	@Test
	public void testArray(){
		ArrayList<String>  list = new ArrayList<>();
		list.add("Max");
		list.add("Anny");
		list.add("Ted");
		
		IteratorEnumeration<String> iterEnum = new IteratorEnumeration<>(list.iterator());
		
		while (iterEnum.hasMoreElements()) {
			System.out.println(iterEnum.nextElement());
		}
		
		
	}
	

}
