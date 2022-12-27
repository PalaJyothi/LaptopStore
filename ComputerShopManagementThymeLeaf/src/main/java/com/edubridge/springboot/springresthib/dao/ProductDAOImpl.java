package com.edubridge.springboot.springresthib.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edubridge.springboot.springresthib.entity.Employee;
import com.edubridge.springboot.springresthib.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public ProductDAOImpl (EntityManager entityManager) 
	{
	 this.entityManager=entityManager;	
	}

	@Transactional
	public List<Product> findAll() {
		//get the current session
		Session currentSession=entityManager.unwrap(Session.class);
		
		//create the query ,execute and get the result list
		List<Product>ptd=currentSession.createQuery("from Product",Product.class).getResultList();
		
		//result the result
		 System.out.println(ptd.toString());
		return ptd;
	}

	@Transactional
	public Product findProductById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Product ptd=session.get(Product.class,id);
		return ptd;
	}

	@Transactional
	public Product addProduct(Product ptd) {
		Session session=entityManager.unwrap(Session.class);	
		session.saveOrUpdate(ptd);
		return ptd;
	}

	@Transactional
	public void deleteById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Query query= session.createQuery("delete from Product where id= :productId");
		query.setParameter("productId", id);
		query.executeUpdate();
		
	}

}
