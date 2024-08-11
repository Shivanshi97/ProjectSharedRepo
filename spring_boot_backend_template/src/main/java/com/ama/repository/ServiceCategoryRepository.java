package com.ama.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ama.entities.Service;
import com.ama.entities.ServiceCategory;

@Repository
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, Long> {

	Optional<ServiceCategory> findByCategoryName(String categoryName);

//	Optional<Service> findByName(String serviceName);

//	void delete(Optional<ServiceCategory> findByCategoryName);



	//Optional<ServiceCategory> deleteByName(String categoryName);
}
