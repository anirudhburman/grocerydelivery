package com.capgemini.go.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.model.AddressModel;
import com.capgemini.go.repositories.AddressDao;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressDao addrDao;

	@Override
	public AddressModel addAddress(AddressModel address) {
		
		return addrDao.save(address);
	}

	@Override
	public AddressModel updateAddress(AddressModel address) {
		return null;
	}

	@Override
	public AddressModel deleteAddress(AddressModel address) {
		return null;
	}

}
