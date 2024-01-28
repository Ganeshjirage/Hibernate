package com.hibernate.HibernateORM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Progrm started!");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionfactory = cfg.buildSessionFactory();

		Session session = sessionfactory.openSession();
		Transaction t = session.beginTransaction();
		System.out.println(sessionfactory);

		Student student = new Student();

		student.setFirstName("Rajani");
		student.setLastName("Jirage");
		

		session.save(student);
		t.commit();
		session.close();
		System.out.println("Record saved successfully.");
	}
}
