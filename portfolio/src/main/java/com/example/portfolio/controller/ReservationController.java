package com.example.portfolio.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.portfolio.entity.Reservation;
import com.example.portfolio.entity.Restaurant;
import com.example.portfolio.entity.User;
import com.example.portfolio.form.ReservationInputForm;
import com.example.portfolio.form.ReservationRegisterForm;
import com.example.portfolio.repository.ReservationRepository;
import com.example.portfolio.repository.RestaurantRepository;
import com.example.portfolio.security.UserDetailsImpl;
import com.example.portfolio.service.ReservationService;

@Controller
public class ReservationController {
	private final ReservationRepository reservationRepository;
	private final RestaurantRepository restaurantRepository;
	private final ReservationService reservationService;
	
	public ReservationController(ReservationRepository reservationRepository, RestaurantRepository restaurantRepository, ReservationService reservationService){
		this.reservationRepository = reservationRepository;
		this.restaurantRepository = restaurantRepository;
		this.reservationService = reservationService;
	}
	
	@GetMapping("/reservations")
		public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.DESC) Pageable pageable, Model model) {
			User user = userDetailsImpl.getUser();
			Page<Reservation> reservationPage = reservationRepository.findByUserOrderByCreatedAtDesc(user, pageable);
			
			model.addAttribute("reservationPage", reservationPage);
			
			return "reservations/index";
	}
	
	@GetMapping("/restaurant/{id}/reservations")
		public String reservation(@PathVariable(name = "id") Integer id, Model model) {
		
		Restaurant restaurant = restaurantRepository.getReferenceById(id);
		
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("reservationInputForm", new ReservationInputForm());
		
		return "reservations/reservation";
	}
	
	@GetMapping("/restaurant/{id}/reservations/input")
	public String input(@PathVariable(name = "id") Integer id,
						@ModelAttribute @Validated ReservationInputForm reservationInputForm,
						BindingResult bindingResult,
						RedirectAttributes redirectAttributes,
						Model model) 
	{
		Restaurant restaurant = restaurantRepository.getReferenceById(id);
		Byte numberOfPeople = reservationInputForm.getNumberOfPeople();
		Byte capacity = restaurant.getCapacity();
		
		if(numberOfPeople != null) {
			if(!reservationService.isWithinCapacity(numberOfPeople, capacity)) {
				FieldError fieldError = new FieldError(bindingResult.getObjectName(), "numberOfPeople", "来店人数が定員を超えています。");
				bindingResult.addError(fieldError);
			}
		}
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("restaurant", restaurant);
			model.addAttribute("errorMessage", "予約内容に不備があります。");
			return "reservations/reservation";
		}
		
		redirectAttributes.addFlashAttribute("reservationInputForm", reservationInputForm);
		
		return "redirect:/restaurant/{id}/reservations/confirm";
	}
	
	@GetMapping("/restaurant/{id}/reservations/confirm")
	public String confirm(@PathVariable(name = "id")Integer id,
						@ModelAttribute ReservationInputForm reservationInputForm,
						@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
						Model model) {
		
		Restaurant restaurant = restaurantRepository.getReferenceById(id);
		User user = userDetailsImpl.getUser();
		
		String visitingTime = reservationInputForm.getVisitingTime();
		
		ReservationRegisterForm reservationRegisterForm = new ReservationRegisterForm(restaurant.getId(), user.getId(), visitingTime.toString(), reservationInputForm.getNumberOfPeople());
		
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("reservationRegisterForm", reservationRegisterForm);
		
		return "reservations/confirm";
	}
	
	@PostMapping("/restaurant/{id}/reservations/create")
	public String create(@ModelAttribute ReservationRegisterForm reservationRegisterForm) {
		reservationService.create(reservationRegisterForm);
		
		return "redirect:/reservations?reserved";
	}
}