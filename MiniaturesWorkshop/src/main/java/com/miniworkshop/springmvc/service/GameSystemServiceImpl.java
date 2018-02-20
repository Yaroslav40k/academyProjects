package com.miniworkshop.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miniworkshop.springmvc.dao.GameSystemDAO;
import com.miniworkshop.springmvc.model.GameSystem;

@Service("gameSystemService")
@Transactional
public class GameSystemServiceImpl implements GameSystemService {
	
	@Autowired
	private GameSystemDAO dao;

	@Override
	public GameSystem findGameSystemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameSystem findGameSystemByName(String gameSystemName) {
		// TODO Auto-generated method stub
		return dao.findGameSystemByName(gameSystemName);
	}

	@Override
	public void saveGameSystem(GameSystem gameSystem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGameSystem(GameSystem gameSystem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGameSystemById(String gameSystemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGameSystemByName(String gameSystemName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GameSystem> findAllGameSystems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GameSystem> findAllGameSystemsByManuf(Integer manuf_id) {
	
		return dao.findAllGameSystemsByManuf(manuf_id);
	}

}
