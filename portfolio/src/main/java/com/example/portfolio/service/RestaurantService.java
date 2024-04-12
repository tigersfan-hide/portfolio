package com.example.portfolio.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.portfolio.entity.Restaurant;
import com.example.portfolio.form.RestaurantEditForm;
import com.example.portfolio.form.RestaurantRegisterForm;
import com.example.portfolio.repository.RestaurantRepository;

@Service
public class RestaurantService {
	private final RestaurantRepository restaurantRepository;
	
	public RestaurantService(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}
	
	@Transactional
	public void create(RestaurantRegisterForm restaurantRegisterForm) {
		Restaurant restaurant = new Restaurant();
		MultipartFile imageFile = restaurantRegisterForm.getImageFile();
		
		if(!imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();
			String hashedImageName = generateNewFileName(imageName);
			Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
			copyImageFile(imageFile,filePath);
			restaurant.setImageName(hashedImageName);
		}
		
		restaurant.setName(restaurantRegisterForm.getName());
		restaurant.setCategoryId(restaurantRegisterForm.getCategoryId());
		restaurant.setAddress(restaurantRegisterForm.getAddress());
		restaurant.setPhoneNumber(restaurantRegisterForm.getPhoneNumber());
		restaurant.setDescription(restaurantRegisterForm.getDescription());
		restaurant.setBudget(restaurantRegisterForm.getBudget());
		restaurant.setOpeningHours(restaurantRegisterForm.getOpeningHours());
		restaurant.setCapacity(restaurantRegisterForm.getCapacity());
		restaurant.setHoliday(restaurantRegisterForm.getHoliday());
		restaurantRepository.save(restaurant);
	}
	
	@Transactional
	public void update(RestaurantEditForm restaurantEditForm){
		Restaurant restaurant = restaurantRepository.getReferenceById(restaurantEditForm.getId());
		MultipartFile imageFile = restaurantEditForm.getImageFile();
		
		if(!imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();
			String hashedImageName = generateNewFileName(imageName);
			Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
			copyImageFile(imageFile,filePath);
			restaurant.setImageName(hashedImageName);
			
			restaurant.setName(restaurantEditForm.getName());
			restaurant.setAddress(restaurantEditForm.getAddress());
			restaurant.setPhoneNumber(restaurantEditForm.getPhoneNumber());
			restaurant.setDescription(restaurantEditForm.getDescription());
			restaurant.setBudget(restaurantEditForm.getBudget());
			restaurant.setOpeningHours(restaurantEditForm.getOpeningHours());
			restaurant.setCapacity(restaurantEditForm.getCapacity());
			restaurant.setHoliday(restaurantEditForm.getHoliday());
			restaurantRepository.save(restaurant);
		}
	}
	
	public String generateNewFileName(String fileName) {
		String[] fileNames = fileName.split("\\.");
		for (int i = 0; i < fileNames.length - 1; i++) {
			fileNames[i] = UUID.randomUUID().toString();            
			}
		String hashedFileName = String.join(".", fileNames);
		return hashedFileName;
		}
	public void copyImageFile(MultipartFile imageFile, Path filePath) {           
        try {
            Files.copy(imageFile.getInputStream(), filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }          
    } 
}
