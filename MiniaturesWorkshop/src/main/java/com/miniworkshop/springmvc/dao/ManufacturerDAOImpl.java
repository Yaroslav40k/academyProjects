package com.miniworkshop.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.miniworkshop.springmvc.model.Manufacturer;
import com.miniworkshop.springmvc.model.Miniature;



@Repository("manufacturerDAO")
public class ManufacturerDAOImpl extends AbstractDao<Integer, Manufacturer> implements ManufacturerDAO {
	
	static final Logger logger = LoggerFactory.getLogger(MiniatureDAOImpl.class);

	@Override
	public Manufacturer findManufacturerById(int id) {
		Manufacturer manufacturer = getByKey(id);

		return manufacturer;
	}

	@Override
	public Manufacturer findManufacturerByName(String manufacturerName) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("manufName", manufacturerName));
		return (Manufacturer) crit.uniqueResult();
	}

	@Override
	public void saveManufacturer(Manufacturer manufacturer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateManufacturer(Manufacturer manufacturer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManufacturerById(String manufacturerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManufacturerByName(String manufacturerName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Manufacturer> findAllManufacturers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("manufName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid duplicates.
		List<Manufacturer> manufacturers = (List<Manufacturer>) criteria.list();
		return manufacturers;
	}

}
