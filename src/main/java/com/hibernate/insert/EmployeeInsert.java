package com.hibernate.insert;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeInsert {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		Employee emp = new Employee();

		emp.setName("Ram");
		emp.setCity("Nagpur");
		emp.setMobile("9730862891");

		session.save(emp);
		t.commit();
		session.close();

		System.out.println("Record saved successfully.");

	}

}
