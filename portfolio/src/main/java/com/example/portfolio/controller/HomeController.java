package com.example.portfolio.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.portfolio.entity.Restaurant;
import com.example.portfolio.entity.Transformation;
import com.example.portfolio.repository.RestaurantRepository;
import com.example.portfolio.service.CategoryService;

@Controller
public class HomeController {
	private final RestaurantRepository restaurantRepository;
	private final CategoryService categoryService;
	public HomeController(RestaurantRepository restaurantRepository, CategoryService categoryService) {
		this.restaurantRepository = restaurantRepository;
		this.categoryService = categoryService;
	}
	
	@GetMapping("/")
	public String index(Model model, @PageableDefault(page=0, size=10, sort="id", direction=Direction.ASC)Pageable pageable) {
		Page<Restaurant> restaurantPage = restaurantRepository.findAll(pageable);
		
		model.addAttribute("restaurantPage", restaurantPage);
		
		return "index";
	}
	
	@GetMapping("/restaurant/{id}")
	public String show(@PathVariable(name = "id")Integer id, Model model) {
		Transformation transformation = categoryService.getList(id);
		model.addAttribute("restaurant", transformation);
		return "restaurant/show";
	}
}
