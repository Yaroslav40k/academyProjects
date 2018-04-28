package com.andersen.patterns.observer;

public class CambridgeObserver implements Observer {

	@Override
	public void takeNotification() {
		System.out.println("Barbarians are coming to Cambridge!");
		
	}

}
