package com.miniworkshop.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.miniworkshop.springmvc.model.GameSystem;
import com.miniworkshop.springmvc.model.Manufacturer;
import com.miniworkshop.springmvc.model.Miniature;
import com.miniworkshop.springmvc.model.User;

@Repository("gameSystemDAO")
public class GameSystemDAOImpl extends AbstractDao<Integer, GameSystem> implements GameSystemDAO {
	
	static final Logger logger = LoggerFactory.getLogger(MiniatureDAOImpl.class);

	@Override
	public GameSystem findGameSystemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameSystem findGameSystemByName(String gameSystemName) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("gameSystem_Name", gameSystemName));
		return (GameSystem) crit.uniqueResult();
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
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("gsName"));
		criteria.add(Restrictions.eq("manufId", manuf_id));
		List<GameSystem> gameSystemsList = (List<GameSystem>) criteria.list();
		return gameSystemsList;
	}

}
