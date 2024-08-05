package com.ama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ama.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
