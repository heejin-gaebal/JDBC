package jdbcPrj02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("====== JDBC 연습 ======");
		
		//driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//conn
		String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user ="C##KH";
		String pwd ="1234";
		Connection conn = DriverManager.getConnection(url, user, pwd);
		
		//sql
		String sql = "INSERT INTO STUDENT (NAME) VALUES('냔냥이')";
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
	}

}
