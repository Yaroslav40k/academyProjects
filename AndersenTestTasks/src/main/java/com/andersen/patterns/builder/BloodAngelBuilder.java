package com.andersen.patterns.builder;

public class BloodAngelBuilder extends AbstractBuilder {

	@Override
	public void buildChapter() {
		marine.setChapter("BloodAndels");
		
	}

	@Override
	public void buildRole() {
		marine.setRole("Fast Attack");
		
	}

	@Override
	public void buildWounds() {
		marine.setWounds(7);
		
	}

}
