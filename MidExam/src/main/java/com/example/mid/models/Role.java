package com.example.mid.models;

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
	// @EqualsAndHashCode(exclude = "users")
	@Table(name = "role")
	public class Role {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String name;

	    @ManyToMany(mappedBy = "roles")
	    private Set<User> users;
	}

