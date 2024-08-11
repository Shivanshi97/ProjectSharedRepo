package com.ama.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ama.entities.Booking;
import com.ama.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByName(String providerName);

	Optional<User> findById(User customerId);

	Optional<User> findByEmailAndPassword(String email, String password);

}
