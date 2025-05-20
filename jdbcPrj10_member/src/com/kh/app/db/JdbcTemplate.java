package com.kh.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTemplate {

public static Connection getConn() throws Exception {
	String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user ="C##KH";
	String pwd ="1234";
	Connection conn = DriverManager.getConnection(url, user, pwd);
	conn.setAutoCommit(false);
	return conn;
}
}
