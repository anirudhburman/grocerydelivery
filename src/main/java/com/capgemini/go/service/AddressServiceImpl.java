package com.capgemini.go.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.exception.address.AddressNotFoundException;
import com.capgemini.go.exception.customer.CustomerNotFoundException;
import com.capgemini.go.model.AddressModel;
import com.capgemini.go.model.CustomerModel;
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
	public AddressModel updateAddress(AddressModel address) throws AddressNotFoundException {
		if(addrDao.existsById(address.getAddressId())) {
			return addrDao.save(address);
		}
		throw new AddressNotFoundException();
	}

	@Override
	public String deleteAddressById(Integer addressId) throws AddressNotFoundException {
		if(addrDao.existsById(addressId)) {
			addrDao.deleteById(addressId);
			return "Address deleted successfully";
		}
		throw new AddressNotFoundException();
	}

	@Override
	public AddressModel getAddressById(Integer id) throws AddressNotFoundException {
		if(addrDao.existsById(id)) {
			return addrDao.findById(id).get();
		}
		throw new AddressNotFoundException();
	}

	@Override
	public CustomerModel getCustomerByAddressId(Integer id) throws CustomerNotFoundException {
		if(addrDao.existsById(id)) {
			return addrDao.findById(id).get().getCustomer();
		}
		throw new CustomerNotFoundException();
	}

}
