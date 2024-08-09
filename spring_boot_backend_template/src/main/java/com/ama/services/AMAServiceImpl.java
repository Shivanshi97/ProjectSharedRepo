package com.ama.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ama.custom_exceptions.InvalidDataException;
import com.ama.custom_exceptions.ResourceNotFoundException;
import com.ama.dto.ApiResponse;
import com.ama.dto.ServiceDTO;
import com.ama.entities.Service;
import com.ama.entities.ServiceCategory;
import com.ama.entities.ServiceProvider;
import com.ama.repository.AMAServiceRepository;
import com.ama.repository.ServiceCategoryRepository;
import com.ama.repository.ServiceProviderRepository;
import com.ama.repository.UserRepository;

@org.springframework.stereotype.Service
@Transactional

public class AMAServiceImpl implements AMAService{
	
	//DI AMAServiceRepository
	@Autowired
	private AMAServiceRepository serviceRepository;
	@Autowired
	private ServiceCategoryRepository serviceCategoryRepository;
	@Autowired
	private ServiceProviderRepository providerRepository;
	@Autowired
	private ModelMapper modelMapper;
//		@Autowired
//	    private AMAServiceRepository serviceRepository;
//
//	    @Autowired
//	    private ServiceCategoryRepository serviceCategoryRepository;
//
//	    @Autowired
//	    private UserRepository userRepository;
//
//	    @Autowired
//	    private ModelMapper modelMapper;
	

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
		Optional<Service> optional = serviceRepository.
				searchByName(serviceName);
		return optional.orElseThrow(() ->
		new InvalidDataException("Invalid service name !!!!"));
	}

	@Override
	public ApiResponse addNewService(ServiceDTO newService) {
		// 1. get category from category id
				ServiceCategory categoryId = serviceCategoryRepository
						.findById(newService.getCategoryId())
						.orElseThrow(() -> new ResourceNotFoundException("Invalid category id !!!!"));
				ServiceCategory categoryName = serviceCategoryRepository
						.findByCategoryName(newService.getCategoryName())
						.orElseThrow(() -> new ResourceNotFoundException("Invalid category name !!!!"));
				ServiceProvider providerId = providerRepository
						.findById(newService.getProviderId())
						.orElseThrow(() -> new ResourceNotFoundException("Invalid provider id !!!!"));
				ServiceProvider providerName = providerRepository
						.searchByName(newService.getProviderName())
						.orElseThrow(() -> new ResourceNotFoundException("Invalid provider name !!!!"));
				//category, provider : persistent
				//map service dto --> entity
				Service addService = modelMapper.map(newService, Service.class);
				//establish E-R
				//service  *--->1 category
		//		category.addService(newService);
				addService.setCategoryId(categoryId);
				addService.setCategoryName(categoryName);
				// service 1---->1 provider
				addService.setProviderId(providerId);
				addService.setProviderName(providerName);
				//=> success
				return new ApiResponse("new blog post added ");
	}
	
//	@Override
//	public ApiResponse addNewService(ServiceDTO newService) {
//	    // 1. Get category from category ID
//	    ServiceCategory category = serviceCategoryRepository
//	            .findById(newService.getCategoryId())
//	            .orElseThrow(() -> new ResourceNotFoundException("Category not found for ID: " + newService.getCategoryId()));
//
//	    // 2. Get provider (user) from provider ID
//	    User provider = userRepository
//	            .findById(newService.getProviderId())
//	            .orElseThrow(() -> new ResourceNotFoundException("Provider not found for ID: " + newService.getProviderId()));
//
//	    // 3. Map ServiceDTO to Service entity
//	    Service service = modelMapper.map(newService, Service.class);
//
//	    // 4. Set the category and provider for the service
//	    service.setCategoryId(category);
//	    service.setProviderId(provider);
//
//	    // 5. Save the new service entity to the database
//	    serviceRepository.save(service);
//
//	    // 6. Return success response
//	    return new ApiResponse("New service added successfully");
//	}

	
//	public ApiResponse addNewService(ServiceDTO newService) {
//        ServiceCategory category;
//      //  ServiceCategory categoryId = newService.getCategoryId();
//        // Option 1: Find category by ID
//        if (newService.getCategoryId() != null) {
//            category = serviceCategoryRepository
//                    .findById(newService.getCategoryId())
//                    .orElseThrow(() -> new ResourceNotFoundException("Invalid category ID !!!!"));
//        } 
//        // Option 2: Find category by Name
//        else if (newService.getCategoryName() != null) {
//            category = serviceCategoryRepository
//                    .findByCategoryName(newService.getCategoryName())
//                    .orElseThrow(() -> new ResourceNotFoundException("Invalid category name !!!!"));
//        } else {
//            throw new IllegalArgumentException("Category ID or Name must be provided");
//        }
//
//        // Map the ServiceDTO to a Service entity
//        Service serviceEntity = modelMapper.map(newService, Service.class);
//
//        // Set the category to the Service entity
//        serviceEntity.setCategory(category);
//
//        // Save the new service to the database
//        serviceRepository.save(serviceEntity);
//
//        // Return a success response
//        return new ApiResponse("New service added successfully.");
//    }

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
