package com.google.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.dao.EmployeeDAO;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeDAO empDAO = null;

	public void setEmpDAO(EmployeeDAO empDAO) {
		this.empDAO = empDAO;
	}
	
	public void getInfo()
	{
		empDAO.getInfo();
		System.out.println("From EmloyeeServiceMethod");
	}
	

}
