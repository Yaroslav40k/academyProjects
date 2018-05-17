package com.andersen.patterns.builder;

public abstract class AbstractBuilder {
	Marine marine;

	public Marine getMarine() {
		return marine;
	}

	public void createMarine() {
		this.marine = new Marine();
	}
	
	public abstract void buildChapter();
	public abstract void buildRole();
	public abstract void buildWounds();
	
	
	

}
