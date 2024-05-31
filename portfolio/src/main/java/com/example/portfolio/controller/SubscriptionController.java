package com.example.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {
	@GetMapping("/recommend")
	public String index() {
		return "/subscription/index";
	}
	
	
}
