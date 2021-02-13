package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.Users;
import com.example.demo.Model.UserBuilder;

	@RestController
	@RequestMapping("/builder")
	public class BuilderController{
		
		//Without Lombok
		@GetMapping("user1")
		public String getUser1() {
			Users u = new UserBuilder()
					.setEmail("chaklam@ait.asia")
					.setNationality("Hong Kong")
					.setName("Chaky")
					.setUid(101)
					.build();
		System.out.println(u.toString());
		return "User Created";
		}
		
		//Using Lombok
		@GetMapping("userAuto")
		public String getUser2() {
			Users u = Users.builder()
					.email("auto@ait.asia")
					.name("Auto")
					.nationality("Taiwan")
					.uid(998)
					.build();
			System.out.println(u.toString());
			return "User Created using Lombok";
			
		}
	}

