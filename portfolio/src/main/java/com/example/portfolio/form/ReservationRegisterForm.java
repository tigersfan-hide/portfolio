package com.example.portfolio.form;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservationRegisterForm {
	private Integer restaurantId;
	
	private Integer userId;
	
	private String visitingTime;
	
	private Byte numberOfPeople;
}
