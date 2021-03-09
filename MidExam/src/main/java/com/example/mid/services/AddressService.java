package com.example.mid.services;

import com.example.mid.models.Address;

public interface AddressService {
	
	    void updateAddress(Address address, String houseNo, String street, String city, String zipCode);
	}

