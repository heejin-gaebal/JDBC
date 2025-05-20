package com.kh.app;

import java.sql.Connection;

public class MemberService {

	//회원가입
	public int join(String id, String pwd) throws Exception {
		//비즈니스 로직 (데이터 검증)
		if(id.length() < 4) {
			throw new Exception();
//			System.out.println("회원가입 실패...");
//			return 0; // 실패시 아래 코드 실행 막기 위함
		}
		if(pwd.length() < 4) {
			throw new Exception();
//			System.out.println("회원가입 실패...");
//			return 0;
		}
		
		//DB관련작업 
		//db연결
		Connection conn = JdbcTemplate.getConn();
		MemberDao mDo = new MemberDao(); //Dao객체 생성
		int result = mDo.join(conn, id, pwd);	
		//이 값을 가지고 Dao의 메서드로 이동한후 실행된 값을 호출
		
		//트랜잭션 처리
//		conn.commit();
//		conn.rollback();
		
		//트랜잭션 처리 - db연결
		if(result == 1) {
			conn.commit();
		}else {
			conn.rollback();
		}
		
		//connection 객체가 태어난곳에서 close 
		//Dao에서 다른 실행을 하고 끊어버리면 안됨
		conn.close(); //connection 끊기 [자원반납 relese]
		
		return result;
		
		
	}
	
	//로그인
	public boolean login(String id, String pwd) throws Exception {
		//비즈니스 로직(데이터 검증)
		if(id.length()<4) {
			throw new Exception();
		}
		if(pwd.length()<4) {
			throw new Exception();
		}
		
		//DB관련작업 
		MemberDao mDo = new MemberDao();
		boolean isOk = mDo.login(id, pwd);
		//ResultSet은 boolean 타입이므로 boolean 타입으로 리턴받기
		return isOk;
	}
}
