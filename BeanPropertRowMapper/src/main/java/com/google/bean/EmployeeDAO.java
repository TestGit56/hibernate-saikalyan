package com.google.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate = null;

	public List<EmployeeBean> getAll() {
		BeanPropertyRowMapper<EmployeeBean> rowMapper = new BeanPropertyRowMapper<EmployeeBean>(EmployeeBean.class);

		return jdbcTemplate.query("Select EMP_ID,EMP_NAME,EMP_SAL From Employee", rowMapper);
	}
	
	
	public EmployeeBean getById(Integer emp_Id)
	{
		BeanPropertyRowMapper<EmployeeBean> rowMapper = new BeanPropertyRowMapper<EmployeeBean>(EmployeeBean.class);
		return jdbcTemplate.queryForObject("Select EMP_ID , EMP_NAME , EMP_SAL From EMployee where EMP_ID=?", rowMapper, emp_Id);
		
		
	}
	
}
	