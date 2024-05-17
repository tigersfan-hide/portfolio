package com.example.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Transformation {
	@Id
	private Integer id;
	
	private String category;
	
	private String name;

	private String imageName;
	
	private String address;
	
	private String phoneNumber;
	
	private String description;
	
	private String budget;
	
	private String openingHours;
	
	private Byte capacity;
	
	private String holiday;
}
