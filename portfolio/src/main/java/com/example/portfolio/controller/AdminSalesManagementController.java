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
	public String salesByAge(Model model) {
		
		int[] ageGroup = {0, 10, 20, 30, 40, 50, 60, 70};
		
		int[] salesByAge = salesManagementService.getSalesByAge(ageGroup);
		
		model.addAttribute("salesByAge", salesByAge);
		model.addAttribute("ageGroup", ageGroup);
		
		return "admin/sales/salesbyage";
	}
	
	@GetMapping("/occupation")
	public String salesByOccupation(Model model) {
		
		int[] occupationGroup = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		String[] occupationNameGroup = {"公務員", "経営者・役員", "会社員", "自営業", "自由業", "専業主婦", "パート・アルバイト", "学生", "その他"};
		
		int[] salesByOccupation = salesManagementService.getSalesByOccupation(occupationGroup);
		
		model.addAttribute("occupationNameGroup", occupationNameGroup);
		model.addAttribute("salesByOccupation", salesByOccupation);
		
		return "admin/sales/salesbyoccupation";
	}
}
