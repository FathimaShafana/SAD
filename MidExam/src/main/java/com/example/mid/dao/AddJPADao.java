package com.example.mid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.mid.models.Address;

@RepositoryRestResource(collectionResourceRel = "addresses", path = "addresses")
public interface AddJPADao extends JpaRepository<Address, Integer>{
    
}
