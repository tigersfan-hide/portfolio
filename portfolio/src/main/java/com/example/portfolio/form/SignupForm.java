package com.example.portfolio.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignupForm {
	@NotBlank(message = "氏名を入力してください。")
	private String name;
	
	@NotBlank(message = "フリガナを入力してください。")
	private String furigana;
	
	@NotBlank(message = "電話番号を入力してください。")
	private String phoneNumber;
	
	@NotBlank(message = "メールアドレスを入力してください。")
	private String email;
	
	@NotNull(message = "生年月日を入力してください。")
	private Integer birthday;
	
	@NotBlank(message = "パスワードを入力してください。")
	@Length(min = 8, max = 25, message = "パスワードは8文字以上25文字以内で入力してください。")
	private String password;
	
//	@NotNull(message = "会員種類を選択してください。")
//	private Byte roleId;
	
	@NotNull(message = "職業を選択してください。")
	private Byte occupation;
	
	@NotBlank(message = "パスワード(確認用)を入力してください。")
	private String passwordConfirmation;
}
