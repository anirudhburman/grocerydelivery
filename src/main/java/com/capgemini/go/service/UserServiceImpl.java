package com.capgemini.go.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.exception.user.UserNotFoundException;
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
	public UserModel loginUser(UserModel user) throws UserNotFoundException {
		return null;
	}

	@Override
	public UserModel logoutUser(Integer id) throws UserNotFoundException {
		return null;
	}

	@Override
	public List<UserModel> getAllUsers() {
		return (List<UserModel>) userDao.findAll();
	}

}
