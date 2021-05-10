package com.exam.sad.service;

import java.time.LocalTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.exam.sad.model.Product;
import com.exam.sad.Dao.ProductDao;

@Service
public class LockingService {

	@Autowired
	ProductDao repo;
	
	/*public void createMockProduct() {
		// creating and persisting an product
		Product pro = new Product();
		pro.setName("Microsoft Word");
		pro.setPrice(499L);
		repo.save(pro);
	}
	*/
	
	
	@Transactional
	@Async
	public void readLockTransaction() throws InterruptedException {
			
		System.out.println(LocalTime.now() + " <-- Reading Product entity -->");

		Product product1 = null;
		try {
			product1 = repo.findProductForRead(1);
		} catch (Exception e) {
			System.err
					.println(LocalTime.now() + " -- Got exception while " + 
			"acquiring the read lock:\n " + e + " --");
			return;
		}

		System.out.println(LocalTime.now() + " -- Acquired the read lock --");

		System.out.println(LocalTime.now() + " -- Read product: " + product1 + " --");
		
		Thread.sleep(10000L);


	}

	@Transactional
	@Async
	public void writeLockTransaction() throws InterruptedException {
		
		Thread.sleep(100L);
		
		System.out.println(LocalTime.now() + " <-- Writing Product entity -->");

		Product product2 = null;
		try {
			product2 = repo.findProductForWrite(1);
		} catch (Exception e) {
			System.err
					.println(LocalTime.now() + " -- Got exception while " + 
			"acquiring the write lock:\n " + e + " --");
			return;
		}

		System.out.println(LocalTime.now() + " -- Acquired write lock --");
		product2.setName("New name");
		repo.save(product2);

		System.out.println(LocalTime.now() + " -- User 2 updated product: " + product2 
				+ " --");
	}
}
