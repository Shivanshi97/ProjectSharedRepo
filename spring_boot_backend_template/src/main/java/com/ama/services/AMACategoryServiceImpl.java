package com.ama.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ama.custom_exceptions.InvalidDataException;
import com.ama.entities.ServiceCategory;
import com.ama.entities.User;
import com.ama.repository.ServiceCategoryRepository;

@Service
@Transactional
public class AMACategoryServiceImpl implements AMACategoryService{

	@Autowired
	private ServiceCategoryRepository categoryRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<ServiceCategory> listAllCAtegories(ServiceCategory category) {
		return categoryRepository.findAll() //List<Category>
				.stream() //Stream<Service>
				.map(service -> 
				modelMapper.map(category,ServiceCategory.class)) 
				.collect(Collectors.toList());
	}

	@Override
	public ServiceCategory addCategory(ServiceCategory newCategory) {
		return categoryRepository.save(newCategory);
	}

	@Override
	public String updateCategory(ServiceCategory categoryName) {
		 categoryRepository.save(categoryName);
		 return "Category updated successfully";
	}

	@Override
	public String deleteCategory(String categoryName) {
		ServiceCategory delCategory = categoryRepository.findByCategoryName(categoryName)
				.orElseThrow(()-> new InvalidDataException("Invalid Id : Data not deleted"));
		categoryRepository.delete(delCategory);
		return "Category Deleted Successfully";
	}

	
}
