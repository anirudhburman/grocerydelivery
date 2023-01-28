package com.capgemini.go.dao;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.go.model.UserModel;

public interface UserDao extends CrudRepository<UserModel, Integer>{

}
