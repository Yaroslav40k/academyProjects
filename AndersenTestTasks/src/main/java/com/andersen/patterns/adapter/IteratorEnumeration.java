package com.andersen.patterns.adapter;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorEnumeration<E> implements Enumeration<E> {
	
	Iterator<E> iter;
	
	public IteratorEnumeration(Iterator<E> iter) {
		super();
		this.iter = iter;
	}

	@Override
	public boolean hasMoreElements() {
		
		return iter.hasNext();
	}

	@Override
	public E nextElement() {
		// TODO Auto-generated method stub
		return iter.next();
	}

}
