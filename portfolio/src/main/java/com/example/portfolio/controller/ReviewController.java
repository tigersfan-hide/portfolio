package com.example.portfolio.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.portfolio.entity.Restaurant;
import com.example.portfolio.entity.Review;
import com.example.portfolio.entity.User;
import com.example.portfolio.form.ReviewForm;
import com.example.portfolio.form.ReviewRegisterForm;
import com.example.portfolio.repository.RestaurantRepository;
import com.example.portfolio.repository.ReviewRepository;
import com.example.portfolio.security.UserDetailsImpl;
import com.example.portfolio.service.ReviewService;

@Controller
public class ReviewController {
	private final ReviewRepository reviewRepository;
	private final RestaurantRepository restaurantRepository;
	private final ReviewService reviewService;
	
	public ReviewController(ReviewRepository reviewRepository, RestaurantRepository restaurantRepository, ReviewService reviewService) {
		this.reviewRepository = reviewRepository;
		this.restaurantRepository = restaurantRepository;
		this.reviewService = reviewService;
	}
	
	@GetMapping("/restaurant/{id}/reviews")
	public String review(@PathVariable(name = "id")Integer id, Model model) {
		Review review = reviewRepository.getReferenceById(id);
		Restaurant restaurant =restaurantRepository.getReferenceById(id);
		
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("review", review);
		model.addAttribute("reviewForm", new ReviewForm());
		
		return "reviews/review";
	}
	
	
	@PostMapping("/restaurant/{id}/reviews/create")
	public String create(@PathVariable(name = "id")Integer id,
						@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
						@ModelAttribute @Validated ReviewForm reviewForm,
						BindingResult bindingResult,
						RedirectAttributes redirectAttributes,
						Model model)
	{
		User user = userDetailsImpl.getUser();
		Restaurant restaurant = restaurantRepository.getReferenceById(id);

		ReviewRegisterForm reviewRegisterForm = new ReviewRegisterForm(user.getId(), restaurant.getId(), reviewForm.getReviewScore(), reviewForm.getReview());
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("restaurant", restaurant);
			
			return "reviews/review";
		}
		
		reviewService.create(reviewRegisterForm);
		
		redirectAttributes.addFlashAttribute("successMessage", "レビューを投稿しました。");
		
		return "redirect:/";
	}
}
