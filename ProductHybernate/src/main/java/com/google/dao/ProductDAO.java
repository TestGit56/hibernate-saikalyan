package com.google.dao;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDAO {

	public ProductBean getByID(Integer productId) {

		ProductBean productBean = null;
		Configuration cfg = new Configuration();
		cfg.configure("Oracle.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		productBean = session.get(ProductBean.class, productId);
      session.close();
		sf.close();
		return productBean;
	}

}