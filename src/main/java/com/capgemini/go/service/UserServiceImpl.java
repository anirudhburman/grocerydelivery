package com.capgemini.go.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.dto.LoginRequestDto;
import com.capgemini.go.exception.UserNotFoundException;
import com.capgemini.go.model.UserModel;
import com.capgemini.go.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserModel addUser(UserModel user) {
		user.setUserType("Customer");
		return userRepo.save(user);
	}

	@Override
	public UserModel loginUser(LoginRequestDto user) throws UserNotFoundException {
		Optional<UserModel> foundUser = userRepo.findByUserName(user.getUserName());
		if(foundUser.isPresent()) {
			if((foundUser.get().getUserPassword().equals(user.getPassword())) && (foundUser.get().getUserType().equals("Customer"))) {
				return foundUser.get();
			} else {
				throw new UserNotFoundException("Password");
			}
		} else {
			throw new UserNotFoundException("User");
		}
	}

	@Override
	public UserModel logoutUser(Integer id) throws UserNotFoundException {
		return null;
	}

	@Override
	public List<UserModel> getAllUsers() {
		return (List<UserModel>) userRepo.findAll();
	}

}
