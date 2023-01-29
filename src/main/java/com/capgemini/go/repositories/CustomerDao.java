package com.capgemini.go.repositories;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.go.model.CustomerModel;

public interface CustomerDao extends CrudRepository<CustomerModel, Integer>{

}