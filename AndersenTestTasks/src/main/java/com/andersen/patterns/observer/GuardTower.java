package com.andersen.patterns.observer;

import java.util.ArrayList;
import java.util.Iterator;

public class GuardTower implements Observable {
	
	private ArrayList<Observer> observers = new ArrayList<>();

	@Override
	public void addObserver(Observer o) {
		observers.add(o);

	}

	@Override
	public void remobeObserver(Observer o) {
		observers.remove(o);

	}

	@Override
	public void notifyAllObservers() {
		
		for (Iterator iterator = observers.iterator(); iterator.hasNext();) {
			Observer observer = (Observer) iterator.next();
			observer.takeNotification();
			
		}

	}

}
