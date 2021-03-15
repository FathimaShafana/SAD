package com.example.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.hibernate.model.Address;
import com.example.hibernate.model.AddressId;
import com.example.hibernate.model.Benefit;
import com.example.hibernate.model.Employee;
import com.example.hibernate.model.Name;
import com.example.hibernate.model.User;
import com.example.hibernate.repo.EmployeeRepo;
import com.example.hibernate.service.TestService;

@SpringBootTest
class HibernateApplicationTests {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	EmployeeRepo eRepo;

	@Autowired
	private TestService ts;

	

	@Test
	@Transactional
	 void testCache() throws Exception {		
		System.out.println("----Not loaded, require query---");
	 	System.out.println("----Not loaded, require query---");
		ts.loadEntity(1);
	}

	@Test
	@Transactional
	 void testCascadeRemove() throws Exception {	
		int id = 1;
		Employee employee = em.find(Employee.class, id);
		List<Address> adds = employee.getAddresses();

		System.out.println("Employee loaded: " + employee.getName().getFname());
		em.remove(employee);

		Assertions.assertNull(em.find(Employee.class, id));

		// Addresses also null because cascade is remove
		for (Address a : adds) {
			Assertions.assertNull(em.find(Address.class, a.getId()));
		}
	}
	/*
	@Test
	@Transactional
	public void testCascadePersist(int id) {
		Employee employee = new Employee();
		Name name = new Name("Peter", "Shawn", "");
		employee.setName(name);
		employee.setAge(35);

		// add user
		User u = em.find(User.class, 3);
		employee.setUser(u);

		// add address
		Address add = new Address();
		AddressId addId = new AddressId();
		addId.setCity("Bangkok");
		addId.setHouseNo("33/9");
		addId.setStreetAddress("Fashion Island");
		addId.setZipcode("10304");
		add.setId(addId);
		add.setEmp(employee);
		List<Address> adds = new ArrayList<Address>();
		adds.add(add);
		employee.setAddresses(adds);

		// add benefits
		Set<Employee> employees = new HashSet<Employee>();
		employees.add(employee);
		Benefit benefit = new Benefit("Free Lunch", employees);
		Set<Benefit> benefits = new HashSet<Benefit>();
		benefits.add(benefit);
		employee.setBenefits(benefits);

		em.persist(employee); // this means that em will track all changes once trans finish

		//Assertions.assertAll
		Assertions.assertNull(em.find(User.class, id));
		}
	*/
	
	@Test
	void contextLoads() {
	}

}
