package com.edubridge.springboot.springresthib.dao;

import java.util.List;

import com.edubridge.springboot.springresthib.entity.Product;
import com.edubridge.springboot.springresthib.entity.Seller;

public interface SellerDAO {

	List<Seller>findAll();
	 
	 public Seller findSellerById(int id);
	 
	 Seller addSeller(Seller slr);
	 
	 void deleteById(int id);	
	
}
