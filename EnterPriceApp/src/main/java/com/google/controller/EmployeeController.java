package com.google.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.service.EmployeeService;
@Controller
public class EmployeeController {
	
	private EmployeeService  empService = null;

	
	@Autowired
     public EmployeeController(EmployeeService empService) {
		super();
		this.empService = empService;
	}



	public void getInfo()
	{
		empService.getInfo();
		System.out.println("From Controller");
	}
	

}
