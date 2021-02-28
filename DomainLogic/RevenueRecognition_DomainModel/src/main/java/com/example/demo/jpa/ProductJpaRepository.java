package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Product;

public interface ProductJpaRepository extends JpaRepository <Product, Integer>{

}
