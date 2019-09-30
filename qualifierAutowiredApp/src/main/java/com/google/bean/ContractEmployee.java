package com.google.bean;

import org.springframework.stereotype.Component;

@Component
public class ContractEmployee implements EmployeeBean {
	
	
public void getInfo()
{
	System.out.println("From ContractEmployee");
}
	
	


}
