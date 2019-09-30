package com.google.bean;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
	
	
	@Autowired
	@Qualifier("RegularEmployee")
	
	private EmployeeBean RegularEmployee = null;
	
	public void getInfo()
	{
		RegularEmployee.getInfo();
	}
	

}
