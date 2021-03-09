package com.example.mid.services;

import java.math.BigDecimal;

import com.example.mid.models.Employee;

public interface SalaryService {
	 void save(Employee emp);
	 String calculateSalary(Employee id, BigDecimal salary);
}
