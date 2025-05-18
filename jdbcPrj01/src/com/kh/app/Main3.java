package com.kh.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main3 {

	public static void main(String[] args) throws Exception {
		System.out.println("Main3");
		
		//driver 추가
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//connection
		String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user ="C##KH";
		String pwd ="1234";
		Connection conn = DriverManager.getConnection(url, user, pwd);
		
		//SQL : INSERT INTO STUDENT(NAME) VALUES('NN')
		String sql = "INSERT INTO STUDENT(NAME) VALUES('아이유')";
		Statement stmt =  conn.createStatement();
		stmt.execute(sql);
	}

}
