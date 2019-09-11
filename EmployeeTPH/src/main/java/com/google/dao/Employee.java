package com.google.dao;

import java.io.Serializable;

public class Employee  implements Serializable{
	private Integer empId = null;
	private String EmpName = null;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer empId, String empName) {
		super();
		this.empId = empId;
		EmpName = empName;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", EmpName=" + EmpName + "]";
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	
	

}
