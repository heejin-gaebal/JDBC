package jdbcPrj02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) throws Exception {
		System.out.println("JDBC - DB연결 연습");
		
		//conn
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "C##KH";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, user, pwd);
		
		//input
		System.out.println("학생 이름 : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		//sql
		String sql = "INSERT INTO STUDENT(NAME) VALUES(?)"; // 컬럼값이 바뀌는 컬럼은 ?로 표현
		PreparedStatement pstmt = conn.prepareStatement(sql); // 실행하고싶은 sql 구문을 담는 Statement 공간을 만들어줌
		pstmt.setString(1, str); //1번째 ?에 값을 넣어준다
		int result = pstmt.executeUpdate(); 
		//execute는 boolean타입이므로 int형으로 나오게 타입변환 : 실행결과를 이클립스에 구현하기 위함
		System.out.println("실행결과 : " + result);
	}

}
