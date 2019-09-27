package com.datageeks.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEETPS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee implements Serializable{
	
	@Id
	@Column(name = "EMPID")
	
	private Integer empId = null;
	
	@Column(name = "EMPNAME")
	private String empName = null;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(Integer empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}


	public Integer getEmpId() {
		return empId;
	}


	public void setEmpId(Integer empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}
	
	

}
