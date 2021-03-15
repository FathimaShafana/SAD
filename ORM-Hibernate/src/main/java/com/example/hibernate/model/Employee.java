package com.example.hibernate.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "employee_info") // alternative table name 
@javax.persistence.Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "employee") 
public class Employee {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Name name; 

	@Column(name = "employee_age") 
	private int age;
	@Transient
	private String something_we_do_not_put_into_object;
	
	// When employee is removed, also remove addresses
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "emp")
	@JsonIgnore
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<Address> addresses;

	// Fetch type set to eager for experiment
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	//@ManyToMany(fetch = FetchType.EAGER)
	@JsonIgnore
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private Set<Benefit> benefits;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<Leave> leaves;

	

	// When you load employee, it will load user (for one-to-one)
	// by default
	 // use the same id as user, will called emp_user_id
	// @org.hibernate.annotations.Cache(usage =
	// CacheConcurrencyStrategy.READ_WRITE) //Provide cache strategy.
	@OneToOne(mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
	// (optional)this will create emp id in employee table
	private User user;

	

}
