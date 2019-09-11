package com.google.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeDAO {
	SessionFactory sf = HBUtil.getSessionFactory();
	public void save(Employee employee) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		
		}
	public void delete(Integer empId)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		Employee emp = session.get(Employee.class,empId);
		if(emp!=null)
		session.delete(emp);
		session.getTransaction().commit();
		session.close();
		
	}
	}
