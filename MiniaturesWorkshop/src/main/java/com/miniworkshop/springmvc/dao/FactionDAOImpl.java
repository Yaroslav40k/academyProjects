package com.miniworkshop.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.miniworkshop.springmvc.model.Faction;
import com.miniworkshop.springmvc.model.GameSystem;
import com.miniworkshop.springmvc.model.Miniature;

@Repository("factionDAO")
public class FactionDAOImpl extends AbstractDao<Integer, Faction>  implements FactionDAO {
	
	static final Logger logger = LoggerFactory.getLogger(MiniatureDAOImpl.class);
	
	@Override
	public Faction findFactionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Faction findFactionByName(String factionName) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("faction_Name", factionName));
		return (Faction) crit.uniqueResult();
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
		
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("factionName"));
		criteria.add(Restrictions.eq("gsId",  gs_id));
		List<Faction> factionsList = (List<Faction>) criteria.list();
		return factionsList;
	}

}
