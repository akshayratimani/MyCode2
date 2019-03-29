package com.training.poc.service;

import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Service;
import com.training.poc.entity.User;

@Service
public class SignUpService {
	
	public boolean registerUser(User u) {
		
	
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		System.out.println("firstline");
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		
		org.hibernate.Transaction t = session.beginTransaction();
		
		
		try {
			session.save(u);
			t.commit();
		} catch (Exception e) {
			//System.out.println("Exception:"+e);
			return false;
		}
		
		//System.out.println("Successfully saved");
		
		factory.close();
		session.close();

		//System.out.println(u);
		
		return true;
	}

}
