package com.kasim.mm.main;

import java.util.List;
import java.util.Map;

import org.apache.derby.jdbc.ClientDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MailManager {
	JdbcTemplate jdbc = null;

	private void setJDBCTemplate() {
		ClientDataSource ds = new org.apache.derby.jdbc.ClientDataSource();
		ds.setPortNumber(1527);
		ds.setServerName("localhost");
		ds.setUser("APP");
		ds.setPassword("secret");
		ds.setDatabaseName("main");
		jdbc = new JdbcTemplate(ds);
	}

	private void test() {
		List<Map<String, Object>> queryForList = jdbc.queryForList("select * from Users");
		for (Map<String, Object> map : queryForList) {
			System.out.println(map.values());
		}
	}

	public static void main(String[] args) {
		MailManager manager = new MailManager();
		manager.setJDBCTemplate();
		manager.test();
	}
}
