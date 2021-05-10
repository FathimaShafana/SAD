package com.exam.sad;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.exam.sad.service.LockingService;


//For Pessimistic Locking
public class FinalExamApplication2 {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext applicationContext = 
				SpringApplication.run(FinalExamApplication2.class, args);
		LockingService ls = applicationContext.getBean(LockingService.class);
		
		//ps.createMockProduct();
		ls.writeLockTransaction();
		ls.readLockTransaction();
	}

}
