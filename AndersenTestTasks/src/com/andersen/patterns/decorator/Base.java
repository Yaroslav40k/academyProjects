package com.andersen.patterns.decorator;

public class Base extends MiniatureDecorator {

	public Base(Paintable partOfPaintable, String descr, int cost ) {
		this.setPartOfPaintable(partOfPaintable);
		this.setDescription(descr);
		this.setCost(cost);		
	}	
}
