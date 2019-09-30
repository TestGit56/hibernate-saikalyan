package com.google;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.bean.EmployeeDAO;

/**	
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
       ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
       
       EmployeeDAO dao  = container.getBean(EmployeeDAO.class);
     dao.batchProccessing();
     System.out.println("added Successfully");
    }
}
