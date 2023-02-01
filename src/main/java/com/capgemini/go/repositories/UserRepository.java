package com.capgemini.go.repositories;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.go.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer>{

}
