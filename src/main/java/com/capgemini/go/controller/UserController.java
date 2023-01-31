package com.capgemini.go.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public UserModel loginUser(@RequestBody UserModel user) {
		return userSer.loginUser(user);
	}
	
	//http://localhost:8080/logoutuser
	@PostMapping("/logoutuser")
	public UserModel logoutUser(@RequestBody UserModel user) {
		return userSer.logoutUser(user);
	}
}
