package com.example.demo.Controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.money.MonetaryAmount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Helpers.DollarHelper;
import com.example.demo.script.RevenueRecognitionScript;

@Controller
public class ScriptController {

	@Autowired
	RevenueRecognitionScript script;	//Contains all Business Logic
	
	@Autowired
	DollarHelper dollarHelper;

	@RequestMapping(path = "/addContract", method = RequestMethod.GET)
	//Use LocalDate to replace the old Date which uses Java 8 API
	public String addContract(@RequestParam int pid, @RequestParam int price, 
			@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateSigned ) {

		//convert to monetary
		MonetaryAmount priceConverted = dollarHelper.dollars(price);
		
		//create contract
		int contractId = script.insertContractInfo(pid, priceConverted, dateSigned);
	
		//insert revenue recognitions based on type
		script.calculateRevenueRecognition(contractId);
		
		return "redirect:/check";
	}
	
	@RequestMapping(path = "/checkRecognizedRevenue", method = RequestMethod.GET)
	@ResponseBody
	//Use LocalDate to replace the old Date which uses Java 8 API
	public ModelAndView checkRecognizedRevenue(@RequestParam int cid, 
			@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate asOf ) {

		//Check recognized revenue
		MonetaryAmount recognizedRevenue = script.recognizedRevenue(cid, asOf);
		BigDecimal revenue = recognizedRevenue.getNumber().numberValue(BigDecimal.class)
		.setScale(recognizedRevenue.getCurrency().getDefaultFractionDigits());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("revenue", revenue);
		map.put("date", asOf);
		ModelAndView mv = new ModelAndView("showrr.jsp", "data", map);
		
		return mv;


	}
	
}
