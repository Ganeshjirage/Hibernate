package com.hibernate.CRUD;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeRetrieve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		Query query = session.createQuery("from Employee");

		List<Employee> employee = query.list();
		for (Employee emp : employee) {
			System.out.println("Id - " + emp.getId());
			System.out.println("Id - " + emp.getName());
			System.out.println("Id - " + emp.getCity());
			System.out.println("Id - " + emp.getMobile());
			System.out.println();
		}

//		Employee emp = new Employee();

//		System.out.println(emp.getId());
//		System.out.println(emp.getName());
//		System.out.println(emp.getCity());
//		System.out.println(emp.getMobile());
//		emp.getId();
//		emp.getName();
//		emp.getCity();
//		emp.getMobile();

//		session.save(emp);
		t.commit();
		session.close();
		sessionFactory.close();
		System.out.println("Record retrieved successfully.");

	}

}
