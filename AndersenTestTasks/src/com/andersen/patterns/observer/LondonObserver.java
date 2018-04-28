package com.andersen.patterns.observer;

public class LondonObserver implements Observer {

	@Override
	public void takeNotification() {
		System.out.println("Barbarians are coming to London!");

	}

}
