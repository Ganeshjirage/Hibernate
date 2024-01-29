package com.oneToOne.mapping;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainTest {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		Customer customer = new Customer();
		customer.setFirstName("Ganesh");
		customer.setMobileNumber("9657972319");

		Transection transection = new Transection();
		transection.setDate(new Date());
		transection.setTotal(5000);

		customer.setTransaction(transection);

		session.save(customer);
		t.commit();
		session.close();
		sessionFactory.close();

		System.out.println("Data insertion successfully completed");

	}

}
