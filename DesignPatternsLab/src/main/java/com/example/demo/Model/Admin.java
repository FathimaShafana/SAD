package com.example.demo.Model;

public class Admin implements Role {
private String name;

public Admin() {
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
	return "Admin";
}

@Override
public void checkAccess() {
	System.out.println("Granted Access Level: ADMIN");
	
}

}
