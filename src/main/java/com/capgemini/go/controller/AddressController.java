package com.capgemini.go.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.model.AddressModel;
import com.capgemini.go.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	AddressService addrSer;
	
	//http://localhost:8080/addaddress
	@PostMapping("/addaddress")
	public AddressModel addAddress(@RequestBody AddressModel address) {
		return addrSer.addAddress(address);
	}
	
	//http://localhost:8080/updateaddress
	@PostMapping("/updateaddress")
	public AddressModel updateAddress(@RequestBody AddressModel address) {
		return addrSer.updateAddress(address);
	}
	
	//http://localhost:8080/deleteaddressbyid{id}
	@GetMapping("/deleteaddress")
	public String deleteAddressById(@PathVariable("id") Integer addressId) {
		return addrSer.deleteAddressById(addressId);
	}
}
