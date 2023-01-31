package com.capgemini.go.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.exception.address.AddressNotFoundException;
import com.capgemini.go.exception.customer.CustomerNotFoundException;
import com.capgemini.go.model.AddressModel;
import com.capgemini.go.model.CustomerModel;
import com.capgemini.go.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addrSer;

	// http://localhost:8080/addaddress
	@PostMapping("/addaddress")
	public AddressModel addAddress(@RequestBody AddressModel address) {
		return addrSer.addAddress(address);
	}

	// http://localhost:8080/updateaddress
	@PostMapping("/updateaddress")
	public AddressModel updateAddress(@RequestBody AddressModel address) throws AddressNotFoundException {
		return addrSer.updateAddress(address);
	}

	// http://localhost:8080/deleteaddress/{id}
	@GetMapping("/deleteaddress/{id}")
	public String deleteAddressById(@PathVariable("id") Integer addressId) throws AddressNotFoundException {
		return addrSer.deleteAddressById(addressId);
	}
	
	// http://localhost:8080/getaddress/{id}
	@GetMapping("/getaddress/{id}")
	public AddressModel getAddressById(@PathVariable("id") Integer id) throws AddressNotFoundException {
		return addrSer.getAddressById(id);
	}
	
	// http://localhost:8080/getcustomerbyaddressid/{id}
	public CustomerModel getCustomerByAddressId(@PathVariable("id") Integer id) throws CustomerNotFoundException {
		return addrSer.getCustomerByAddressId(id);
	}
}
