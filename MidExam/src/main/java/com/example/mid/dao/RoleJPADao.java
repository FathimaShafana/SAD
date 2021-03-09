package com.example.mid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mid.models.Role;

public interface RoleJPADao extends JpaRepository<Role, Integer>{
    
}

