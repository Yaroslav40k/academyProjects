package com.andersen.legionCamp.entities.campPopulation;

import org.springframework.stereotype.Component;

@Component
public class Legionarius extends AbstractRomanWarrior {

	public Legionarius() {
	}
	
	public Legionarius(String name,int speed,int strength,int morale,int health) {
		this.setName(name);
		this.setSpeed(speed);
		this.setStrength(strength);
		this.setMorale(morale);
		this.setHealth(health);
	}


	@Override
	public void speak() {
		System.out.println("My name is " + getName());
	}

	@Override
	public void move() {
		System.out.println("I`m moving, " + getSpeed() + " m/h");
	}

	@Override
	public void fight() {
		System.out.println("I`m fighting, my strength is " + getStrength());
	}
}
