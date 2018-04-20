package com.miniworkshop.springmvc.dao;

import java.util.List;

import com.miniworkshop.springmvc.model.Faction;


public interface  FactionDAO {
	
	Faction findFactionById(int id);

	Faction findFactionByName(String gameSystemName);

	void saveFaction(Faction gameSystem);

	void updateFaction(Faction gameSystem);

	void deleteFactionById(String gameSystemId);

	void deleteFactionByName(String gameSystemName);

	List<Faction> findAllFactions();
	
	List<Faction> findAllFactionsByGS(Integer gs_id);
}
