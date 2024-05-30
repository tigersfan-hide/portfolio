package com.example.portfolio.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewForm {
	@NotNull(message = "レビュースコアを入力してください。")
	@Min(value = 1, message = "レビュースコアは1点以上に設定してください。")
	@Max(value = 5,message = "レビュースコアは5点以上に設定してください。")
	private Byte reviewScore;
	
	@NotBlank(message = "レビューを記入してください。")
	private String review;
}
