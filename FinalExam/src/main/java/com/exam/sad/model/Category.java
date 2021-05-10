package com.exam.sad.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	public Category(String type, Set<Product> products) {
		super();
		this.type = type;
		this.products = products;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String type;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="categories")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Product> products;
}
