package com.edubridge.springboot.springresthib.service;

import java.util.List;

import com.edubridge.springboot.springresthib.entity.Employee;
import com.edubridge.springboot.springresthib.entity.Seller;

public interface SellerService {
	
	public List<Seller> findAll();
	public Seller findSellerById(int id);
	public Seller addSeller(Seller emp);
	public void deleteById(int id);

}
