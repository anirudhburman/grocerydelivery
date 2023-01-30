package com.capgemini.go.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.model.UserModel;
import com.capgemini.go.repositories.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Override
	public UserModel addUser(UserModel user) {
		return userDao.save(user);
	}

	@Override
	public UserModel loginUser(UserModel user) {
		return null;
	}

	@Override
	public UserModel logoutUser(UserModel user) {
		return null;
	}

}
