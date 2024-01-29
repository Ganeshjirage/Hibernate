package com.oneToMany.mapping;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		User user = new User();
		Policy policy1 = new Policy("G10", "CarInsurance", "Active", user);
		Policy policy2 = new Policy("M30", "BikeInsurance", "Active", user);

		Set<Policy> set = new HashSet<Policy>();
		set.add(policy1);
		set.add(policy2);

		user.setName("Ganesh");
		user.setEmail("Ganesh@email.com");
		user.setPolicy(set);

		session.save(user);
		session.save(policy1);
		session.save(policy2);

		t.commit();
		session.close();
		sessionFactory.close();
		System.out.println("Successfully Updated");
	}

}
