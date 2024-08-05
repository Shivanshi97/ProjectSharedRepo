package com.ama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ama.entities.ServiceCategory;

public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, Long> {

}
