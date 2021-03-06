package com.google.bean;

import java.io.Serializable;
import java.util.Map;

public class EmployeeBean implements Serializable {
	
	
	private Integer emp_Id = null;
	private String emp_Name = null;
	private Float emp_Sal = null;
	public Integer getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(Integer emp_Id) {
		this.emp_Id = emp_Id;
	}
	public String getEmp_Name() {
		return emp_Name;
	}
	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}
	public Float getEmp_Sal() {
		return emp_Sal;
	}
	public void setEmp_Sal(Float emp_Sal) {
		this.emp_Sal = emp_Sal;
	}
	
	public EmployeeBean(Integer emp_Id, String emp_Name, Float emp_Sal) {
		super();
		this.emp_Id = emp_Id;
		this.emp_Name = emp_Name;
		this.emp_Sal = emp_Sal;
	}
	public EmployeeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static EmployeeBean getEmpFromMap(Map<String, Object> map) {
		
		EmployeeBean emp = null;
		if(map!=null)
		{
			Integer emp_Id = Integer.valueOf(map.get("EMP_ID").toString());
			String emp_Name = map.get("EMP_NAME").toString();
			Float emp_Sal = Float.valueOf(map.get("EMP_SAL").toString());
			emp = new EmployeeBean(emp_Id,emp_Name,emp_Sal);
		}
		
		return emp;
		
		
	}
	
	@Override
	public String toString() {
		return "EmployeeBean [emp_Id=" + emp_Id + ", emp_Name=" + emp_Name + ", emp_Sal=" + emp_Sal + "]";
	}
	

}
