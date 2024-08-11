package com.ama.services;

import java.util.List;

import com.ama.dto.ApiResponse;
import com.ama.dto.ServiceProviderDTO;
import com.ama.entities.ServiceProvider;

public interface ServiceProviderService {
	//for admin
	List<ServiceProvider> listAllServiceProviders();
	
	//for serviceProvider
	ApiResponse addNewProvider(ServiceProviderDTO newServiceProvider);
	
	String updateProvider(ServiceProvider serviceProvider);
	
	String deleteProvider(Long id);
	
}
