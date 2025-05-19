package com.kh.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BoardController {
	private Scanner sc = new Scanner(System.in);
	//메뉴
	public void menu() throws Exception {
		System.out.println("메뉴보기");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 목록조회");
		System.out.println("3. 게시글 단건조회");
		
		System.out.println("번호 입력");
		int num = Integer.parseInt(sc.nextLine());
		
		switch(num) {
			case 1: insertBoard(); break;
			case 2: selectBoard(); break;
			case 3: selectBoardOne(); break;
			default : System.out.println("잘못눌렀습니다.");
		}
	}

	//게시글 작성
	public void insertBoard() throws Exception {
		//conn
		Connection conn = JdbcTemplate.getconn();		
		
		//input
		System.out.println("title : ");
		String title = sc.nextLine();
		System.out.println("content : ");
		String content = sc.nextLine();
		
		//pstmt
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO BOARD(NO, TITLE, CONTENT) VALUES(SEQ_BOARD.NEXTVAL, ?, ?)");
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		//sql
		int result = pstmt.executeUpdate();
		System.out.println("실행 결과 : " + result);
	}

	//게시글 목록 조회
	public void selectBoard() throws Exception {
		//DB연결 
		Connection conn = JdbcTemplate.getconn();
		
		// 쿼리문 준비
		String query = "SELECT * FROM BOARD";
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		// 쿼리문 실행
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int num = rs.getInt("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String date = rs.getString("CREATED_DATE");
			
			System.out.print(num);
			System.out.print(" | ");
			System.out.print(title);
			System.out.print(" | ");
			System.out.print(content);
			System.out.print(" | ");
			System.out.print(date);
			System.out.println("\n");
		}
		// 실행결과 확인
	}
	
	public void selectBoardOne() throws Exception {
		Connection conn = JdbcTemplate.getconn();
		
		System.out.println("조회할 게시글 번호 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		//쿼리문 준비
		String sql = "SELECT * FROM BOARD WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		
		//쿼리문 실행
		ResultSet rs = pstmt.executeQuery();
		
		//실행결과 확인
		if(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String createDate = rs.getString("CREATED_DATE");
			
			System.out.print(no);
			System.out.print(" | ");
			System.out.print(title);
			System.out.print(" | ");
			System.out.print(content);
			System.out.print(" | ");
			System.out.print(createDate);
			System.out.println();
		}
	}
}















