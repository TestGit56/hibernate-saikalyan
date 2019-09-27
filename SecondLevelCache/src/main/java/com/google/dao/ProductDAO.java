package com.google.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductDAO {
	SessionFactory sf = HBUtil.getSessionFactory();
   
	public void firstLevelCacheOrSessionLevelCache()
	{
		Session session = sf.openSession();
		System.out.println("Request From Session1");
		ProductBean p1 = session.get(ProductBean.class , 111);
		System.out.println(p1);
		
		System.out.println("Request From Session1m secondTime");
		ProductBean p2 = session.get(ProductBean.class, 111);
		System.out.println(p2);
		
		
		System.out.println("Request From Session1 ThirdTime");
		ProductBean p3 = session.get(ProductBean.class,111);
		System.out.println(p3);
		session.close();
		
		
	}
	public void SecondLevelCacheOrSessionFactoryLevelCache()
	{
		Session session1 = sf.openSession();
		System.out.println("Request From Session1 firstTime");
		ProductBean p1 = session1.get(ProductBean.class,111);
		System.out.println(p1);
		
		System.out.println("Request From Session1 SecondTime");
		ProductBean p2  = session1.get(ProductBean.class, 111);
		System.out.println(p2);
		
		
		Session session2 = sf.openSession();
		System.out.println("Request From SesionFactoryLevel for FirstTime");
		ProductBean pb1  = session2.get(ProductBean.class, 111);
		System.out.println(pb1);
		  
		 System.out.println("Request From SessionLevelCache For SecondTime");
		 ProductBean pb2 = session2.get(ProductBean.class, 111);
		 System.out.println(pb2);

		 
		
		
		
		}
	
}
