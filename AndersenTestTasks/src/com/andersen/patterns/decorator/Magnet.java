package com.andersen.patterns.decorator;

public class Magnet extends MiniatureDecorator {

	public Magnet(Paintable partOfPaintable, String descr, int cost) {
		this.setPartOfPaintable(partOfPaintable);
		this.setDescription(descr);
		this.setCost(cost);
	}
}
