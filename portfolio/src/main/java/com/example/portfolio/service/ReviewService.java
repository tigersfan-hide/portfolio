package com.example.portfolio.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.portfolio.entity.Restaurant;
import com.example.portfolio.entity.Review;
import com.example.portfolio.entity.User;
import com.example.portfolio.form.ReviewRegisterForm;
import com.example.portfolio.repository.RestaurantRepository;
import com.example.portfolio.repository.ReviewRepository;
import com.example.portfolio.repository.UserRepository;

@Service
public class ReviewService {
	private final RestaurantRepository restaurantRepository; 
	private final UserRepository userRepository;
	private final ReviewRepository reviewRepository;
	
	public ReviewService(RestaurantRepository restaurantRepository, UserRepository userRepository, ReviewRepository reviewRepository) {
		this.restaurantRepository = restaurantRepository;
		this.userRepository = userRepository;
		this.reviewRepository = reviewRepository;
	}
	
	@Transactional
	public void create(ReviewRegisterForm reviewRegisterForm){
		Review review = new Review();
		
		User user = userRepository.getReferenceById(reviewRegisterForm.getUserId());
		Restaurant restaurant = restaurantRepository.getReferenceById(reviewRegisterForm.getRestaurantId());
		
		review.setUser(user);
		review.setRestaurant(restaurant);
		review.setReviewScore(reviewRegisterForm.getReviewScore());
		review.setReview(reviewRegisterForm.getReview());
		
		reviewRepository.save(review);
	}
}
