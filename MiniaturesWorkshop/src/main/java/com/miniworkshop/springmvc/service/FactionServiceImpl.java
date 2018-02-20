package com.miniworkshop.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miniworkshop.springmvc.dao.FactionDAO;
import com.miniworkshop.springmvc.model.Faction;

@Service("factionService")
@Transactional
public class FactionServiceImpl implements FactionService {
	
	@Autowired
	private FactionDAO dao;

	@Override
	public Faction findFactionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Faction findFactionByName(String gameSystemName) {
		// TODO Auto-generated method stub
		return dao.findFactionByName(gameSystemName);
	}

	@Override
	public void saveFaction(Faction gameSystem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFaction(Faction gameSystem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFactionById(String gameSystemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFactionByName(String gameSystemName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Faction> findAllFactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Faction> findAllFactionsByGS(Integer gs_id) {
		
		return dao.findAllFactionsByGS(gs_id);
	}

}
