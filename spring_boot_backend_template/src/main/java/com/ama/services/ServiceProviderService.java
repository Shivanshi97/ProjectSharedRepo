package com.ama.services;

import java.util.List;

import com.ama.entities.ServiceProvider;
import com.ama.entities.User;

public interface ServiceProviderService {
	//for admin
	List<User> listAllServiceProviders();
	
	//for serviceProvider
	ServiceProvider addNewProvider(ServiceProvider newServiceProvider);
	
	String updateProvider(ServiceProvider serviceProvider);
	
	String deleteProvider(Long id);
	
}
