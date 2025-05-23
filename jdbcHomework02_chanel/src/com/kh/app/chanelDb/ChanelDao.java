package com.kh.app.chanelDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChanelDao {

	public int insert(Connection conn, ChanelVo vo) throws Exception {
		//쿼리 준비
		String sql = "INSERT INTO CHANEL(NO,PRODUCT,PRICE,QUANTITY) VALUES(SEQ_CHANEL.NEXTVAL, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getProduct());
		pstmt.setString(2, vo.getPrice());
		pstmt.setInt(3, vo.getQuantity());
		//쿼리 실행
		int result = pstmt.executeUpdate();
		//자원 반납
		pstmt.close();
		return result;
	}

	public int update(Connection conn, ChanelVo vo) throws Exception {
		//쿼리 준비
		String sql = "UPDATE CHANEL SET PRODUCT = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getProduct());
		pstmt.setString(2, vo.getNo());
		//쿼리 실행
		int result = pstmt.executeUpdate();
		//자원 반납
		pstmt.close();
		return result;
	}

	public int delete(Connection conn, ChanelVo vo) throws Exception {
		//쿼리 준비
		String sql = "UPDATE CHANEL SET DEL_YN = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getDel_yn());
		pstmt.setString(2, vo.getNo());
		//쿼리 실행
		int result = pstmt.executeUpdate();
		//자원 반납
		pstmt.close();
		return result;
	}

	public ChanelVo selectOne(Connection conn, String no) throws Exception {
		String sql = "SELECT * FROM CHANEL WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			String no = rs.getString("NO");
			String no = rs.getString("PRODUCT");
			String no = rs.getString("PRICE");
			String no = rs.getString("QUANTITY");
			String no = rs.getString("CREATE_DATE");
			String no = rs.getString("DEL_YN");
		}
		return null;
	}


}
