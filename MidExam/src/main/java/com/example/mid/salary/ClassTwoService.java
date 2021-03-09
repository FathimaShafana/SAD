package com.example.mid.salary;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.mid.models.Employee;
import com.example.mid.services.SalaryService;

@Service
public class ClassTwoService implements SalaryService{

	private final BigDecimal amount = new BigDecimal(500);
	
	@Override
	public void save(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String calculateSalary(Employee id, BigDecimal salary) {
		Employee emp = new Employee();
		salary=emp.getBaseSalary();
		BigDecimal netSalary=salary.add(amount);
		
		return "ClassTwoService [Net Salary=" + netSalary + "]";
	}

	

}