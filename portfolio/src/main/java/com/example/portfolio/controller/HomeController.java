package com.example.portfolio.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.portfolio.entity.Restaurant;
import com.example.portfolio.repository.RestaurantRepository;

@Controller
public class HomeController {
	private final RestaurantRepository restaurantRepository;
	
	public HomeController(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	@GetMapping("/")
	public String index(Model model, @PageableDefault(page=0, size=10, sort="id", direction=Direction.ASC)Pageable pageable) {
		Page<Restaurant> restaurantPage = restaurantRepository.findAll(pageable);
		
		model.addAttribute("restaurantPage", restaurantPage);
		
		return "index";
	}	
}
