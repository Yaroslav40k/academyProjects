package com.andersen.patterns.facade;

public class TerminatorUnit {
	ReaperAutocannon reaper = new ReaperAutocannon();
	HeavyBolter hb = new HeavyBolter();
	Lascannon lascannon = new Lascannon();
	
	public void supressiveFire () {
		reaper.fire();
		hb.fire();
		lascannon.fire();
	}

}
