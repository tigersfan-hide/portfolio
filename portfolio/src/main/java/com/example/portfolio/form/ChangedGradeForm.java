package com.example.portfolio.form;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangedGradeForm {
	
	@NotNull
	private Integer id;
	
	private String subscriptionId;
	
	private Timestamp changedGradeAt;
}
