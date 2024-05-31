package com.example.portfolio.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.portfolio.entity.Reservation;
import com.example.portfolio.entity.Restaurant;
import com.example.portfolio.entity.User;
import com.example.portfolio.form.ReservationRegisterForm;
import com.example.portfolio.repository.ReservationRepository;
import com.example.portfolio.repository.RestaurantRepository;
import com.example.portfolio.repository.UserRepository;

@Service
public class ReservationService {
	private final ReservationRepository reservationRepository;
	private final RestaurantRepository restaurantRepository;
	private final UserRepository userRepository;
	
	public ReservationService(ReservationRepository reservationRepository, RestaurantRepository restaurantRepository, UserRepository userRepository) {
		this.reservationRepository = reservationRepository;
		this.restaurantRepository = restaurantRepository;
		this.userRepository = userRepository;
	}
	
	@Transactional
	public void create(ReservationRegisterForm reservationRegisterForm) {
		Reservation reservation = new Reservation();
		Restaurant restaurant = restaurantRepository.getReferenceById(reservationRegisterForm.getRestaurantId());
		User user = userRepository.getReferenceById(reservationRegisterForm.getUserId());
		String dateTime = reservationRegisterForm.getVisitingTime();
		LocalDateTime visitngTime = LocalDateTime.parse(dateTime.substring(0, 10) + "T" + dateTime.subSequence(11, 16) + ":00.00");
		
		reservation.setRestaurant(restaurant);
		reservation.setUser(user);
		reservation.setVisitingTime(visitngTime);
		reservation.setNumberOfPeople(reservationRegisterForm.getNumberOfPeople());
		
		reservationRepository.save(reservation);
	}
	
	public boolean isWithinCapacity(Byte numberOfPeople, Byte capacity) {
		return numberOfPeople <= capacity;
		
	}
}
