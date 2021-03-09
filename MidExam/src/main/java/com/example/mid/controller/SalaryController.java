package com.example.mid.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mid.dao.EmpJPADao;
import com.example.mid.models.Employee;

@Controller
public class SalaryController{

	@Autowired
	EmpJPADao emp2;
	
	@RequestMapping(path = "/salary")
	public ModelAndView calculateRevenueRecognition() {
		List<Employee> employee = emp2.findAll();
		
		System.out.println(employee.toString());
		
		Map<String, Object> allObjectsMap = new HashMap<String, Object>();
		allObjectsMap.put("employee", employee);
		
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(allObjectsMap);

		mv.setViewName("checksalary.jsp");
		return mv;
	}
	
}

