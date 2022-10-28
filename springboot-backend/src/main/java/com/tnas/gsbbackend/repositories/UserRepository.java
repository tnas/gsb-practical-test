package com.tnas.gsbbackend.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.tnas.gsbbackend.model.User;

@Repository
public class UserRepository {

	private List<User> inMemoryUsers;
	
	@PostConstruct
	public void init() {
		this.inMemoryUsers = new ArrayList<>();
	}
	
	public List<User> findAll() {
		return this.inMemoryUsers;
	}
	
	public void save(User user) {
		this.inMemoryUsers.add(user);
	}
	
	public void delete() {
		this.inMemoryUsers.clear();
	}
}
