package com.example.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.portfolio.service.SalesManagementService;

@Controller
@RequestMapping("/admin/sales")
public class AdminSalesManagementController {
	private final SalesManagementService salesManagementService;
	
	public AdminSalesManagementController(SalesManagementService salesManagementService) {
		this.salesManagementService =salesManagementService;
	}
	
	@GetMapping
	public String index() {
		
		return "admin/sales/index";
	}
	
	@GetMapping("/age")
	public String salesByAge(Model model, int age) {
		
		int salesByAge = salesManagementService.getSalesByAge(age);
		
		model.addAttribute("salesByAge", salesByAge);
		
		return "admin/sales/salebyage";
	}
	
	@GetMapping("/occupation")
	public String salesByOccupation(Model model, Byte occupation) {
		
		int salesByAge = salesManagementService.getSalesByOccupation(occupation);
		
		model.addAttribute("salesByAge", salesByAge);
		
		return "admin/sales/salebyoccupation";
	}
}
