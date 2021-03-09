package com.example.mid.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.mid.dao.AddJPADao;
import com.example.mid.models.Address;
import com.example.mid.services.AddressService;
import com.example.mid.services.UserService;

@Controller
public class AddressController {
    @Autowired
    AddJPADao a;

    @Autowired
    UserService us;

    @Autowired
    AddressService as;

    @RequestMapping(path = "/address/{id}/deleteAddress", method= RequestMethod.DELETE)
    public String deleteAddress(@PathVariable("id") int id) {
    	Address add = a.getOne(id);
        a.delete(add);

        return "deleted";
    }

    @RequestMapping(path = "/addresses/update", method=RequestMethod.PUT)
    public String updateAddress(@PathVariable("id") int id) {
        Address add =a.getOne(id);
    	a.save(add);
        
        return "updated";
    }

    @RequestMapping(path = "address/{id}/editAddress")
    public ModelAndView editAddress(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("/address.jsp");
        Address address = a.getOne(id);
        mv.addObject("address", address);

        return mv;
    }

   
}