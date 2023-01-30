package com.capgemini.go.service;

import com.capgemini.go.model.UserModel;

public interface UserService {
	
	public UserModel addUser(UserModel user);
	
	public UserModel loginUser(UserModel user);
	
	public UserModel logoutUser(UserModel user);
}
