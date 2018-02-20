package com.miniworkshop.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miniworkshop.springmvc.dao.ManufacturerDAO;
import com.miniworkshop.springmvc.model.Manufacturer;

@Service("manufacturerService")
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {
	
	@Autowired
	private ManufacturerDAO dao;

	@Override
	public Manufacturer findManufacturerById(int id) {
		// TODO Auto-generated method stub
		return dao.findManufacturerById(id);
	}

	@Override
	public Manufacturer findManufacturerByName(String manufacturerName) {
		// TODO Auto-generated method stub
		return dao.findManufacturerByName(manufacturerName);
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
		// TODO Auto-generated method stub
		return dao.findAllManufacturers();
	}

}
