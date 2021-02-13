//JUnit test
package com.example.demo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.Model.Singleton;
import com.example.demo.Model.SpringSingleton;

@SpringBootTest
class SingletonTest {

	@Autowired
	SpringSingleton springsingle1;
	
	@Autowired
	SpringSingleton springsingle2;
	
	@Test
	void contextLoads() {
		Singleton single1=Singleton.getInstance();
		Singleton single2=Singleton.getInstance();
		
		//Testing the traditional way
		Assertions.assertSame(single1,single2);
		
		//Testing in Spring way
		Assertions.assertSame(springsingle1,springsingle2);
		
	}
}
