package com.training.poc.service;

import java.util.List; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.training.poc.entity.Products;

@Service
public class ProductDetailsService {

	public List<Products> getProductById(int id) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		Query query = session.createQuery("from Products p where p.id=:id");
		query.setParameter("id", id);
		

		List<Products> list = query.list();

		//System.out.println("HI:" + list.size());

		return list;
		
	}
}
