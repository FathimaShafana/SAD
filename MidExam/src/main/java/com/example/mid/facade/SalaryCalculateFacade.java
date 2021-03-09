package com.example.mid.facade;

import java.math.BigDecimal;
import com.example.mid.models.Employee;
import com.example.mid.models.Level;



public interface SalaryCalculateFacade {
	String calculateSalary(Employee id, BigDecimal salary);
	
	int insertSalaryDetails(
			String name, Level level);

}
