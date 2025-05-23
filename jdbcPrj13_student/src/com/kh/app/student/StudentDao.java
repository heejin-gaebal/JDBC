package com.kh.app.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	
	public int insert(Connection conn, StudentVo vo) throws Exception {
		//쿼리 준비
		String sql = "INSERT INTO STUDENT(NO,NAME,SCORE,GENDER,ENROLL_DATE,DEL_YN) VALUES (SEQ_STU.NEXTVAL, ?, NULL, ?, SYSDATE, DEFAULT)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getGender());
		
		//쿼리 실행
		int result = pstmt.executeUpdate();
		//자원 반납
		pstmt.close();
		return result;
	}

	public StudentVo selectOne(Connection conn, String num) throws Exception {
		//쿼리 준비
		String sql = "SELECT * FROM STUDENT WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1, num);
		//쿼리 실행
		ResultSet rs = pstmt.executeQuery();
		
		StudentVo vo = null;
		
		if(rs.next()) {
			String no = rs.getString("NO");
			String name = rs.getString("NAME");
			String score = rs.getString("SCORE");
			String gender = rs.getString("GENDER");
			String enrollDate = rs.getString("ENROLL_DATE");
			String delYn = rs.getString("DEL_YN");
			
			vo = new StudentVo(no, name, score, gender, enrollDate, delYn);
		}
		
		//자원 반납
		pstmt.close();
		rs.close();
		
		return vo;
	}

	public static List<StudentVo> selectList(Connection conn) throws Exception {
		//쿼리 준비
		String sql = "SELECT * FROM STUDENT WHERE DEL_YN = 'N' ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//쿼리 실행
		ResultSet rs = pstmt.executeQuery();
	
		ArrayList<StudentVo> voList = null;
		while(rs.next()) {
			String name = rs.getString("NAME");
			String score = rs.getString("SCORE");
			String gender = rs.getString("GENDER");
			String enrollDate = rs.getString("ENROLL_DATE");
			String delYn = rs.getString("DEL_YN");
			
			StudentVo vo = new StudentVo(sql, name, score, gender, enrollDate, delYn);
			voList =  new ArrayList<StudentVo>();
			voList.add(vo);
		}
		
		//자원 반납
		pstmt.close();
		rs.close();
		return voList;
	}

}
