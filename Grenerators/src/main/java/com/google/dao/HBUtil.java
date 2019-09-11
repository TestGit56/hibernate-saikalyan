package com.google.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HBUtil {
	private static final SessionFactory sf;
	static {
		synchronized (HBUtil.class) {
			Configuration cfg = new Configuration();
			cfg.configure("Oracle.cfg.xml");
			sf = cfg.buildSessionFactory();
		}
	}
	public static SessionFactory getSessionFactory()
	{
		return sf;
	}

}
