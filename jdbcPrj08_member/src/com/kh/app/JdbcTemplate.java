package com.kh.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTemplate {
	public static Connection getConn() throws Exception {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "C##KH";
		String pwd = "1234";
		Connection conn =  DriverManager.getConnection(url, user, pwd);

		conn.setAutoCommit(false); //자동커밋 비활성화
		
		return conn;
	}
}
