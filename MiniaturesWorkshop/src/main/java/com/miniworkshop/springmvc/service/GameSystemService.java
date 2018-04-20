package com.miniworkshop.springmvc.service;

import java.util.List;

import com.miniworkshop.springmvc.model.GameSystem;

public interface GameSystemService {
	
	GameSystem findGameSystemById(int id);

	GameSystem findGameSystemByName(String gameSystemName);

	void saveGameSystem(GameSystem gameSystem);

	void updateGameSystem(GameSystem gameSystem);

	void deleteGameSystemById(String gameSystemId);

	void deleteGameSystemByName(String gameSystemName);

	List<GameSystem> findAllGameSystems();
	
	List<GameSystem> findAllGameSystemsByManuf(Integer manuf_id);

}
