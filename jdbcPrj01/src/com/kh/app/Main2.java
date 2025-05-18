package com.kh.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {

	public static void main(String[] args) throws Exception{
		
		System.out.println("====== JDBC ======");
		
		//oracle driver 드라이버 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//connection 
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "C##KH";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, user, pwd);
					  //오라클 접속 정보 getConnection(url, user, password);
		
		//SQL
		String sql = "INSERT INTO STUDENT(NAME) VALUES('홍길동')";
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		
	}

}
