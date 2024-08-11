package com.ama.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ama.custom_exceptions.ResourceNotFoundException;
import com.ama.dto.ApiResponse;
import com.ama.entities.Booking;
import com.ama.entities.Review;
import com.ama.entities.User;
import com.ama.repository.BookingRepository;
import com.ama.repository.ReviewRepository;
import com.ama.repository.UserRepository;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private BookingRepository bookingRepository; 
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public List<Review> listAllReviews() {
		return reviewRepository.findAll() //List<Review>
				.stream() //Stream<Review>
				.map(review -> 
				modelMapper.map(review,Review.class)) 
				.collect(Collectors.toList());
	}
	@Override
	public String deleteReviews(Long id) {
		if (reviewRepository.existsById(id)) {
			// API of CrudRepo - public void deleteById(ID id)
			reviewRepository.deleteById(id);
			return "Review deleted successfully";
		}
		return "deleting service details failed : Invalid Service ID";
	}
	@Override
	public ApiResponse addReview(Review newReview) {
		Booking bookingId = bookingRepository
				.findById(newReview.getBookingId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid provider id !!!!"));
		User customerId = userRepository
				.findById(newReview.getCustomerId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid provider name !!!!"));
		//category, provider : persistent
		//map service dto --> entity
		Review addReview = modelMapper.map(newReview, Review.class);
		//establish E-R
		//review 1---->1 booking
		//review  *--->1 customer
		addReview.setBookingId(bookingId);
		addReview.setCustomerId(customerId);
		//=> success
		return new ApiResponse("new blog post added ");
	}
}