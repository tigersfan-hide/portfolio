package com.example.portfolio.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.portfolio.entity.User;
import com.example.portfolio.repository.UserRepository;

@Service
public class SalesManagementService {
	private final UserRepository userRepository;
	
	public SalesManagementService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	int price = 500;
	
	public int getSalesByPeriod() {
		List<User> users = userRepository.findAll();
		
		List<User> userByPeriodrList = users.stream()
				.filter(user -> user.getRole().getId() == 3)
				.collect(Collectors.toList());
		
		int SalesByPeriod = price * userByPeriodrList.size();
		
		return SalesByPeriod;
	}
	
	public int[] getSalesByAge(int[] age) {
		List<User> users = userRepository.findAll();
		
		int[] SalesByAgeList = null;
		
		for(int i = 0; i < age.length; i++) {
			List<User> userByAgeList = users.stream()
					.filter(user -> {
						int userAge = getUserAge(user.getBirthday());
						age[i] <= userAge && userAge <= age[i] + 9 && user.getRole().getId() == 3;
					})
					.collect(Collectors.toList());
			
			SalesByAgeList[i] = price * userByAgeList.size();
		}
		
		return SalesByAgeList;
	}
	
	public int getSalesByOccupation(Byte occupation) {
		List<User> users = userRepository.findAll();
		
		List<User> userByOccupationList = users.stream()
				.filter(user -> user.getOccupation() == occupation && user.getRole().getId() == 3)
				.collect(Collectors.toList());
		
		int SalesByOccupation = price * userByOccupationList.size();
		
		return SalesByOccupation;
	}
	
	public int getUserAge(int birthday){
		Integer i = Integer.valueOf(birthday);
		String stringBirthday = i.toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		Date userBirthday;
		try {
			userBirthday = sdf.parse(stringBirthday.substring(0, 4) + "/" + stringBirthday.substring(4, 6) + "/" + stringBirthday.substring(6, 8));
		
		Date now = new Date();
		
		Calendar calendarBirth = Calendar.getInstance();
		Calendar calendarNow = Calendar.getInstance();
		
		calendarBirth.setTime(userBirthday);
		calendarNow.setTime(now);
		
		int age = calendarNow.get(Calendar.YEAR) - calendarBirth.get(Calendar.YEAR);
		
		if(calendarNow.get(Calendar.MONTH) < calendarBirth.get(Calendar.MONTH)) {
			age -= 1;
		}else if (calendarNow.get(Calendar.MONTH) == calendarBirth.get(Calendar.MONTH)) {
			if (calendarNow.get(Calendar.DATE) < calendarBirth.get(Calendar.DATE)) {
				age -= 1;
			}
		}
		return age;
		
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
