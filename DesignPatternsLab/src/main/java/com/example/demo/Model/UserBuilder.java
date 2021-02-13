package com.example.demo.Model;

//This is a builder class without uisng Lombok
public class UserBuilder {

	private int uid;
	private String name;
	private String nationality;
	private String email;
	
	public UserBuilder setUid(int uid) {
		this.uid=uid;
		return this;
	}
	
	public UserBuilder setName(String name) {
		this.name=name;
		return this;
	}
	
	public UserBuilder setNationality(String nationality) {
		this.nationality=nationality;
		return this;
	}
	
	public UserBuilder setEmail(String email) {
		this.email=email;
		return this;
	}
	
	public Users build() {
		return new Users(uid,name,nationality,email);
	}
}
