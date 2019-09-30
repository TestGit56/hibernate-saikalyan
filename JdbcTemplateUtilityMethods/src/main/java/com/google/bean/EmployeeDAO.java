package com.google.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate = null;

	public String getEmpNameById(Integer empId) {
		return jdbcTemplate.queryForObject("Select EMP_NAME From EMPLOYEE Where EMP_ID = ?", String.class, empId);
	}

	public EmployeeBean getById(Integer emp_Id) {
		Map<String, Object> map = jdbcTemplate
				.queryForMap("Select EMP_ID , EMP_NAME , EMP_SAL From EMployee where EMP_ID=?", emp_Id);

		return EmployeeBean.getEmpFromMap(map);

	}

	public List<EmployeeBean> getAll() {
		List<Map<String, Object>> mapList = jdbcTemplate
				.queryForList("Select EMP_ID , EMP_NAME, EMP_SAL From EMployee ");

		List<EmployeeBean> empList = new ArrayList<EmployeeBean>();

		for (Map<String, Object> map : mapList) {
			EmployeeBean emp = EmployeeBean.getEmpFromMap(map);
			empList.add(emp);
		}

		return empList;

	}
	public Float getMaxPrice()
	{
		return jdbcTemplate.queryForObject("Select Max(EMP_SAL) From EMployee ", Float.class);
	}

}
