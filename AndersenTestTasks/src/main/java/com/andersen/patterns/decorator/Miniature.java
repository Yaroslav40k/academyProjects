package com.andersen.patterns.decorator;

public class Miniature implements Paintable {
	
	private String description;
	private int cost;
	
		
	
	public Miniature(String description, int cost) {
		super();
		this.description = description;
		this.cost = cost;
	}

	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public String getDescription() {
		return this.getClass().getName().substring(this.getClass().getName().lastIndexOf('.') + 1)+":"+description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
