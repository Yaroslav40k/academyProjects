package com.andersen.patterns.observer;

public interface Observable {
	
	public void addObserver(Observer o);
	public void remobeObserver(Observer o);
	public void notifyAllObservers();

}
