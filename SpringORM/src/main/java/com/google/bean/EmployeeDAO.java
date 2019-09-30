package com.google.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate = null;

	
	public EmployeeBean getById(Integer emp_Id)
	{
		return (EmployeeBean) hibernateTemplate.get(EmployeeBean.class, emp_Id);
	}
	
	public List<EmployeeBean> getAll() {
		return (List<EmployeeBean>) hibernateTemplate.find("Select emp From EmployeeBean as emp");
	}	
}
