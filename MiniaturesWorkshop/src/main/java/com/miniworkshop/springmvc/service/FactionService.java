package com.miniworkshop.springmvc.service;

import java.util.List;

import com.miniworkshop.springmvc.model.Faction;

public interface FactionService {
	
	Faction findFactionById(int id);

	Faction findFactionByName(String gameSystemName);

	void saveFaction(Faction gameSystem);

	void updateFaction(Faction gameSystem);

	void deleteFactionById(String gameSystemId);

	void deleteFactionByName(String gameSystemName);

	List<Faction> findAllFactions();
	
	List<Faction> findAllFactionsByGS(Integer gs_id);

}
