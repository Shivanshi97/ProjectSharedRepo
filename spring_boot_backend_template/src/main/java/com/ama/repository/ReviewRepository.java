package com.ama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ama.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
