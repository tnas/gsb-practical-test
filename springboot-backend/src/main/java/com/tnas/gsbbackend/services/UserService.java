package com.tnas.gsbbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnas.gsbbackend.model.User;
import com.tnas.gsbbackend.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUsers() {
		return this.userRepo.findAll();
	}
	
	public void saveUser(User user) {
		this.userRepo.save(user);
	}
	
	public void deleteUsers() {
		this.userRepo.delete();
	}
}
