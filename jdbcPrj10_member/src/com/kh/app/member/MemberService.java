package com.kh.app.member;

import java.sql.Connection;

import com.kh.app.db.JdbcTemplate;

public class MemberService {
	private MemberDao memberDao = new MemberDao();
	
	//회원가입
	public int join(String id, String pwd) throws Exception {
		//비즈니스 로직 - 제한없는 프로젝트
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		int result = memberDao.join(conn, id, pwd);
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

	public String login(String id, String pwd) throws Exception {
		//비즈니스 로직 - 제한없는 프로젝트
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		String x = memberDao.login(conn, id, pwd);
		
		//트랜잭션 처리 - select 쿼리 트랜잭션처리 불필요
		//자원 반납
		conn.close();
		return x;
	}

}
