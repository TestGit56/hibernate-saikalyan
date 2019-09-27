package com.datageeks.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeDAO {
	
	SessionFactory sessionFactory = HBUtil.getSessionFactory();
	
	public void saveOrUpdate(Employee employee)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(employee);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public Employee getById(Integer empId)
	{
		
		return sessionFactory.openSession().get(Employee.class, empId);
	}
	
	
	public void delete(Integer empId)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee emp = session.get(Employee.class, empId);
			if(emp != null)
		session.delete(emp);
		session.getTransaction().commit();
		session.close();
	}

}
