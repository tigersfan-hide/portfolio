package com.example.portfolio.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portfolio.entity.Transformation;
import com.example.portfolio.repository.RestaurantRepository;
import com.example.portfolio.service.CategoryService;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
	private final CategoryService categoryService;
	
	public RestaurantController(RestaurantRepository restaurantRepository, CategoryService categoryService) {

		this.categoryService = categoryService;
	}

	
	@GetMapping("/{id}")
	public String show(@PathVariable(name = "id")Integer id, Model model) {
		Transformation transformation = categoryService.getList(id);
		model.addAttribute("restaurant", transformation);
		return "restaurant/show";
	}
}
