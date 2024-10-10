package com.example.portfolio.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
						@RequestParam(name = "order", required = false)String order,
						@PageableDefault(page=0, size=10) Pageable pageable,
						Model model) {
		
		Sort sort = Sort.by("id");
		if(order != null && order.equals("IdDesc")) {
			sort = sort.descending();
		} else {
			sort = sort.ascending();
		}
		pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
		
		Page<Restaurant> restaurantPage;
		
		if(keyword != null && !keyword.isEmpty()) {
			restaurantPage = restaurantRepository.findByNameLikeOrAddressLike("%" + keyword + "%", "%" + keyword + "%", pageable);
//			if(order != null && order.equals("IdDesc")) {
//				restaurantPage = restaurantRepository.findByNameLikeOrAddressLikeOrderByIdDesc("%" + keyword + "%", "%" + keyword + "%", pageable);
//			} else {
//				restaurantPage = restaurantRepository.findByNameLikeOrAddressLikeOrderByIdAsc("%" + keyword + "%", "%" + keyword + "%", pageable);
//			}
		}else if(categoryId != null){
			restaurantPage = restaurantRepository.findByCategoryId(categoryId, pageable);
//			if(order != null && order.equals("IdDesc")) {
//				restaurantPage = restaurantRepository.findByCategoryIdOrderByIdDesc(categoryId, pageable);
//			} else {
//				restaurantPage = restaurantRepository.findByCategoryIdOrderByIdAsc(categoryId, pageable);
//			}
		}else {
			restaurantPage = restaurantRepository.findAll(pageable);
//			if(order != null && order.equals("IdDesc")) {
//				restaurantPage = restaurantRepository.findAllOrderByIdDesc(pageable);
//			} else {
//				restaurantPage = restaurantRepository.findAllOrderByIdAsc(pageable);
//			}
		}
		
		model.addAttribute("restaurantPage", restaurantPage);
		model.addAttribute("keyword", keyword);
		model.addAttribute("order", order);
		
		return "index";
	}
}
