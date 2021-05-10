package com.exam.sad.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//Optimistic Locking
	@Version
	private long version;
	
    private String name;

    private Company company;

    @Column(name="type")
    private Category category;

  //  @Enumerated
   // private Category category;
    @Column(precision=10, scale=2)
    private BigDecimal price;
    
    private int stock;
    
    @Transient
   	private MonetaryAmount price_;
	
    @ManyToOne(fetch = FetchType.LAZY)
	private Company comp;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Category> categories;
    
    @PostLoad
   	protected void onPostLoad() {
   		this.price_ =
   				Monetary.getDefaultAmountFactory()
   					.setNumber(this.price)
   					.setCurrency("USD")
  					.create();
}

   
}