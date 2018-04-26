package com.andersen.patterns.strategy;

public class ChaosMarine extends SpaceMarine {
	
	public ChaosMarine() {
		wsStyle = new RampageWSStyle();
		bsStyle = new RapidBSStyle();
	}

	@Override
	public void strike() {
		System.out.println(this.getClass().getSimpleName()+":");
		wsStyle.makeCCWAttack();
		
	}

	@Override
	public void shoot() {
		System.out.println(this.getClass().getSimpleName()+":");
		bsStyle.makeShootingAttack();
		
	}

}
