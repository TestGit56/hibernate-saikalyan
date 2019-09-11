package com.google.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeDAO {
	SessionFactory Sf = HBUtil.getSessionFactory();
	public void save(Employee employee)
	{
		Session session = Sf.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}

}
