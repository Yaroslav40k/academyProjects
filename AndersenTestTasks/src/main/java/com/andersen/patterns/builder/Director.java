package com.andersen.patterns.builder;

public class Director {
	
	AbstractBuilder builder;

	public Marine getmarine() {
		return builder.getMarine();
	}

	public void setBuilder(AbstractBuilder builder) {
		this.builder = builder;
	}
	
	public void constructMarine(){
		builder.createMarine();
		builder.buildChapter();
		builder.buildRole();
		builder.buildWounds();
	}
	
	
	
	

}
