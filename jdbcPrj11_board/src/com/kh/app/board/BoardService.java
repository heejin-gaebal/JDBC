package com.kh.app.board;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.app.util.JdbcTemplate;

public class BoardService {
	private  BoardDao boardDao = new BoardDao();
	
	public int insert(String title, String content) throws Exception {

		//비즈니스 로직
		
		//DB연결
		Connection conn = JdbcTemplate.getConn(); 
		//DAO 호출
		int result = boardDao.insert(conn, title, content);
		//트랜잭션 처리
		if(result == 1) {
			conn.commit();
		}else {
			conn.rollback();
		}
		
		//자원 반납
		conn.close();
		
		return result;
	}

	public int update(String no, String content) throws Exception {
		//비즈니스 로직
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		int result = boardDao.update(conn, no, content);
		//트랜잭션 처리
		if(result == 1) {
			conn.commit();
		}else {
			conn.rollback();
		}
		//자원 반납
		conn.close();
		return result;
	}

	public int delete(String no) throws Exception {
		//비즈니스 로직
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		int result = boardDao.delete(conn, no);
		//트랜잭션 처리
		if(result == 1) {
			conn.commit();
		}else {
			conn.rollback();
		}
		//자원 반납
		conn.close();
		return result;
	}

	public ArrayList<BoardVo> selectList() throws Exception {
		//비즈니스 로직
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		ArrayList<BoardVo> voList =  boardDao.selectList(conn);
		//트랜잭션 처리
		//자원 반납
		conn.close();
		
		return voList;
	}

	public BoardVo selectOne(String no) throws Exception {
		//비즈니스 로직
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		BoardVo vo = boardDao.selectOne(conn, no);
		//트랜잭션 처리
		//자원 반납
		conn.close();
		return vo;
	}

	
}
