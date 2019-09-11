package com.google.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeDAO {
	SessionFactory sf = HBUtil.getSessionFactory();
	public void saveOrUpdate(Employee employee)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(employee);
		session.getTransaction().commit();
		session.close();
		
	}
	

}
