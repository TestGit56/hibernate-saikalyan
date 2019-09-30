package com.google;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.google.bean.EmployeeDAO;

/**	
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
  
       ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
       
       EmployeeDAO dao  = container.getBean(EmployeeDAO.class);
     System.out.println(dao.getAll());
     System.out.println(dao.getById(111));
}
}
