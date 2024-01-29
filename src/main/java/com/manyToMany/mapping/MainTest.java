package com.manyToMany.mapping;

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
//------------------------------------------------------Customer Details
		Customer2 cust1 = new Customer2();
		cust1.setName("Ganesh");
		cust1.setAddress("Pune");
		cust1.setMobile("9657972319");

		Customer2 cust2 = new Customer2();
		cust2.setName("Mininath");
		cust2.setAddress("Mumbai");
		cust2.setMobile("8805876490");

		Customer2 cust3 = new Customer2();
		cust3.setName("Bhagwan");
		cust3.setAddress("Baramati");
		cust3.setMobile("9730862891");

//------------------------------------------------------Shop Details

		Shop shop1 = new Shop();
		shop1.setName("Book Shop");
		shop1.setCity("Pune");
		shop1.setAddress("ABC");

		Shop shop2 = new Shop();
		shop2.setName("Computer Shop");
		shop2.setCity("Mumbai");
		shop2.setAddress("XYZ");

		Shop shop3 = new Shop();
		shop3.setName("Fertiliser Shop");
		shop3.setCity("Baramati");
		shop3.setAddress("MNO");

//----------------------------------------------------Adding the Shop details in Customer Object

		cust1.getShopList().add(shop1);
		cust1.getShopList().add(shop2);
		cust1.getShopList().add(shop3);

		cust2.getShopList().add(shop1);
		cust2.getShopList().add(shop2);
		cust2.getShopList().add(shop3);

		cust3.getShopList().add(shop1);
		cust3.getShopList().add(shop2);
		cust3.getShopList().add(shop3);

//----------------------------------------------------Adding the Customer details in Shop object

		shop1.getCoustomerList().add(cust1);
		shop1.getCoustomerList().add(cust2);
		shop1.getCoustomerList().add(cust3);

		shop2.getCoustomerList().add(cust1);
		shop2.getCoustomerList().add(cust2);
		shop2.getCoustomerList().add(cust3);

		shop3.getCoustomerList().add(cust1);
		shop3.getCoustomerList().add(cust2);
		shop3.getCoustomerList().add(cust3);

//---------------------------------------------------Saving the customer object in session

		session.persist(cust1);
		session.persist(cust2);
		session.persist(cust3);

//---------------------------------------------------Saving the shop object in session

//		session.persist(shop1);
//		session.persist(shop2);
//		session.persist(shop3);

		t.commit();
		session.close();
		sessionFactory.close();
		System.out.println("Record saved successfully.");

	}

}
