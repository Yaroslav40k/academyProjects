package com.andersen.patterns.observer;

public class DerbyObserver implements Observer {

	@Override
	public void takeNotification() {
		System.out.println("Barbarians are coming to Derby!");

	}

}
