package com.example.demo.Model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	//mappedby tells JPA that it is already mapped, otherwise, you
	//will get duplicate tables
	@ManyToMany(mappedBy="roles")
	private Set <User> users;
	
	
	
}
