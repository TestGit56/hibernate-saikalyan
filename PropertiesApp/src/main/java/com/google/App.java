package com.google;

import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.bean.SampleBEan;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        SampleBEan bean = container.getBean(SampleBEan.class);
        
     System.out.println(bean);
        
    }
}
