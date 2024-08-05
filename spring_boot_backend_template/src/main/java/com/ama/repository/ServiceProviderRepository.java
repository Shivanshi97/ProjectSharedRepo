package com.ama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ama.entities.ServiceProvider;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

}
