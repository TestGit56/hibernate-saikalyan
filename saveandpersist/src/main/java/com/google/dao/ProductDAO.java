package com.google.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDAO {
	
	private SessionFactory sessionFactory = HBUtil.getSessionFactory();
	
	public void sessionLevelCache()
	{
		Session session = sessionFactory.openSession();
		System.out.println("\n\n*** Request First Time ");
		ProductBean productBean1 = session.get(ProductBean.class, 111);
		System.out.println(productBean1);
		
		System.out.println("\n\n*** Request 2nd Time ");
		ProductBean productBean2 = session.get(ProductBean.class, 111);
		System.out.println(productBean2);
		
		System.out.println( "\n\n productBean1 hashcode "+productBean1.hashCode());
		System.out.println( " productBean2 hashcode "+productBean2.hashCode());
		
		session.close();
	}
	
	public void sessionLevelCache2()
	{
		Session session = sessionFactory.openSession();
		System.out.println("\n\n*** Request First Time ");
		ProductBean productBean1 = session.get(ProductBean.class, 111);
		System.out.println(productBean1);
		
		System.out.println("\n\n*** Request 2nd Time ");
		ProductBean productBean2 = session.get(ProductBean.class, 111);
		System.out.println(productBean2);
		
		System.out.println( "\n\n productBean1 hashcode "+productBean1.hashCode());
		System.out.println( " productBean2 hashcode "+productBean2.hashCode());
		
		Session session2 = sessionFactory.openSession();
		System.out.println("\n\n*** Request First Time from Session2 ");
		ProductBean productBean3 = session2.get(ProductBean.class, 111);
		System.out.println(productBean3);
		System.out.println( " productBean3 hashcode "+productBean3.hashCode());
		
		
		
		
		
	}

}