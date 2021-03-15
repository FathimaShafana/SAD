package com.example.hibernate.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.hibernate.model.Leave;

public interface LeaveDao extends CrudRepository<Leave,Integer>{

}
