package com.example.mid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mid.dao.AddJPADao;
import com.example.mid.models.Address;

@Service
	public class AddressServiceImpl implements AddressService{
	   
		
		@Autowired
	    private AddJPADao a;

	    @Override
	    public void updateAddress(Address address, String houseNo, String street, String city, String zipCode) {
	       
	        
	        if (!houseNo.isEmpty()) {
	            address.setHouseNo(houseNo);
	        }

	        if (!street.isEmpty()) {
	            address.setStreet(street);
	        }

	        if (!city.isEmpty()) {
	            address.setCity(city);
	        }

	        if (!city.isEmpty()) {
	            address.setZipcode(zipCode);
	        }
	        a.save(address);
	    }
	    
	}

