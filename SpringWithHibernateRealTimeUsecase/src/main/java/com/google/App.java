package com.google;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.google.bean.EmployeeBean;
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
       EmployeeBean emp = new EmployeeBean(111,"shanvi",1234f);
       EmployeeDAO dao  = container.getBean(EmployeeDAO.class);
     System.out.println("GETALL   "+dao.getAll()+"\n\n");
     
    System.out.println("GetBYID2   "+dao.getById2(111)+"\n\n");
 dao.saveOrupdate(emp);
    dao.delete(222);
   
    
}
}
