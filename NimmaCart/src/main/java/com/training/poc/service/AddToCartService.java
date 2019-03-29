package com.training.poc.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.training.poc.entity.Cart;

@Service
public class AddToCartService {

	public void add(Cart c) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		Query query = session.createQuery("from Cart c where c.pid=:id AND c.phoneno=:phno");
		query.setParameter("id", c.getPid());
		query.setParameter("phno", c.getPhoneno());

		List<Cart> list = query.list();

		// System.out.println("ABCD1:"+list.size());

		if (list.size() != 0) {

			int q;
			Cart c1 = list.get(0);
			q = 1 + c1.getQuantity();
			//System.out.println("Q"+q);
			Query query1 = session.createQuery("update Cart c set c.quantity =:q where c.pid=:id AND c.phoneno=:phno");
			query1.setParameter("q", q);
			query1.setParameter("id", c.getPid());
			query1.setParameter("phno", c.getPhoneno());
			
			int result=query1.executeUpdate();

		} else {
			session.save(c);
		}

		t.commit();

		session.close();
		factory.close();

	}

}
