package com.google.dao;

public class ContractEmployee extends Employee {
private String contractPeriod=null;
private Float payPerHour=null;
public ContractEmployee() {
	super();
	// TODO Auto-generated constructor stub
}
public ContractEmployee(Integer empId, String empName,String contractPeriod, Float payPerHour) {
	setEmpId(empId);
	setEmpName(empName);
	this.contractPeriod = contractPeriod;
	this.payPerHour = payPerHour;
}
public String getContractPeriod() {
	return contractPeriod;
}
public void setContractPeriod(String contractPeriod) {
	this.contractPeriod = contractPeriod;
}
public Float getPayPerHour() {
	return payPerHour;
}
public void setPayPerHour(Float payPerHour) {
	this.payPerHour = payPerHour;
}

}
