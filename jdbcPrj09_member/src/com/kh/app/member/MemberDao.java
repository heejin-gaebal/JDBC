package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {

	//회원가입
	public int join(Connection conn, String id, String pwd) throws Exception {
		
		//쿼리 준비
		String sql = "INSERT INTO MEMBER(NO, ID, PWD) VALUES (SEQ_MEMBER.NEXTVAL, ?, ?)";
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		
		//쿼리 실행
		int result = pstmt.executeUpdate();
		
		//결과 리턴
		return result;
	}
	
	//회원탈퇴
	public int quit(Connection conn, String id, String pwd) throws Exception {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			//쿼리 준비
			String sql = "UPDATE MEMBER SET DEL_YN = 'Y' WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			//쿼리 실행
			result = pstmt.executeUpdate();
		}finally {
			pstmt.close();
		}
		//결과 리턴
		return result;
		
	}

	//로그인
	public String login(Connection conn, String id, String pwd) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String x = null;
		
		try {
			//쿼리 준비
			String sql ="SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			//쿼리 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //조회하는 값이 하나라도 있으면 ID 리턴
				x = rs.getString("ID");			
			}
		}finally {
			//자원 반납
			pstmt.close();
			rs.close();
		}
		return x;
	}
}
