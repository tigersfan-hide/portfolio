package com.example.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.portfolio.form.SignupForm;
import com.example.portfolio.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthController {
	private final UserService userService;
//	private final StripeService stripeService;
	
	public AuthController(UserService userService) {
		this.userService = userService;
//		this.stripeService = stripeService;
	}
	
	@GetMapping("/login")
	public String login(){
		return "auth/login";
	}
	
	@GetMapping("/signup")
	public String signup(Model model){
		model.addAttribute("signupForm", new SignupForm());
		return "auth/signup";
	}
	
	@PostMapping("/signup")
	public String signup(@ModelAttribute @Validated SignupForm signupForm,
						BindingResult bindingResult,
						RedirectAttributes redirectAttributes,
						HttpServletRequest httpServletRequest,
						Model model
						) {
//		if(signupForm.getRole().equals("ROLE_PAID")) {
//			userService.create(signupForm);
//			String sessionId = stripeService.createStripeSession(signupForm, httpServletRequest);
//			
//			return "redirect:/stripe-checkout?sessionId=" + sessionId;
//		}else{
			if(userService.isEmailRegistered(signupForm.getEmail())) {
				FieldError fieldError = new FieldError(bindingResult.getObjectName(), "email", "すでに登録済みのメールアドレスです。");
				bindingResult.addError(fieldError); 
			}
			
			if(!userService.isSamePassword(signupForm.getPassword(), signupForm.getPasswordConfirmation())) {
				FieldError fieldError2 = new FieldError(bindingResult.getObjectName(), "password", "パスワードが一致しません。");
				bindingResult.addError(fieldError2);
			}
			
			if(bindingResult.hasErrors()) {
				return "auth/signup";
			}
			
				userService.create(signupForm);
				redirectAttributes.addFlashAttribute("successMessage", "会員登録が完了しました。");
			
			return "redirect:/";
	}
	
	@GetMapping("/stripe-checkout")
	public String stripeCheckout(@RequestParam("sessionId") String sessionId, Model model) {
		
		model.addAttribute("sessionId", sessionId);
		
		return "auth/stripeCheckout";
	}
}
