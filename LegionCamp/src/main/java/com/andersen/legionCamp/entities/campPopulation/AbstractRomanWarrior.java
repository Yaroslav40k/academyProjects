package com.andersen.legionCamp.entities.campPopulation;

public abstract class AbstractRomanWarrior {

	private String name;
	private int speed;
	private int strength;
	private int morale;
	private int health;

	//---------//Basic action methods//---------//
	
	public abstract  void speak();
	
	public  abstract  void move();
	
	public abstract void fight();

	//---------//Getters and Setters//---------//

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getMorale() {
		return morale;
	}

	public void setMorale(int morale) {
		this.morale = morale;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

}
