package com.example.portfolio.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portfolio.entity.Transformation;
import com.example.portfolio.repository.RestaurantRepository;
import com.example.portfolio.service.AverageReviewScoreService;
import com.example.portfolio.service.CategoryService;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
	private final CategoryService categoryService;
	private final AverageReviewScoreService averageReviewScoreService;
	
	public RestaurantController(RestaurantRepository restaurantRepository, CategoryService categoryService, AverageReviewScoreService averageReviewScoreService) {
		this.categoryService = categoryService;
		this.averageReviewScoreService = averageReviewScoreService;
	}

	
	@GetMapping("/{id}")
	public String show(@PathVariable(name = "id")Integer id, Model model) {
		Transformation transformation = categoryService.getList(id);
		
		Double averageReviewScore = averageReviewScoreService.averageReviewScore(id);
		
		model.addAttribute("restaurant", transformation);
		model.addAttribute("averageReviewScore", averageReviewScore);
		
		return "restaurant/show";
	}
}
