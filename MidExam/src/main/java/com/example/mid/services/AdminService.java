package com.example.mid.services;

import com.example.mid.models.Employee;
import com.example.mid.models.Level;

public interface AdminService {
  
	void adminUpdate(Employee emp, String name, Level level, String baseSalary);

	void adminUpdate(Employee emp, String name, String level, String baseSalary);

}