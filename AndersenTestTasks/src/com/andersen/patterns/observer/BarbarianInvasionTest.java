package com.andersen.patterns.observer;

public class BarbarianInvasionTest {
	
	public static void main(String[] args) {
		GuardTower tower = new GuardTower();
		tower.addObserver(new LondonObserver());
		tower.addObserver(new CambridgeObserver());
		tower.addObserver(new DerbyObserver());
		tower.notifyAllObservers();
	}
}
