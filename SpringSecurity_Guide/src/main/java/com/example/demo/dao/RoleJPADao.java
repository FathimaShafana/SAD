package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.example.demo.Model.Role;

public interface RoleJPADao extends JpaRepository<Role, Integer> {
	
}