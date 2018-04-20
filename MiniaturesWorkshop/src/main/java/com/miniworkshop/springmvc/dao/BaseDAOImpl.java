package com.miniworkshop.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.miniworkshop.springmvc.model.Base;
import com.miniworkshop.springmvc.model.Faction;
import com.miniworkshop.springmvc.model.Miniature;

@Repository("baseDAO")
public class BaseDAOImpl extends AbstractDao<Integer, Base> implements BaseDAO {
	
	static final Logger logger = LoggerFactory.getLogger(MiniatureDAOImpl.class);

	@Override
	public Base findBaseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Base findBaseByType(String baseType) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("base_Type", baseType));
		return (Base) crit.uniqueResult();
	}

	@Override
	public void saveBase(Base base) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBase(Base base) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBaseById(String baseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBaseByName(String baseType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Base> findAllBases() {
		// TODO Auto-generated method stub
		return null;
	}

}
