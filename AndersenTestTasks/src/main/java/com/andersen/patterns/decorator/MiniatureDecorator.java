package com.andersen.patterns.decorator;

public abstract class MiniatureDecorator implements Paintable {

	private Paintable partOfPaintable;
	private String description;
	private int cost;

	@Override
	public String getDescription() {
		return partOfPaintable.getDescription() + "/"
				+ this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.') + 1)+":" + this.description;
	}

	@Override
	public int getCost() {
		return partOfPaintable.getCost() + this.cost;
	}

	public Paintable getPartOfPaintable() {
		return partOfPaintable;
	}

	public void setPartOfPaintable(Paintable partOfPaintable) {
		this.partOfPaintable = partOfPaintable;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	

}
