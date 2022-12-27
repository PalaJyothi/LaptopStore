package com.edubridge.springboot.springresthib.dao;

import java.util.List;

import com.edubridge.springboot.springresthib.entity.Product;

public interface ProductDAO {

	List<Product>findAll();
	 
	 public Product findProductById(int id);
	 
	 Product addProduct(Product ptd);
	 
	 void deleteById(int id);	
	
}
