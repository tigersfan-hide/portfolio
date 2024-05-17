package com.example.portfolio.service;

import org.springframework.stereotype.Service;

import com.example.portfolio.entity.Restaurant;
import com.example.portfolio.entity.Transformation;
import com.example.portfolio.repository.RestaurantRepository;

@Service
public class CategoryService {
	private final RestaurantRepository restaurantRepository;
	
	public CategoryService(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}
	
	public Transformation getList(Integer id) {
		Transformation transformation = new Transformation();
		Restaurant restaurant = restaurantRepository.getReferenceById(id);
		
		
		switch(restaurant.getCategoryId()) {
		case 1 -> transformation.setCategory("焼肉");
		case 2 -> transformation.setCategory("ラーメン");
		case 3 -> transformation.setCategory("鉄板料理");
		case 4 -> transformation.setCategory("居酒屋");
		case 5 -> transformation.setCategory("イタリアン");
		case 6 -> transformation.setCategory("中華料理");
		case 7 -> transformation.setCategory("日本料理");
		case 8 -> transformation.setCategory("フレンチ");
		case 9 -> transformation.setCategory("韓国料理");
		case 10 -> transformation.setCategory("カフェ");
		case 11 -> transformation.setCategory("鍋料理");
		case 12 -> transformation.setCategory("名古屋名物");
		default -> transformation.setCategory("その他");
		}
		
		transformation.setId(restaurant.getId());
		transformation.setName(restaurant.getName());
		transformation.setImageName(restaurant.getImageName());
		transformation.setAddress(restaurant.getAddress());
		transformation.setPhoneNumber(restaurant.getPhoneNumber());
		transformation.setDescription(restaurant.getDescription());
		transformation.setBudget(restaurant.getBudget());
		transformation.setOpeningHours(restaurant.getOpeningHours());
		transformation.setCapacity(restaurant.getCapacity());
		transformation.setHoliday(restaurant.getHoliday());
		
		return transformation;
	}
}
