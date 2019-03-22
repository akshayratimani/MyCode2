package com.training.poc.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.training.poc.entity.Products;

@Service
public class ShowProductsService {
	
	public List<Products> getProducts() {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		
		Query query = session.createQuery("from Products");
		
		List<Products> list = query.list();
		
		System.out.println("Size:"+list.size());
		
		return list;
		
		
	}

	
}
