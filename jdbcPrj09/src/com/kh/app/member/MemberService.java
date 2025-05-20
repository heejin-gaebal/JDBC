package com.kh.app.member;

import java.sql.Connection;

import com.kh.app.db.JdbcTemplate;

public class MemberService {
	//DAO 호출
	MemberDao mDao = new MemberDao();
	
	//회원가입
	public int join(String id, String pwd) throws Exception {
		//비즈니스 로직
		if(id.length() < 4 || pwd.length() < 4) {
			throw new Exception("길이가 짧습니다."); 
			// 조건문에 안맞을 시 예외 던지기 : 예외던지면서 메시지넣기
		}
		//디비 연결
		Connection conn =  JdbcTemplate.getConn();
		
		int result = mDao.join(conn, id, pwd);
		//트랜잭션 처리
		if(result == 1) {
			conn.commit();
		}else {
			conn.rollback();
		}
		//자원 반납
		conn.close();
		//결과 리턴
		return result;
	}
	
	//회원탈퇴
	public int quit(String id, String pwd) throws Exception {
		//비즈니스 로직
		if(id.length() < 4 || pwd.length() < 4) {
			throw new Exception("길이가 짧습니다.");
		}
		
		//초기화
		Connection conn =  null;
		int result = 0;
		
		try {
			//디비연결
			conn = JdbcTemplate.getConn();
			//DAO 호출
			result = mDao.quit(conn, id, pwd);
			//트랜잭션 처리
			if(result == 1) {
				conn.commit();
			}else {
				conn.rollback();
			}
		}finally {
			//자원반납 - 무조건![ResultSet/Scanner/...] 
			//예외발생하면 커넥션 종료가 안되므로 무조건 실행해야해서 finally 에 넣음
			conn.close();
		}
		
		return result;
	}

	//로그인
	public String login(String id, String pwd) throws Exception {
		//비즈니스 로직
		if(id.length() < 4 || pwd.length() < 4) {
			throw new Exception();
		}
		
		Connection conn = null;
		String x = null;
		
		try {
			//디비연결
			conn = JdbcTemplate.getConn();
			//DAO 호출
			x = mDao.login(conn, id, pwd);
		}finally {
			//자원반납 - 무조건!
			conn.close();
		}
		return x;
		//트랜잭션 처리 - 로그인에서 트랜잭션 처리 필요X
	}
}
