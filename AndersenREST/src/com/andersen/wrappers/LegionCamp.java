package com.andersen.wrappers;

/*
 *  LegionCamp class Bean 
 *  
 *  used by CampFinderService to be send via JSON way to the Client 
 */

public class LegionCamp {
	
	private String campName;
	private int legionersCount;
	
	
	public String getCampName() {
		return campName;
	}
	public void setCampName(String campName) {
		this.campName = campName;
	}
	public int getLegionersCount() {
		return legionersCount;
	}
	public void setLegionersCount(int legionersCount) {
		this.legionersCount = legionersCount;
	}
	
	

}
