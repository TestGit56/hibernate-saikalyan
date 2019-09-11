package com.google.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductDAO {
	SessionFactory sf = HBUtil.getSessionFactory();
	public void save(ProductBean product)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		Integer id =(Integer)session.save(product);
		
		session.getTransaction().commit();
		session.close();
		System.out.println(product);
	}
	public void persist(ProductBean product)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(product);
		session.getTransaction().commit();
		session.close();
		System.out.println(product);
		
		System.out.println(" With persist() record insertion is successfull");
	}
	public void get(Integer productId)
	{
		Session session = sf.openSession();
		ProductBean productBean = session.get(ProductBean.class, productId);
		System.out.println("From get method");
		System.out.println(productBean);
		session.close();
	}
	public void load(Integer productId)
	{
		Session session = sf.openSession();
		ProductBean productBean = session.get(ProductBean.class, productId);
		System.out.println("From load method");
		System.out.println("ProductINfo    "+productBean.getProductName());
		System.out.println(productBean);
		session.close();
		
		
	}
	public void saveOrUpdate(ProductBean product)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
		
	System.out.println("From Save OR update");
	System.out.println(product);
		session.close();
		
		
	}

}
