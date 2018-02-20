package com.miniworkshop.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miniworkshop.springmvc.dao.MiniatureDAO;
import com.miniworkshop.springmvc.dao.UserDao;
import com.miniworkshop.springmvc.model.Miniature;

@Service("miniatureService")
@Transactional
public class MiniatureServiceImpl implements MiniatureService {
	

	@Autowired
	private MiniatureDAO dao;
	
	@Override
	public Miniature findMiniatureById(int id) {

		return dao.findMiniatureById(id);
	}

	@Override
	public Miniature findMiniatureByName(String miniatureName) {
		// TODO Auto-generated method stub
		return dao.findMiniatureByName(miniatureName);
	}

	@Override
	public void saveMiniature(Miniature miniature) {
		dao.saveMiniature(miniature);
		
	}

	@Override
	public void updateMiniature(Miniature miniature) {
		dao.updateMiniature(miniature);
		
	}

	@Override
	public void deleteMiniatureById(String miniatureId) {
		dao.deleteMiniatureById(miniatureId);
		
	}

	@Override
	public void deleteMiniatureByName(String miniatureName) {
		dao.deleteMiniatureByName(miniatureName);
		
	}

	@Override
	public List<Miniature> findAllMiniatures() {
		
		return dao.findAllMiniatures();
	}

	@Override
	public List<Miniature> findAllMiniaturesBySize(String miniatureSize) {
		return dao.findAllMiniaturesBySize(miniatureSize);
	}

	@Override
	public List<Miniature> findAllMiniaturesByType(String miniatureType) {
		return dao.findAllMiniaturesByType(miniatureType);
	}

	@Override
	public List<Miniature> findAllMiniaturesByGameSystem(int gsId) {
		return dao.findAllMiniaturesByGameSystem(gsId);
	}

	@Override
	public List<Miniature> findAllMiniaturesByFaction(int factionId) {
		return dao.findAllMiniaturesByFaction(factionId);
	}

	@Override
	public List<Miniature> findAllMiniaturesByManuf(int manufId) {
		return dao.findAllMiniaturesByManuf(manufId);
	}

}
