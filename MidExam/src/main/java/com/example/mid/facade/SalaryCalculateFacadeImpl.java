package com.example.mid.facade;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mid.dao.EmpJPADao;
import com.example.mid.models.Employee;
import com.example.mid.models.Level;
import com.example.mid.models.Level.Values;
import com.example.mid.salary.ClassOneService;

@Service
public class SalaryCalculateFacadeImpl implements SalaryCalculateFacade{

	private EmpJPADao emp;

	@Autowired 
	public SalaryCalculateFacadeImpl(EmpJPADao emp) {
		this.emp=emp;
	};
	
	@Override
	public String calculateSalary(Employee id, BigDecimal salary) {
		
		return "Salary Calculated";
	}

	@Override
	public int insertSalaryDetails(String name, Level level) {
		Employee emp1= new Employee();
					
		ClassOneService c1=new ClassOneService();
		System.out.println("Salary of "+ emp1 + "is equal to" + c1.calculateSalary(emp1, emp1.getBaseSalary()));
		return 1;
	}
	
}
