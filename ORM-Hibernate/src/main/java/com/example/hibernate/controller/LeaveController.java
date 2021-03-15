package com.example.hibernate.controller;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

//import com.example.hibernate.model.Leave;
import com.example.hibernate.repo.LeaveDao;
//import com.example.hibernate.model.Employee;
import com.example.hibernate.repo.LeaveRepo;



@RestController
@RequestMapping(path = "/leave")
public class LeaveController {

	@Autowired
	LeaveDao dao;
	
	@Autowired
	LeaveRepo leave;
	
	/*
	@GetMapping("/leave")
	public String leave() {
		return "leave.jsp";
	}
	*/
	
	@RequestMapping(path = "/leave", method=RequestMethod.GET)
	public String leave() {
		//dao.save(leave);
		return "leave.jsp";

	}
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String home() {
		//dao.save(leave);
		return "home.jsp";
	}
	
	@RequestMapping(path="/approve", method=RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute(leave);
		return "approve.jsp";
		
	}
	/*
	@RequestMapping(path = "/leave")
	public ModelAndView leave() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("leave.jsp");
		return mv;
	}
	*/
	
	
}
