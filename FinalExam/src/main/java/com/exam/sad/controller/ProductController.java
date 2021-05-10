package com.exam.sad.controller;

import java.security.Principal;
import java.util.List;

import javax.money.MonetaryAmount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exam.sad.Dao.ProductDao;
import com.exam.sad.model.Product;
import com.exam.sad.service.ProductService;

@Controller
public class ProductController {
    @Autowired
    ProductService pService;
    
    @Autowired
    private ProductDao product;

    @PostMapping(path = "buy/{id}")
    public String updateStock(@PathVariable("id") int id,
                                        @RequestParam(name = "product") Product product1, 
                                        @RequestParam(name = "stock") int stock
                                             
    ) {
        
        Product product2 = product.getOne(id);
        
        pService.calculateStock(product1, stock);

        return "redirect:/buy";
    }
}

