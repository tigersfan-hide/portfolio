package com.example.portfolio.form;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WithdrawalForm {
	@NotNull
	private Integer id;
	
	@NotNull
	private Byte deleteFlag;
	
	private Timestamp updatedAt;
}
