package com.google.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HBUtil {
	private static final SessionFactory Sf;
	static {
		synchronized (HBUtil.class) {
			Configuration cfg =  new Configuration();
			cfg.configure("Oracle.cfg.xml");
			Sf=cfg.buildSessionFactory();
			}
	}
	
public static SessionFactory getSessionFactory()
{
	return Sf;
	
}
}
