	package com.google.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate = null;

	public void getInfo()
	{
		 String stm1 = "Insert into EMPLOYEE(EMP_ID , EMP_NAME , EMP_SAL) values(444,'kalyan',20000f)";
		 String stm2 = "Insert into EMPLOYEE(EMP_ID , EMP_NAME , EMP_SAL) values(555,'siri',30000f)";
		 String stm3 = "Insert into EMPLOYEE(EMP_ID , EMP_NAME , EMP_SAL) values(666,'konda',40000f)" ;
		 String stm4 = "Insert into EMPLOYEE(EMP_ID , EMP_NAME , EMP_SAL) values(777,'kalyan2',50000f)" ;
		 String stm5 ="update Employee Set EMP_NAME ='srinu' where EMP_ID = 111 ";
		 jdbcTemplate.batchUpdate(stm1,stm2,stm3,stm4,stm5);
	}
	
}
	