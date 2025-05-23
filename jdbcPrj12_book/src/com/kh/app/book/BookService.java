package com.kh.app.book;

import java.sql.Connection;
import java.util.List;

import com.kh.app.util.JdbcTemplate;

public class BookService {

	BookDao bookDao = new BookDao();
	
	public int insert(BookVo vo) throws Exception {
		//비즈니스 로직
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		int result = bookDao.insert(conn,vo);
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

	public int update(BookVo vo) throws Exception {
		
		//비즈니스 로직
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		int result = bookDao.update(conn, vo);
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
		
		int result = bookDao.delete(conn, no);
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

	public BookVo selectOne(String no) throws Exception {
		//비즈니스 로직
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		BookVo vo = bookDao.selectOne(conn, no);
		//트랜잭션 처리
		//자원 반납
		conn.close();
		return vo;
	}

	public List<BookVo> selectList() throws Exception {
		//비즈니스 로직
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		List<BookVo> voList = bookDao.selectList(conn);
		//트랜잭션 처리
		//자원 반납
		conn.close();
		return voList;
	}
}
