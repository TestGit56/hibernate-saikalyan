package com.google.bean;

import org.springframework.stereotype.Component;

@Component
public class RegularEmployee implements EmployeeBean {
	
	public void getInfo()
	{
		System.out.println("From RegularEmployee");
	}

}
