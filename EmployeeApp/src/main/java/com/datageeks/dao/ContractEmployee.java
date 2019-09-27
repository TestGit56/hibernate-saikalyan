package com.datageeks.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CONTRACTEMPLOYEETPS")
@PrimaryKeyJoinColumn(name = "EMP_FK_ID" )
public class ContractEmployee extends Employee {

	@Column(name = "CONTRACTPERIOD")
	private String contractPeriod = null;
	
	@Column(name = "PAYPERHOUR")
	private Float payPerHour = null;

	public ContractEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContractEmployee(Integer empId, String empName, String contractPeriod, Float payPerHour) {
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

	@Override
	public String toString() {
		return "ContractEmployee [contractPeriod=" + contractPeriod + ", payPerHour=" + payPerHour + ", getEmpId()="
				+ getEmpId() + ", getEmpName()=" + getEmpName() + "]";
	}


}
