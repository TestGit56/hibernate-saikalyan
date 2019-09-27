package com.datageeks.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "REGULAREMPLOYEETPS")
@PrimaryKeyJoinColumn(name = "EMP_FK_ID" )
public class RegularEmployee  extends Employee{
	
	@Column(name = "SALARY")
	private Float salary = null;
	
	@Column(name = "BONUS")
	private Float bonus = null;
	public RegularEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public RegularEmployee(Integer empId, String empName,Float salary, Float bonus) {
		setEmpId(empId);
		setEmpName(empName);
		this.salary = salary;
		this.bonus = bonus;
	}


	public Float getSalary() {
		return salary;
	}


	public void setSalary(Float salary) {
		this.salary = salary;
	}


	public Float getBonus() {
		return bonus;
	}


	public void setBonus(Float bonus) {
		this.bonus = bonus;
	}


	@Override
	public String toString() {
		return "RegularEmployee [salary=" + salary + ", bonus=" + bonus + ", getEmpId()=" + getEmpId()
				+ ", getEmpName()=" + getEmpName() + "]";
	}
	
	

}
