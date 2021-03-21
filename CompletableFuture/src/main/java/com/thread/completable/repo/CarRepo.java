package com.thread.completable.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thread.completable.model.Car;

@Repository
public interface CarRepo extends JpaRepository <Car, Long> {

	

}
