package com.example.demo.Model;

public class Member implements Role {
	
	private String name;

	public Member() {
		super();
	}

	@Override
	public void setName(String name) {
		this.name=name;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getRole() {
		// TODO Auto-generated method stub
		return "Member";
	}

	@Override
	public void checkAccess() {
		System.out.println("Granted Access Level: MEMBER");
		
	}
}
