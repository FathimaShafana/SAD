package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.RevenueRecognition;
public interface RevenueRecognitionJpaRepository extends JpaRepository<RevenueRecognition, Integer> {
 
}
