package com.andersen.patterns.strategy;

public class MarinesTestFight {
	
	private static  SpaceMarine bloodAndel = new BloodAngelsMarine();
	private static  SpaceMarine spaceWolf = new SpaceWolfMarine();
	private static  SpaceMarine csm = new ChaosMarine();
	
	public static void main(String[] args) {
		bloodAndel.shoot();
		bloodAndel.strike();
		spaceWolf.shoot();
		spaceWolf.strike();
		csm.shoot();
		csm.strike();
	}

}
