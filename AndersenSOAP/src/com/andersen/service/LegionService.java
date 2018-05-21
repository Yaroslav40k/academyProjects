package com.andersen.service;

import com.andersen.model.Legion;


/*
 * Interface with CRUD operations on Legion instance
 */

public interface LegionService {
	
	public boolean addLegion(Legion legion);
	
	public boolean deleteLegion(String legionName);
	
	public Legion getLegion(String legionName);
	
	public Legion[] getAllLegions();

}
