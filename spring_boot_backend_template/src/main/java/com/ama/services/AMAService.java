package com.ama.services;

import java.util.List;

import com.ama.dto.ApiResponse;
import com.ama.dto.ServiceDTO;
import com.ama.entities.Service;

public interface AMAService {

	//for admin & customer
	List<Service> viewAllServices();
	
	ApiResponse addNewService(ServiceDTO newService);
	//for helper 
	Service viewSelectedService(String serviceName);
	
	String updateService(Service service);
	
	String deleteService(Long serviceId);
}
