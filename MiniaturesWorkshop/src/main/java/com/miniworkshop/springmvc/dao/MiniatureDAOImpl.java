package com.miniworkshop.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.miniworkshop.springmvc.model.GameSystem;
import com.miniworkshop.springmvc.model.Miniature;

@Repository("miniatureDAO")
public class MiniatureDAOImpl extends AbstractDao<Integer, Miniature> implements MiniatureDAO {

	static final Logger logger = LoggerFactory.getLogger(MiniatureDAOImpl.class);

	@Override
	public Miniature findMiniatureById(int id) {
		Miniature model = getByKey(id);
		return model;
	}

	@Override
	public Miniature findMiniatureByName(String modelName) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("model_name", modelName));
		return (Miniature) crit.uniqueResult();
	}

	@Override
	public void saveMiniature(Miniature model) {
		persist(model);

	}

	@Override
	public void updateMiniature(Miniature model) {
		update(model);

	}

	@Override
	public void deleteMiniatureById(String modelId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("miniature_id", modelId));
		Miniature model = (Miniature) crit.uniqueResult();
		delete(model);

	}

	@Override
	public void deleteMiniatureByName(String modelName) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("miniatureName", modelName));
		Miniature model = (Miniature) crit.uniqueResult();
		delete(model);

	}

	@Override
	public List<Miniature> findAllMiniatures() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("miniatureName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
		List<Miniature> models = (List<Miniature>) criteria.list();
		return models;
	}

	@Override
	public List<Miniature> findAllMiniaturesBySize(String modelSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Miniature> findAllMiniaturesByType(String modelType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Miniature> findAllMiniaturesByGameSystem(int gsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Miniature> findAllMiniaturesByFaction(int factionId) {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("miniatureName"));
		criteria.add(Restrictions.eq("factionId", factionId));
		List<Miniature> miniaturesList = (List<Miniature>) criteria.list();
		return miniaturesList;
	}

	@Override
	public List<Miniature> findAllMiniaturesByManuf(int manufId) {
		// TODO Auto-generated method stub
		return null;
	}

}
