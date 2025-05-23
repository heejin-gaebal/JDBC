package com.kh.app.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {

	public int insert(Connection conn, String title, String content) throws Exception {
		//쿼리 준비
		String sql = "INSERT INTO BOARD(NO, TITLE, CONTENT) VALUES(SEQ_BOARD.NEXTVAL, ?, ?)";
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		
		//쿼리 실행
		int result = pstmt.executeUpdate();
		
		//자원 반납
		pstmt.close();
		
		return result;
	}

	public int update(Connection conn, String no, String content) throws Exception {
		//쿼리 준비
		String sql ="UPDATE BOARD SET CONTENT = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, content);
		pstmt.setString(2, no);
		//쿼리 실행
		int result = pstmt.executeUpdate();
		//자원 반납
		pstmt.close();
		
		return result;
	}
	
	public int delete(Connection conn, String no) throws Exception {
		//쿼리 준비
		String sql ="UPDATE BOARD SET DEL_YN = 'Y' WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		//쿼리 실행
		int result = pstmt.executeUpdate();
		
		//자원 반납
		pstmt.close();
		return result;
	}

	public ArrayList<BoardVo> selectList(Connection conn) throws Exception {
		//쿼리 준비
		String sql = "SELECT * FROM BOARD ORDER BY NO DESC";
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		//쿼리 실행
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<BoardVo> voList = new ArrayList<BoardVo>();
		//가져온 컬럼을 배열리스트로 만들기
		
		while(rs.next()) {
			//모든 컬럼 가져오기
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String createDate = rs.getString("CREATED_DATE");
			String delYn = rs.getString("DEL_YN");

			//모든 컬럼을 하나로 뭉치기위해 vo 객체만들기
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setCreatedDate(createDate);
			vo.setDelYn(delYn);
			
			voList.add(vo);
		}
		
		//자원 반납
		rs.close();
		pstmt.close();
		
		return voList;
	}

	public BoardVo selectOne(Connection conn, String no) throws Exception {
		//쿼리 준비
		String sql = "SELECT * FROM BOARD WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		//쿼리 실행
		ResultSet rs = pstmt.executeQuery();
		
		BoardVo vo = null;
		if(rs.next()) {
//			String no = rs.getString("NO"); 파라미터에서 값이 넘어오므로 생략
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String createDate = rs.getString("CREATED_DATE");
			String delYn = rs.getString("DEL_YN");
			
			vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setCreatedDate(createDate);
			vo.setDelYn(delYn);
		}
		//자원 반납
		pstmt.close();
		rs.close();
		
		return vo;
	}
	
	
}
