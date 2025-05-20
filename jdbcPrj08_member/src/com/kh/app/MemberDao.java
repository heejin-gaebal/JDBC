package com.kh.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {

	//회원 가입
	public int join(Connection conn, String id, String pwd) throws Exception {
		
		//쿼리준비
		String sql = "INSERT INTO MEMBER(NO, ID, PWD) VALUES(SEQ_MEMBER.NEXTVAL, ?, ?)";
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		
		//쿼리실행
		int result = pstmt.executeUpdate();
		
		return result;
	}
	
	//로그인
	public boolean login(String id, String pwd) throws Exception {
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		
		//쿼리준비
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		
		//쿼리실행
		ResultSet rs = pstmt.executeQuery();
		
		return rs.next();
		//
	}
}
