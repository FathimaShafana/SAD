package com.exam.sad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exam.sad.Dao.ProductDao;
import com.exam.sad.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao product;
	
	@Override
	public void save(Product product) {
		//product.save(product);
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public int calculateStock(Product product, int order) {
		int available_stock = product.getStock();
		int current_stock = available_stock-order;
		
		return current_stock;
	}

}
