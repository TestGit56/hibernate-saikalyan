package com.google;

import java.util.Locale;



import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    
    	
    	
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        String msg = container.getMessage("msg", null, new Locale("en"));
        
        System.out.println("Message "+msg);
        
    }
}
