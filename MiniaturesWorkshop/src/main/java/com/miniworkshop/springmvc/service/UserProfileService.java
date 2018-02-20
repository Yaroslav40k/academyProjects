package com.miniworkshop.springmvc.service;

import java.util.List;

import com.miniworkshop.springmvc.model.UserProfile;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
