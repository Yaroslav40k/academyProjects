package com.andersen.patterns.strategy;

public class RampageWSStyle implements WSStyle {

	@Override
	public void makeCCWAttack() {
		System.out.println("Attack with chainsword!");
	}

}
