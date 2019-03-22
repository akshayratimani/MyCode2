package com.training.poc.service;


import java.util.ArrayList; 
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.training.poc.entity.User;

@Service
public class LoginService {

	public boolean validateUser(String phno, String pass) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		
		Query query = session.createQuery("from User");
		List list = query.list();
		//System.out.println("list:"+list);
		User u;
		for(int i = 0; i < list.size(); i++) {
			
			u = (User) list.get(i);
			System.out.println("Data\n"+u);
			
			if(u.getPhoneNumber().equals(phno)&&u.getPassword().equals(pass)) {
				return true;
			}
		}
		
		t.commit();
		session.close();
		
		return false;
	}
}
