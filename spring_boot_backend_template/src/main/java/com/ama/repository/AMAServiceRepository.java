package com.ama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ama.entities.Service;

public interface AMAServiceRepository extends JpaRepository<Service, Long> {

}
