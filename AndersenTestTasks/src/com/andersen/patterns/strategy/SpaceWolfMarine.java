package com.andersen.patterns.strategy;

public class SpaceWolfMarine extends SpaceMarine {
	
	public SpaceWolfMarine() {
		wsStyle = new ModerateWSStyle();
		bsStyle = new HeavyBSStyle();
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
