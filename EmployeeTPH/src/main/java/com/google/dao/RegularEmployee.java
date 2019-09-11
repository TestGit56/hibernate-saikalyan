package com.google.dao;

public class RegularEmployee extends Employee {
	private Float salary;
	private Float bonus;
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
	
	
	

}
