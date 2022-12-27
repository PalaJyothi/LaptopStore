package com.edubridge.springboot.springresthib.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edubridge.springboot.springresthib.entity.Product;
import com.edubridge.springboot.springresthib.entity.Seller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class SellerDAOImpl implements SellerDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public SellerDAOImpl (EntityManager entityManager) 
	{
	 this.entityManager=entityManager;	
	}

	@Transactional
	public List<Seller> findAll() {
		Session currentSession=entityManager.unwrap(Session.class);
		
		//create the query ,execute and get the result list
		List<Seller>slr=currentSession.createQuery("from Seller",Seller.class).getResultList();
		
		//result the result
		 System.out.println(slr.toString());
		return slr;
	}

	@Transactional
	public Seller findSellerById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Seller slr=session.get(Seller.class,id);
		return slr;
	}

	@Override
	public Seller addSeller(Seller slr) {
		Session session=entityManager.unwrap(Session.class);	
		session.saveOrUpdate(slr);
		return slr;
	}

	@Override
	public void deleteById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Query query= session.createQuery("delete from Seller where id= :sellerId");
		query.setParameter("sellerId", id);
		query.executeUpdate();
		
	}

}
