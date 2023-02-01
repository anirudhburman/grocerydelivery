package com.capgemini.go.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.exception.UserNotFoundException;
import com.capgemini.go.model.UserModel;
import com.capgemini.go.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userSer;
	
	//http://localhost:8080/adduser
	@PostMapping("/adduser")
	public UserModel addUser(@RequestBody UserModel user) {
		return userSer.addUser(user);
	}
	
	//http://localhost:8080/loginuser
	@PostMapping("/loginuser")
	public UserModel loginUser(@RequestBody UserModel user) throws UserNotFoundException {
		return userSer.loginUser(user);
	}
	
	//http://localhost:8080/logoutuser
	@PostMapping("/logoutuser/{id}")
	public UserModel logoutUser(@PathVariable("id") Integer id) throws UserNotFoundException {
		return userSer.logoutUser(id);
	}
	
	@GetMapping("/getallusers")
	public List<UserModel> getAllUsers() {
		return userSer.getAllUsers();
	}
}
