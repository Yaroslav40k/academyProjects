package com.miniworkshop.springmvc.dao;
import java.util.List;

import com.miniworkshop.springmvc.model.Phone;

public interface PhoneDAO {
	
	Phone findById(long id);
	
	List <Phone> findByOwner(int owner_id);
	
	void save(Phone phone);
	void updatePhone(Phone phone);
	
	void deleteByOwner(int owner_id);
	void deleteById (long id);
	
	List<Phone> findAllPhones();
	List<Phone> findABySSO(String SSO);


}