package com.example.portfolio.form;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RestaurantRegisterForm {
	@NotBlank(message = "店舗名を入力してください。")
	private String name;
	
	@NotBlank(message = "カテゴリーを選んでください。")
	private Byte categoryId;
	
	private MultipartFile imageFile;
	
	@NotBlank(message = "住所を入力してください。")
	private String address;
	
	@NotBlank(message = "電話番号を入力してください。")
	private String phoneNumber;
	
	@NotBlank(message = "説明を入力してください。")
	private String description;
	
	@NotNull(message = "予算を入力してください。")
	@Min(value = 1, message = "予算は1円以上に設定してください。")
	private String budget;
	
	@NotBlank(message = "営業時間を入力してください。")
	private String openingHours;
	
	@NotNull(message = "席数を入力してください。")
	@Min(value = 1, message = "席数は1人以上に設定してください。")
	private Byte capacity;
	
	@NotBlank(message = "定休日を入力してください。")
	private String holiday;
}
