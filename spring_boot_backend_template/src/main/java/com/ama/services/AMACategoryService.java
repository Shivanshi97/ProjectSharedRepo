package com.ama.services;

import java.util.List;

import com.ama.entities.ServiceCategory;

public interface AMACategoryService {

	//for all users
	List<ServiceCategory> listAllCAtegories(ServiceCategory category);
	
	//for admin
	ServiceCategory addCategory(ServiceCategory newCategory);
	
	String updateCategory(ServiceCategory categoryName);
	
	//for delete
	String deleteCategory(String categoryName);
}
