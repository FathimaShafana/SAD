package com.example.mid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.mid.models.Employee;


@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface EmpJPADao extends JpaRepository<Employee, Integer>{
       Employee findByID (int id);
}