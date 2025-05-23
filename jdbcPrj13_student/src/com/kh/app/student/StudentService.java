package com.kh.app.student;

import java.sql.Connection;
import java.util.List;

import com.kh.app.util.JdbcTemplate;

public class StudentService {
	private final StudentDao studentDao;

	public StudentService() {
		studentDao = new StudentDao();
	}
	public int insert(StudentVo vo) throws Exception {
		//비즈니스 로직
		if(vo.getName().length() < 1) {
			throw new Exception("한 글자 이상 입력필요");
		}
		if(!vo.getGender().equals("M") && !vo.getGender().equals("F")) {
			throw new Exception("성별 입력값 잘못됨 - M/F만 가능");
		}
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		int result = studentDao.insert(conn,vo);
		
		try {
			//트랜잭션 처리
			if(result != 1) {
				conn.rollback();
				throw new Exception("[STUDENT-002]result값이 1이 아님"); 
				//개인적으로 에러코드 설정해놓고 엑셀에 코드와 해결방안을 정리해두면 
				//유지보수에 편하고 쉽게알수있음
			}
			conn.commit(); //그냥 커밋 돌진!
			
		}finally {// 자원 반납 : 예외처리가 생겨도 무조건 실행
			conn.close();
		}
		return result;
	}
	
	public StudentVo selectOne(String num) throws Exception {
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		StudentVo vo = studentDao.selectOne(conn,num);
		//트랜잭션 처리
		//자원 반납
		conn.close();
		return vo;
	}
	public List<StudentVo> selectList() throws Exception {
		//비즈니스 로직
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		List<StudentVo> voList = StudentDao.selectList(conn);
		//트랜잭션 처리
		//자원 반납
		conn.close();
		
		return voList;
	}
}
