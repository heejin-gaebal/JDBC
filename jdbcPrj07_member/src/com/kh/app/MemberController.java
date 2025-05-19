package com.kh.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MemberController {
	private Scanner sc = new Scanner(System.in);
	
	public void menu() throws Exception {
		System.out.println("멤버 메뉴");
		System.out.println("1. 회원 가입");
		System.out.println("2. 회원정보 수정");
		System.out.println("3. 회원 탈퇴");
		System.out.println("4. 전체 회원목록 조회 - 관리자");
		System.out.println("5. 로그인");
		
		int num = Integer.parseInt(sc.nextLine());
		
		switch(num) {
		case 1 : join(); break;
		case 2 : edit(); break;
		case 3 : quit(); break;
		case 4 : selectMemeberList(); break;
		case 5 : login(); break;
		default : System.out.println("잘못 누르셨습니다.");
		}
	}
	
	public void join() throws Exception {
		System.out.println("회원 가입");
		
		//디비연결
		Connection conn = JdbcTemplate.getconn();
		
		System.out.println("id : ");
		String id = sc.nextLine();
		System.out.println("pwd : ");
		String pwd = sc.nextLine();
		
		//쿼리준비
		String sql = "INSERT INTO MEMBER(NO, ID, PWD) VALUES(SEQ_MEMBER.NEXTVAL,?,?)";
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		
		//쿼리실행
		int result = pstmt.executeUpdate();
		
		//결과확인
		if(result == 1) {
			System.out.println("회원가입 성공><");
		}else {
			System.out.println("회원가입 실패ㅜㅠ");
		}
	}
	
	public void edit() throws Exception {
		System.out.println("회원 수정");
		
		//DB실행
		Connection conn = JdbcTemplate.getconn();
		//쿼리준비
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		System.out.println("기존비밀번호 : ");
		String oldPwd = sc.nextLine();
		System.out.println("새 비밀번호 : ");
		String newPwd = sc.nextLine();
		
		String sql = "UPDATE MEMBER SET PWD = ? WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1, newPwd);
		pstmt.setString(2, id);
		pstmt.setString(3, oldPwd);
		
		//쿼리실행
		int result = pstmt.executeUpdate();
		
		//결과확인
		if(result == 1) {
			System.out.println("비밀번호 변경 성공");
		}else {
			System.out.println("비밀번호 변경 실패");
		}
	}
	
	public void quit() throws Exception {
		System.out.println("회원 탈퇴");
		//디비연결
		Connection conn = JdbcTemplate.getconn();
		
		System.out.println("id : ");
		String id = sc.nextLine();
		System.out.println("pwd : ");
		String pwd = sc.nextLine();
		
		// 아이디 패스워드를 입력하고 탈퇴여부를 'Y'로 수정
		String sql = "UPDATE MEMBER SET DEL_YN ='Y' WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		
		//쿼리실행
		int result = pstmt.executeUpdate();
		//결과확인
		if(result == 1) {
			System.out.println("탈퇴 성공");
		}else {
			System.out.println("탈퇴 실패");
		}
	}
	
	public void selectMemeberList() throws Exception {
		System.out.println("전체 회원목록");
		//디비 연결
		Connection conn = JdbcTemplate.getconn();
		
		//쿼리 준비
		String sql = "SELECT * FROM MEMBER";
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		
		//쿼리 실행
		ResultSet rs = pstmt.executeQuery();
		//결과 확인
		while(rs.next()) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String joinDate = rs.getString("JOIN_DATE");
			String delYn = rs.getString("DEL_YN");
			
			System.out.print(no);
			System.out.print(" | ");
			System.out.print(id);
			System.out.print(" | ");
			System.out.print(pwd);
			System.out.print(" | ");
			System.out.print(joinDate);
			System.out.print(" | ");
			System.out.print(delYn);
			System.out.println("\n");
		}
	}
	
	public void login() throws Exception {
		System.out.println("회원 조회");
		//DB연결
		Connection conn = JdbcTemplate.getconn();
		
		System.out.println("id : ");
		String id = sc.nextLine();
		System.out.println("pwd : ");
		String pwd = sc.nextLine();
		
		// 아이디 패스워드가 일치하고 탈퇴여부가 N
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		
		//쿼리실행
		ResultSet rs = pstmt.executeQuery();
		
		//결과확인
		if(rs.next()) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
	}
	
}
