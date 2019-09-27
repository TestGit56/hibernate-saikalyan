package com.google;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.bean.DemoBean;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
       
       DemoBean bean = container.getBean(DemoBean.class);
       System.out.println(bean);
       
       
    }
}
