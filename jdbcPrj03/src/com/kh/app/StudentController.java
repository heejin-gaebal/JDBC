package com.kh.app;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentController {
	private Scanner sc = new Scanner(System.in);
	
	public void menu() throws Exception {
		System.out.println("메뉴 선택");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 학생 목록");
		
		System.out.println("번호를 입력해주세요");
		int num = Integer.parseInt(sc.nextLine());
		
		switch(num) {
		case 1 : insertStudent(); break; 
		case 2 : updateStudent(); break; 
		case 3 : deleteStudent(); break;
		case 4 : selectStudent(); break;
		default : System.out.println("잘못된 번호입니다.");
		}
	}
	
	public void insertStudent() throws Exception {
		System.out.println("---- insert ----");
		
		//driver : 오라클에 연동하기 위해 오라클드라이버 클래스파일을 지정
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//conn : 드라이버매니저로 getter 로 Connection 객체 가져와, 오라클에 연결 
		//	   | (JDBC URL, 계정, 비밀번호)정보를 Connection 변수에 담기
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "1234");
		
		//Statement : SQL구문을 넘길 상태공간을 만들어서 변수에 담기
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO STUDENT(NAME) VALUES('추성훈')");
		
		//Sql :  execute 는 boolean 타입이므로 executeUpdate라는 int 타입으로 변환 실행. 
		//    |  이를 result 변수에 담기. 실행결과를 이클립스에 구현하기위함
		int result = pstmt.executeUpdate();
		
		System.out.println("result : " + result);
	}
	
	public void updateStudent() throws Exception {
		System.out.println("---- update ----");
		
		//connection
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "1234");
		
		//pstmt
		PreparedStatement pstmt = conn.prepareStatement("UPDATE STUDENT SET NAME ='아조시' WHERE NAME ='추성훈'");
		
		//sql
		int result = pstmt.executeUpdate();
		
		System.out.println("result : " + result);
	}
	
	public void deleteStudent() throws Exception {
		System.out.println("---- delete ----");
		
		//connection
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "1234");
		
		//pstmt
		PreparedStatement pstmt = conn.prepareStatement("DELETE STUDENT WHERE NAME ='카리나'");
		
		//sql
		int result = pstmt.executeUpdate();
		
		System.out.println("result : " + result);
	}
	
	public void selectStudent() throws Exception {
		System.out.println("학생 목록");
		
		//connection
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "C##KH", "1234");
		
		//pstmt
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM STUDENT");
		
		//sql : SELECT의 결과테이블 ResultSet에 넣기
		ResultSet rs = pstmt.executeQuery();
		
//		while(true) {// 컬럼값을 반복해서 출력
//			boolean x = rs.next(); //커서를 한줄 아래 가리킴 return 값이 T/F 이므로 boolean 타입
//			if(!x) {
//				break;
//			}
//			String str = rs.getString("NAME"); //가져올 컬럼명을 문자열 변수에 저장 
//			System.out.println("result : " + str);
//		}
		while(rs.next()) {// 컬럼값을 반복해서 출력
			//rs.next() 가 T이면 반복 F이면 while 문 멈춤
			String str = rs.getString("NAME"); //가져올 컬럼명을 문자열 변수에 저장 
			System.out.println("result : " + str);
		}
	}
}
