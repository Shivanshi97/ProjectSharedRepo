package com.ama.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ama.custom_exceptions.InvalidDataException;
import com.ama.dto.ApiResponse;
import com.ama.dto.ServiceDTO;
import com.ama.entities.Service;
import com.ama.entities.ServiceCategory;
import com.ama.entities.User;
import com.ama.repository.AMAServiceRepository;
import com.ama.repository.ServiceCategoryRepository;
import com.ama.repository.UserRepository;

@org.springframework.stereotype.Service
@Transactional

public class AMAServiceImpl implements AMAService{
	
	//DI AMAServiceRepository
//	@Autowired
//	private AMAServiceRepository serviceRepository;
//	@Autowired
//	private ServiceCategoryRepository srvcCategoryRepository;
//	@Autowired
//	private UserRepository userRepository;
//	@Autowired
//	private ModelMapper modelMapper;
	 @Autowired
	    private AMAServiceRepository serviceRepository;

	    @Autowired
	    private ServiceCategoryRepository serviceCategoryRepository;

	    @Autowired
	    private UserRepository userRepository;

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
		Optional<Service> optional = serviceRepository.
				searchByName(serviceName);
		return optional.orElseThrow(() ->
		new InvalidDataException("Invalid service name !!!!"));
	}

//	@Override
//	public ApiResponse addNewService(Service newService) {
//		// 1. get category from category id
//				ServiceCategory category = srvcCategoryRepository
//						.findById(newService.getCategoryId())
//						.orElseThrow(() -> new ResourceNotFoundException("Invalid category id !!!!"));
//				User helper=userRepository.findById(newService.getProviderId())
//						.orElseThrow(() -> new ResourceNotFoundException("Invalid blogger id !!!!"));
//				//category, provider : persistent
//				//map blog post dto --> entity
//				Service addService = modelMapper.map(newService, Service.class);
//				//establish E-R
//				//service  1--->1 catgeory
////				category.addService(newService);
//				// blog post 1---->1 user
//				addService.setProviderName(helper);
//				//=> success
//				return new ApiResponse("new blog post added ");
//	}
	
//	public ApiResponse addNewService(ServiceDTO newService) {
//        // 1. Get category from category ID
//        ServiceCategory categoryId = srvcCategoryRepository
//                .findById(newService.getCategoryId())
//                .orElseThrow(() -> new ResourceNotFoundException("Invalid category ID !!!!"));
//
//        // 2. Get the service provider (User) from provider ID
//        User providerId = userRepository.findById(newService.getProviderId())
//                .orElseThrow(() -> new ResourceNotFoundException("Invalid provider ID !!!!"));
//
//        // 3. Map the ServiceDTO to a Service entity
//        Service serviceEntity = modelMapper.map(newService, Service.class);
//
//        // 4. Establish the one-to-one association
//        serviceEntity.setCategoryId(categoryId);
//        serviceEntity.setProviderId(providerId);
//
//        // 5. Save the new service to the database
//        serviceRepository.save(serviceEntity);
//
//        // 6. Return a success response
//        return new ApiResponse("New service added successfully.");
//    }
	
	public ApiResponse addNewService(ServiceDTO newService) {
//        ServiceCategory category;
//        
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

        // Return a success response
        return new ApiResponse("New service added successfully.");
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
