package com.edubridge.springboot.springresthib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edubridge.springboot.springresthib.dao.EmployeeDAO;
import com.edubridge.springboot.springresthib.dao.ProductDAO;
import com.edubridge.springboot.springresthib.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductDAO productDAO;
	
	@Autowired
	public ProductServiceImpl(ProductDAO productDAO)
	{
		this.productDAO = productDAO;
	}

	@Transactional
	public List<Product> findAll() {
		return productDAO.findAll();
	}

	@Transactional
	public Product findProductById(int id) {
		return productDAO.findProductById(id);
	}

	@Transactional
	public Product addProduct(Product ptd) {
		return productDAO.addProduct(ptd);
	}

	@Transactional
	public void deleteById(int id) {
		productDAO.deleteById(id);
		
	}

}
