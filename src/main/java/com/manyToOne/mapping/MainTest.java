package com.manyToOne.mapping;

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

		Address address = new Address();
		address.setCity("Pune");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPinCode("411038");

		Employee emp1 = new Employee();
		emp1.setName("Ganesh");
		emp1.setEmail("Ganesh@gmail.com");
		emp1.setAddress(address);

		Employee emp2 = new Employee();
		emp2.setName("Ganesh");
		emp2.setEmail("Ganesh@gmail.com");
		emp2.setAddress(address);

		session.save(emp1);
		session.save(emp2);
		session.save(address);

		t.commit();
		session.close();
		sessionFactory.close();
		System.out.println("Successfully updated");

	}

}
