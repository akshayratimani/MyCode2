package com.training.poc.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.training.poc.entity.Cart;
import com.training.poc.entity.Products;
import com.training.poc.entity.User;

@Service
public class ServiceDao {

	public List<User> getName(String ph) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		Query query = session.createQuery("from User u where u.phoneNo=:ph");
		query.setParameter("ph", ph);
		List<User> list = query.list();
		return list;
	}

	public int getSize(String phno) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from Cart c where c.phoneno=:ph");
		query.setParameter("ph", phno);
		int size = 0;
		List<Cart> list = query.list();

		//System.out.println("List.size" + list.size());

		for (Cart a : list) {
			//System.out.println("nodpa" + a.getQuantity());
			size = size + a.getQuantity();
		}
		//System.out.println("izeee:" + size);

		return size;
	}

	public List<Products> getCartProducts(String phno) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
		
		//select * from cart , PRODUCTS where id=pid AND phoneno = '9945664159';
		
		Query query = null ;
		try {
			query = session.createQuery("from Products p where Cart.phoneno=:ph");
			query.setParameter("ph", phno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Products> list = query.list();

		return list;
	}
}
