//package com.example.portfolio.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.example.portfolio.repository.UserRepository;
//
//@Controller
//@RequestMapping("/admin/users")
//public class AdminUserController {
//	private final UserRepository userRepository;
//	
//	public AdminUserController(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
//	
//	@GetMapping
//	public String index(@RequestParam(name = "keyword", required = false) String keyword, ) {
//		
//		return "admin/users/index";
//	}
//}
