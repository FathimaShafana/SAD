package com.exam.sad.service;

import com.exam.sad.model.Product;

public interface ProductService {
	 void save(Product product);
	 Product findById(int id);  
	 int calculateStock(Product product, int order);
}
