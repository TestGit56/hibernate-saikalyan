package com.google.bean;

public class EmployeeDAO {

	private EmployeeBean ContractEmployee = null;

	public void setContractEmployee(EmployeeBean contractEmployee) {
		ContractEmployee = contractEmployee;
	}
	
	public void getInfo()
	{
		System.out.println("From dao");
	}

}
