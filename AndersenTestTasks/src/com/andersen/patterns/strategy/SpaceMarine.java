package com.andersen.patterns.strategy;

public abstract class SpaceMarine {
	
	BSStyle bsStyle;
	WSStyle wsStyle;
	
	public  void strike() {
		wsStyle.makeCCWAttack();
	}
	public  void shoot(){
		bsStyle.makeShootingAttack();
	}
	public  void move() {
		System.out.println(this.getClass().getSimpleName()+" is moving");
	}
	
	
	
	

}
