package com.example.demo.controller;

import java.security.Principal;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.service.UserService;
import com.example.demo.validation.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	private UserService us;
	
	@Autowired
	private UserValidator uv;
	
	@RequestMapping(path="/home")
	public ModelAndView userDashboard (Principal principal) {
		ModelAndView mv = new ModelAndView("home.jsp");
		User u = us.findByUsername(principal.getName());
		mv.addObject("user",u);
		
		for (Role role: u.getRoles()) {
			if(role.getName().equalsIgnoreCase("ROLE_ADMIN")) {
				
			}
			if(role.getName().equalsIgnoreCase("ROLE_USER")) {
				
			}
			if(role.getName().equalsIgnoreCase("ROLE_PREMIUM_USER")) {
	
			}
		}
		return mv;
		
	}
	
	@RequestMapping(path = "/register", method=RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register.jsp";
	}
	
	@RequestMapping(path = "/register", method=RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user, 
			BindingResult bindingResult) {
			uv.validate(user, bindingResult);
		
		if (bindingResult.hasErrors()) {
            return "register.jsp";
        }
		us.save(user);
		
		return "login.jsp";
		
	}
	
	@RequestMapping(path = "/login")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping(path = "/logout-success")
	public String logout() {
		return "logout.jsp";
	}
}
