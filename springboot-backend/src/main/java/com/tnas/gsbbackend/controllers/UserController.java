package com.tnas.gsbbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tnas.gsbbackend.model.User;
import com.tnas.gsbbackend.services.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
    
	@GetMapping("${api.users}")
    public List<User> getUsers() {
        return this.userService.getAllUsers();
    }
	
	@PostMapping("${api.users}")
    public void addUser(@RequestBody User user) {
        this.userService.saveUser(user);
    }
}
