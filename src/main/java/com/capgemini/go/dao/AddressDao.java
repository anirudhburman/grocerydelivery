package com.capgemini.go.dao;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.go.model.AddressModel;

public interface AddressDao extends CrudRepository<AddressModel, Integer>{

}
