package com.example.portfolio.form;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewRegisterForm {
	private Integer userId;
	
	private Integer restaurantId;
	
	private Byte reviewScore;
	
	private String review;
}
