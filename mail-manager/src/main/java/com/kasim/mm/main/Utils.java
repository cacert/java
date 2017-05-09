package com.kasim.mm.main;

import org.apache.derby.jdbc.ClientDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Utils {
	static JdbcTemplate jdbc = null;

	static  {
		ClientDataSource ds = new org.apache.derby.jdbc.ClientDataSource();
		ds.setPortNumber(1527);
		ds.setServerName("localhost");
		ds.setUser("APP");
		ds.setPassword("secret");
		ds.setDatabaseName("main");
		jdbc = new JdbcTemplate(ds);
	}
	
	static JdbcTemplate getJdbcTemplate(){
		return jdbc;
	}
}
