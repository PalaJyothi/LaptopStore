package com.edubridge.springboot.springresthib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.springboot.springresthib.dao.ProductDAO;
import com.edubridge.springboot.springresthib.dao.SellerDAO;
import com.edubridge.springboot.springresthib.entity.Seller;

@Service
public class SellerServiceImpl implements SellerService {

	private SellerDAO sellerDAO;
	
	@Autowired
	public SellerServiceImpl(SellerDAO sellerDAO)
	{
		this.sellerDAO = sellerDAO;
	}
	
	@Override
	public List<Seller> findAll() {
		return sellerDAO.findAll();
	}

	@Override
	public Seller findSellerById(int id) {
		return sellerDAO.findSellerById(id);
	}

	@Override
	public Seller addSeller(Seller slr) {
		return sellerDAO.addSeller(slr);
	}

	@Override
	public void deleteById(int id) {
		sellerDAO.deleteById(id);
		
	}

}
