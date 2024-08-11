package com.ama.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ama.entities.ServiceProvider;
import com.ama.entities.User;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {


	Optional<ServiceProvider> searchByProviderName(String serviceName);

	//Optional<ServiceProvider> findByName(String providerName);

	//Optional<ServiceProvider> findByName(User providerName);
}
