package com.hibernate.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeUpdate {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

//		Employee emp = new Employee();

		Employee employee = session.get(Employee.class, 1);

		employee.setName("Ramesh");
		session.update(employee);

		t.commit();

		session.close();
		sessionFactory.close();
		System.out.println("Record updated successfully.");

	}

}
