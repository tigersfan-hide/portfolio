package com.example.portfolio.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "furigana")
	private String furigana;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "birthday")
	private Integer birthday;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "occupation")
	private Byte occupation;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	@Column(name = "subscription_id")
	private String subscriptionId;
	
	@Column(name = "delete_flag")
	private Byte deleteFlag;
	
	@Column(name = "created_at", insertable = false, updatable = false)
	private Timestamp createdAt;

	@Column(name = "updated_at", insertable = false, updatable = false)
	private Timestamp updatedAt;
	
	@Column(name = "changed_grade_at", insertable = false, updatable = false)
	private Timestamp changedGradeAt;
}
