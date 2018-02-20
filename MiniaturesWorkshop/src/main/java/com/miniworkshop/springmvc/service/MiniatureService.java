package com.miniworkshop.springmvc.service;

import java.util.List;

import com.miniworkshop.springmvc.model.Miniature;

public interface MiniatureService {
	
    Miniature findMiniatureById(int id);
	
    Miniature findMiniatureByName(String miniatureName);
	
	void saveMiniature(Miniature miniature);
	
	void updateMiniature(Miniature miniature);
	
	void deleteMiniatureById(String miniatureId);
	
	void deleteMiniatureByName(String miniatureName);
	
	List<Miniature> findAllMiniatures();
	
	List<Miniature> findAllMiniaturesBySize(String miniatureSize);
	
	List<Miniature> findAllMiniaturesByType(String miniatureType);
	
	List<Miniature> findAllMiniaturesByGameSystem(int gsId);
	
	List<Miniature> findAllMiniaturesByFaction(int factionId);
	
	List<Miniature> findAllMiniaturesByManuf(int manufId);


}
