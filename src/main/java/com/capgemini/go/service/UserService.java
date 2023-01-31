package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.exception.user.UserNotFoundException;
import com.capgemini.go.model.UserModel;

public interface UserService {
	
	public UserModel addUser(UserModel user);
	
	public UserModel loginUser(UserModel user) throws UserNotFoundException;
	
	public UserModel logoutUser(Integer id) throws UserNotFoundException ;
	
	public List<UserModel> getAllUsers();
}
