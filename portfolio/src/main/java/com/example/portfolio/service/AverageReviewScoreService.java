package com.example.portfolio.service;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.portfolio.entity.Restaurant;
import com.example.portfolio.entity.Review;
import com.example.portfolio.repository.RestaurantRepository;
import com.example.portfolio.repository.ReviewRepository;

@Service
public class AverageReviewScoreService {
	private final ReviewRepository reviewRepository;
	private final RestaurantRepository restaurantRepository;
	
	public AverageReviewScoreService(ReviewRepository reviewRepository, RestaurantRepository restaurantRepository) {
		this.reviewRepository = reviewRepository;
		this.restaurantRepository = restaurantRepository;
	}
	
	public Double averageReviewScore(Integer id) {
		Restaurant restaurant = restaurantRepository.getReferenceById(id);
		
		List<Review> reviews = reviewRepository.findAll();
		
		List<Review> restaurantReviews = reviews.stream()
				.filter(review -> review.getRestaurant().getId() == restaurant.getId())
				.collect(Collectors.toList());
			
		OptionalDouble averageReviewScore = restaurantReviews.stream()
			.mapToInt(Review::getReviewScore)
			.average();
		
		return averageReviewScore.isPresent() ? Math.floor(averageReviewScore.getAsDouble()*10) / 10 : 0.0;
	}
}
