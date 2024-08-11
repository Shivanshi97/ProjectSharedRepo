package com.ama.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ama.entities.Service;

@Repository
public interface AMAServiceRepository extends JpaRepository<Service, Long> {

     //  void findByName(String serviceName);

//	Optional<Service> findByName(String serviceName);

	Optional<Service> findByServiceName(String serviceName);

	//add a derived finder method for finding service

	
	

}
