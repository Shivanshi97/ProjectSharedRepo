package com.ama.services;

import java.util.List;

import com.ama.dto.ApiResponse;
import com.ama.entities.Review;

public interface ReviewService {
	
	//for admin
	List<Review> listAllReviews();
	
	//for admin and customer
	String deleteReviews(Long id);
	
	//for admin and customer
	ApiResponse addReview(Review newReview);
}
