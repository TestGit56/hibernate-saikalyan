package com.google.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDAO {
	
	private SessionFactory sessionFactory = HBUtil.getSessionFactory();
	
	public ProductBean getByID(Integer productId)
	{
		ProductBean productBean = null;
		Session session = sessionFactory.openSession();
		productBean = session.get(ProductBean.class, productId);
		session.close();
		return productBean;
	}

}