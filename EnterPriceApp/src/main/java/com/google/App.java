package com.google;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.controller.EmployeeController;

public class App {
	public static void main(String[] args)
	{
		ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EmployeeController controller = container.getBean(EmployeeController.class);
		controller.getInfo();
	}

}
