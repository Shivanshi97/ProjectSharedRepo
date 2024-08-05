package com.ama.services;

import java.util.List;

import com.ama.entities.Service;

public interface AMAService {

	//for admin & customer
	List<Service> viewAllServices();
	
	//for helper 
	Service viewSelectedService(String serviceName);
	
	String updateService(Service service);
	
	String deleteService(Service serviceId);
}
