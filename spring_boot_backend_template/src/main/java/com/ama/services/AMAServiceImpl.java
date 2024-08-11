package com.ama.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ama.custom_exceptions.ResourceNotFoundException;
import com.ama.dto.ApiResponse;
import com.ama.dto.ServiceDTO;
import com.ama.entities.Service;
import com.ama.entities.ServiceCategory;
import com.ama.entities.ServiceProvider;
import com.ama.repository.AMAServiceRepository;
import com.ama.repository.ServiceCategoryRepository;
import com.ama.repository.ServiceProviderRepository;

@org.springframework.stereotype.Service
@Transactional

public class AMAServiceImpl implements AMAService{
	
	//DI AMAServiceRepository
	@Autowired
	private AMAServiceRepository serviceRepository;
	@Autowired
	private ServiceCategoryRepository categoryRepository;
	@Autowired
	private ServiceProviderRepository providerRepository;
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public List<Service> viewAllServices() {
		return serviceRepository.findAll() //List<Category>
				.stream() //Stream<Service>
				.map(service -> 
				modelMapper.map(service,Service.class)) 
				.collect(Collectors.toList());
	}

	@Override
	public Service viewSelectedService(String serviceName) {
//		Service service = serviceRepository.
//				findByName(serviceName).orElseThrow(() ->
//		new InvalidDataException("Invalid service name !!!!"));
//		return service;
		
		Optional<Service> optional = serviceRepository.findByServiceName(serviceName);
		
		return optional.orElseThrow(() -> 
		new ResourceNotFoundException("Invalid Category ID!!!!"));
	}

	@Override
	public ApiResponse addNewService(ServiceDTO newService) {
		// 1. get category from category id
		ServiceCategory category;
				ServiceCategory categoryId = categoryRepository
						.findById(newService.getCategoryId())
						.orElseThrow(() -> new ResourceNotFoundException("Invalid category id !!!!"));
				ServiceCategory categoryName = categoryRepository
						.findByCategoryName(newService.getCategoryName())
						.orElseThrow(() -> new ResourceNotFoundException("Invalid category name !!!!"));
				ServiceProvider providerId = providerRepository
						.findById(newService.getProviderId())
						.orElseThrow(() -> new ResourceNotFoundException("Invalid provider id !!!!"));
				ServiceProvider providerName = providerRepository
						.searchByProviderName(newService.getProviderName())
						.orElseThrow(() -> new ResourceNotFoundException("Invalid provider name !!!!"));
				//category, provider : persistent
				//map service dto --> entity
				Service addService = modelMapper.map(newService, Service.class);
				//establish E-R
				//service  *--->1 category
			//	category.addService(newService);
				addService.setCategoryId(categoryId);
				addService.setCategoryName(categoryName);
				// service 1---->1 provider
				addService.setProviderId(providerId);
				addService.setProviderName(providerName);
				//=> success
				return new ApiResponse("new blog post added ");
	}
	

	@Override
	public String updateService(Service service) {
		// CrudRepo : save 
		serviceRepository.save(service);
		return "Service Updated Successfully";
	}

	@Override
	public String deleteService(Long serviceId) {
		if (serviceRepository.existsById(serviceId)) {
			// API of CrudRepo - public void deleteById(ID id)
			serviceRepository.deleteById(serviceId);
			return "category details deleted";
		}
		return "deleting service details failed : Invalid Service ID";
	}

	
}
