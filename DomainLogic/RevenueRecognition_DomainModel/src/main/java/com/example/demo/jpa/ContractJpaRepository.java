package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Contract;

public interface ContractJpaRepository extends JpaRepository<Contract, Integer> {

}
