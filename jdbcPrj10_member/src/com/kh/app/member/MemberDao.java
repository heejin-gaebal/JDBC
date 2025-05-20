package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {

	public int join(Connection conn, String id, String pwd) throws Exception {
		//쿼리 준비
		String sql ="INSERT INTO MEMBER(NO, ID, PWD) VALUES(SEQ_MEMBER.NEXTVAL, ?, ?)";
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		
		//쿼리 실행
		int result = pstmt.executeUpdate();
		
		//자원 반납
		pstmt.close();
		//conn.close(); - service.java에서 닫았으므로 불필요
		
		return result;
	}

	public String login(Connection conn, String id, String pwd) throws Exception {
		//쿼리 준비
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		
		//쿼리 실행
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		String x = rs.getString("ID");
		
		//자원 반납
		rs.close();
		pstmt.close();
		
		return x;
	}

}
