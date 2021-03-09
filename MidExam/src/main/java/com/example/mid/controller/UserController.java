package com.example.mid.controller;

import java.security.Principal;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.mid.dao.EmpJPADao;
import com.example.mid.dao.UserJPADao;
import com.example.mid.models.Employee;
import com.example.mid.models.Role;
import com.example.mid.models.User;
import com.example.mid.services.UserService;
import com.example.mid.validation.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	UserJPADao usdao;
	
	@Autowired
	EmpJPADao emp;
	
	@Autowired
	private UserService us;
	
	@Autowired
	private UserValidator uv;
	
	@RequestMapping(path="/home")
	public ModelAndView userDashboard (Principal principal) {
		ModelAndView mv =  new ModelAndView("home.jsp");
		ModelAndView mv1 = new ModelAndView("admin.jsp");
		ModelAndView mv2 = new ModelAndView("user.jsp");
		User u = us.findByUsername(principal.getName());
		mv.addObject("user",u);
		
		for (Role role: u.getRoles()) {
			if(role.getName().equalsIgnoreCase("ROLE_ADMIN")) {
				return 	mv1;
			}
			if(role.getName().equalsIgnoreCase("ROLE_USER")) {
				return mv2;
			}
		}
		return mv;
		
	}
	
	@RequestMapping(path = "/register", method=RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("employee", new User());
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
	
	/*@RequestMapping(path = "/admin")
    public ModelAndView admin(Principal principal) {
        ModelAndView mv = new ModelAndView("admin.jsp");
        User user = us.findByUsername(principal.getName());
        mv.addObject("user", user);

        List<User> users = usdao.findAll();
        mv.addObject("users", users);

        for (User u: users) {
            Employee emp = u.getEmp();
          }
	}*/
	 @RequestMapping(path = "/employee/{id}/delete")
	    public String delete(@PathVariable("id") int id) {
	        Employee employee = emp.getOne(id);
	        emp.delete(employee);

	        return "/admin";
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
