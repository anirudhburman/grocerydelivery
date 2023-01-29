package com.capgemini.go.service;

import com.capgemini.go.model.AddressModel;

public interface AddressService {
	
	public AddressModel addAddress(AddressModel address);
	
	public AddressModel updateAddress(AddressModel address);
	
	public String deleteAddressById(Integer addressId);
}
