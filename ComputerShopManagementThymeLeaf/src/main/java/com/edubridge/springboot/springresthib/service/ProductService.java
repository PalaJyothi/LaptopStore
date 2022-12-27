package com.edubridge.springboot.springresthib.service;

import java.util.List;


import com.edubridge.springboot.springresthib.entity.Product;

public interface ProductService {
	
	public List<Product> findAll();
	public Product findProductById(int id);
	public Product addProduct(Product ptd);
	public void deleteById(int id);

}
