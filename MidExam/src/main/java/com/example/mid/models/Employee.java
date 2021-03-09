package com.example.mid.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
//import javax.money.Monetary;
import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//import com.example.mid.converters.BigDecimalConverter;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class Employee {
	
	@Id
	private int id;
	private String name;
	
	@Column(name = "Level", nullable = false, insertable = false, updatable = false) 
	@Enumerated(EnumType.STRING)
	private Level level;
	
	//@Convert(converter = BigDecimalConverter.class)
	//private Monetary baseSalary;
	
	@Column(precision=10, scale=2, name="salary")
	private BigDecimal baseSalary;
	
	private LocalDate birthday;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@MapsId
	private User user;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Address> addresses;

	
	@Transient
	private MonetaryAmount baseSalary1;

    @Transient
	private MonetaryAmount netSalary;
	
    @PostLoad
	protected void onPostLoad() {
		this.baseSalary1 =	Monetary.getDefaultAmountFactory()
					.setNumber(this.baseSalary).setCurrency("USD").create();
	
    }
}
