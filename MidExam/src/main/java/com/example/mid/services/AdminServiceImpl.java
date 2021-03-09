package com.example.mid.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mid.dao.EmpJPADao;
import com.example.mid.models.Employee;
import com.example.mid.models.Level;

@Service
public class AdminServiceImpl implements AdminService{
    
	@Autowired
    private EmpJPADao emp1;

    @Override
	public void adminUpdate(Employee employee, String name, String level, String baseSalary) {
        if (!name.isEmpty()) {
            employee.setName(name);
        }

        if (!level.isEmpty()) {
            employee.setLevel(Level.valueOf(level));
        }

        if (!baseSalary.isEmpty()) {
            employee.setBaseSalary(new BigDecimal(baseSalary));
        }
        emp1.save(employee);
        
    }

	@Override
	public void adminUpdate(Employee employee, String name, Level level, String baseSalary) {
		// TODO Auto-generated method stub
		
	}
    
}