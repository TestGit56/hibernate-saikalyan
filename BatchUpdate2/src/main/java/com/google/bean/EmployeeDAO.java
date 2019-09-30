	package com.google.bean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate = null;

	public void batchProccessing() throws Exception
	{
		BufferedReader br = new BufferedReader(new  FileReader("empdata.csv"));
		List<String> list = new ArrayList<String>(); 
		String sql;
		while((sql = br.readLine())!=null)
		{
			list.add(sql);
		}
		String[] strArr = new String[list.size()];
		for(int index = 0 ; index < strArr.length ;index++)
		{
			strArr[index] = list.get(index);
		}
		jdbcTemplate.batchUpdate(strArr);
		
	}
	
}
	