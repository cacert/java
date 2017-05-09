package com.kasim.mm.main;

import java.util.List;
import java.util.Map;

import org.apache.derby.jdbc.ClientDataSource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class MailManagerTest {
	static JdbcTemplate jdbc = null;

	@BeforeClass
	public static  void setJDBCTemplate() {
		ClientDataSource ds = new org.apache.derby.jdbc.ClientDataSource();
		ds.setPortNumber(1527);
		ds.setServerName("localhost");
		ds.setUser("APP");
		ds.setPassword("secret");
		ds.setDatabaseName("main");
		jdbc = new JdbcTemplate(ds);
	}

	@Test
	public  void test() {
		List<Map<String, Object>> queryForList = jdbc.queryForList("select * from Persons");
		for (Map<String, Object> map : queryForList) {
			System.out.println(map.values());
		}
	}

}
