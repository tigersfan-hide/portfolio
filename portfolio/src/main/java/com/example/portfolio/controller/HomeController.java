package com.example.portfolio.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.portfolio.entity.Restaurant;
import com.example.portfolio.repository.RestaurantRepository;

@Controller
public class HomeController {
	private final RestaurantRepository restaurantRepository;
	
	public HomeController(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	@GetMapping("/")
	public String index(@RequestParam(name = "keyword", required = false) String keyword, 
						@RequestParam(name = "categoryId", required = false)Byte categoryId,
						@PageableDefault(page=0, size=10, sort="id", direction=Direction.ASC) Pageable pageable,
						Model model) {
		
		Page<Restaurant> restaurantPage;
		
		if(keyword != null && !keyword.isEmpty()) {
			restaurantPage = restaurantRepository.findByNameLikeOrAddressLike("%" + keyword + "%", "%" + keyword + "%", pageable);
			}else if(categoryId != null){
			restaurantPage = restaurantRepository.findByCategoryId(categoryId, pageable);
		}else {
			restaurantPage = restaurantRepository.findAll(pageable);
		}
		
		model.addAttribute("restaurantPage", restaurantPage);
		model.addAttribute("keyword", keyword);
//		model.addAttribute(categoryId);
		
		return "index";
	}
}
