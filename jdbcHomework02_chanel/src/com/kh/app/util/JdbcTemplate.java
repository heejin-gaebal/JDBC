package com.kh.app.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTemplate {
	public static Connection getConn() throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH_HOMEWORK", "1234");
		conn.setAutoCommit(false);
		return conn;
	}
}
