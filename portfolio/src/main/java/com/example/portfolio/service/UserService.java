package com.example.portfolio.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.portfolio.entity.Role;
import com.example.portfolio.entity.User;
import com.example.portfolio.form.SignupForm;
import com.example.portfolio.form.UserEditForm;
import com.example.portfolio.repository.RoleRepository;
import com.example.portfolio.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Transactional
	public User create(SignupForm signupForm) {
		User user = new User();
		Role role = roleRepository.findByName("ROLE_FREE");
		
		user.setName(signupForm.getName());
		user.setFurigana(signupForm.getFurigana());
		user.setPhoneNumber(signupForm.getPhoneNumber());
		user.setEmail(signupForm.getEmail());
		user.setBirthday(signupForm.getBirthday());
		user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
		user.setOccupation(signupForm.getOccupation());
		user.setRole(role);
		user.setDeleteFlag((byte) 1);
		
		return userRepository.save(user);
	}
	
	@Transactional
	public void update(UserEditForm userEditForm) {
		User user = userRepository.getReferenceById(userEditForm.getId());
		
		user.setName(userEditForm.getName());
		user.setFurigana(userEditForm.getFurigana());
		user.setPhoneNumber(userEditForm.getPhoneNumber());
		user.setEmail(userEditForm.getEmail());
		user.setBirthday(userEditForm.getBirthday());
		user.setOccupation(userEditForm.getOccupation());
		
		userRepository.save(user);
	}
	
	 public boolean isEmailRegistered(String email) {
		 User user = userRepository.findByEmail(email);  
		 return user != null;
     }
	 
	 public boolean isSamePassword(String password, String passwordConfirmation) {
		 return password.equals(passwordConfirmation);
     }   
	 
	 public boolean isEmailChanged(UserEditForm userEditForm) {
	 	 User currentUser = userRepository.getReferenceById(userEditForm.getId());
	 	 return !userEditForm.getEmail().equals(currentUser.getEmail());
	 }
		 
}
