package com.miniworkshop.springmvc.dao;

import java.util.List;

import com.miniworkshop.springmvc.model.Base;


public interface  BaseDAO {
	
	Base findBaseById(int id);

	Base findBaseByType(String baseType);

	void saveBase(Base base);

	void updateBase(Base base);

	void deleteBaseById(String baseId);

	void deleteBaseByName(String baseType);

	List<Base> findAllBases();

}
