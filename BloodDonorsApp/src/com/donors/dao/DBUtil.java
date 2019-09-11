package com.donors.dao;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	
	private static BasicDataSource dataSource = null;
	
		static
		{
			synchronized (DBUtil.class) {
				
				dataSource = new BasicDataSource();
				dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
				dataSource.setUsername("system");
				dataSource.setPassword("tiger");
				dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
				
			}
		}

		public static DataSource getDataSource()
		{
			return dataSource;
		}
}
