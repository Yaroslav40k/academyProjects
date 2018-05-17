package com.andersen.patterns.strategy;

public class BloodAngelsMarine extends SpaceMarine {

	
	public BloodAngelsMarine() {
		
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
