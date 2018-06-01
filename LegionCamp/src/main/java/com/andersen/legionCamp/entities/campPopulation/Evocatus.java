package com.andersen.legionCamp.entities.campPopulation;

import com.andersen.legionCamp.entities.PopulationSkills.AbstractSkill;

public class Evocatus extends Legionarius {

	private AbstractSkill skill;

	public Evocatus(String name,int speed,int strength,int morale,int health,AbstractSkill skill) {
		super(name,speed,strength,morale,health);
		this.skill = skill;
	}

	public AbstractSkill getSkill() {
		return skill;
	}

	public void setSkill(AbstractSkill skill) {
		this.skill = skill;
	}

}
