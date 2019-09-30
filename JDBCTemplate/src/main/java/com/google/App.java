package com.google;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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
    	EmployeeDAO dao = container.getBean(EmployeeDAO.class);
    	//System.out.println("GetAll From ResultSetExtractor "+dao.getResultSetExtractor());
    	//System.out.println("GetALL From ROWCALLBACKHANDLER "+dao.getAllRowCallBackHandler());
    	//System.out.println("GetAllFromRowMapper "+dao.getAllRowMapper());
    	System.out.println("GetALLFROMROWMAPPER2 "+dao.getAllRowMapper2(111));
    }
}
