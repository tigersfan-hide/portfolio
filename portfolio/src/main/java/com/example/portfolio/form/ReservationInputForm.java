package com.example.portfolio.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReservationInputForm {
	@NotBlank(message = "日付を入力してください。")
	private String visitingTime;
	
	@NotNull(message = "来店人数を入力してください。")
	@Min(value = 1, message = "来店人数は1人以上に設定してください。")
	private Byte numberOfPeople;
}
