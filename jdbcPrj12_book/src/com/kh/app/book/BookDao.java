package com.kh.app.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.util.JdbcTemplate;

public class BookDao {

	public int insert(Connection conn, BookVo vo) throws Exception {
		
		//쿼리 준비
		String sql = "INSERT INTO BOOK(NO, TITLE, AUTHOR, PRICE) VALUES(SEQ_BOOK.NEXTVAL , ? , ? , ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getAuthor());
		pstmt.setString(3, vo.getPrice());
		//쿼리 실행
		int result = pstmt.executeUpdate();
		//자원 반납
		pstmt.close();
		return result;
	}

	public int update(Connection conn, BookVo vo) throws Exception {
		//쿼리 준비
		String sql ="UPDATE BOOK SET PRICE = ? WHERE NO = ?";
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPrice());
		pstmt.setString(2, vo.getNo());
		//쿼리 실행
		int result = pstmt.executeUpdate();
		//자원 반납
		pstmt.close();
		return result;
	}

	public int delete(Connection conn, String no) throws Exception {
		//쿼리 준비
		String sql = "UPDATE BOOK SET DEL_YN = 'Y' WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		//쿼리 실행
		int result = pstmt.executeUpdate();
		//자원 반납
		pstmt.close();
		return result;
	}

	public BookVo selectOne(Connection conn, String no) throws Exception {
		//쿼리 준비
		String sql = "SELECT * FROM BOOK WHERE NO = ? AND DEL_YN = 'N'";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		//쿼리 실행
		ResultSet rs = pstmt.executeQuery();
		
		BookVo vo = null;
		// rs -> vo
		if(rs.next()) {
//			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String author = rs.getString("AUTHOR");
			String price = rs.getString("PRICE");
			String publishedDate = rs.getString("PUBLISHED_DATE");
			String delYn = rs.getString("DEL_YN");
			
			//생성자 오버로딩
			vo = new BookVo(no, title, author, price, publishedDate, delYn);
		}
		
		//자원 반납
		pstmt.close();
		rs.close();
		return vo;
	}

	public List<BookVo> selectList(Connection conn) throws Exception {
		//쿼리 준비
		String sql = "SELECT * FROM BOOK WHERE DEL_YN = 'N' ORDER BY NO DESC";
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		//쿼리 실행
		ResultSet rs = pstmt.executeQuery();
		
		BookVo vo = null;
		List <BookVo> voList = new ArrayList <BookVo>();
		
		while(rs.next()) {
			String title = rs.getString("TITLE");
			String author = rs.getString("AUTHOR");
			String price = rs.getString("PRICE");
			String publishedDate = rs.getString("PUBLISHED_DATE");
			String delYn = rs.getString("DEL_YN");
			
			vo = new BookVo(sql, title, author, price, publishedDate, delYn);
			
			voList.add(vo);
		}
		
		//자원 반납
		pstmt.close();
		rs.close();
		
		return voList;
	}
}
