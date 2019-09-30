package com.google.bean;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

	@Autowired
	private SessionFactory sf = null;
	
	/*public EmployeeBean getById(Integer emp_Id)
	{
		Session session = sf.openSession();
		EmployeeBean emp = session.get(EmployeeBean.class, emp_Id);
		
		return emp ;
		
	}*/
	
	public EmployeeBean getById2(Integer emp_Id)
	{
		return sf.openSession().get(EmployeeBean.class, emp_Id);
				}
	public void delete(Integer  emp_Id)
	{
		Session session = sf.openSession();
		EmployeeBean emp = session.get(EmployeeBean.class, emp_Id);
		if(emp!=null)
		{
			session.beginTransaction();
			session.delete(emp);
			session.getTransaction().commit();
		}
		session.close();
	}
	
	public void saveOrupdate(EmployeeBean emp)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(emp);
		session.getTransaction().commit();
	}
	public List<EmployeeBean> getAll()
	{
		return sf.openSession().createQuery("Select emp From EmployeeBean as emp").getResultList();
		
	}
	/*public  EmployeeBean  getMaxPrice()
	{
		EmployeeBean emp;
		Session session = sf.openSession();
	TypedQuery<Float> query = session.createQuery("Select  max(p.emp_Sal) From EmployeeBean as p", Float.class);
   emp  = query.();
   return emp;

	}*/
	
}
