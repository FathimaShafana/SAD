package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.Model.User;

@RepositoryRestResource(collectionResourceRel = "users", path="users")
public interface UserJPADao extends JpaRepository <User, Integer> {

		User findByUsername(String username);
		
}