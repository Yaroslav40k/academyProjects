package com.miniworkshop.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miniworkshop.springmvc.dao.BaseDAO;
import com.miniworkshop.springmvc.model.Base;

@Service("baseService")
@Transactional
public class BaseServiceImpl implements BaseService {
	
	@Autowired
	private BaseDAO dao;

	@Override
	public Base findBaseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Base findBaseByType(String baseType) {
		// TODO Auto-generated method stub
		return dao.findBaseByType(baseType);
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
