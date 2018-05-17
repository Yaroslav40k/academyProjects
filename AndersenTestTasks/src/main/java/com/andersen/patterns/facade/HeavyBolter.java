package com.andersen.patterns.facade;

public class HeavyBolter {
	
	public void fire() {
		System.out.println(this.getClass().getSimpleName() + "fired!");
	}

}
