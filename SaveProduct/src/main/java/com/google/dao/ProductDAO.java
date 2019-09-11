package com.google.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductDAO {
	SessionFactory sf = HBUtil.getSessionFactory();
	public void save(ProductBean product)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		Integer id = (Integer)session.save(product);
		session.getTransaction().commit();
		session.close();
		System.out.println(id +"output as productID");
		
	}
	public void persist(ProductBean product)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();
	}

}
