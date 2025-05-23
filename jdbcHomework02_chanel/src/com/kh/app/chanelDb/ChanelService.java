package com.kh.app.chanelDb;

import java.sql.Connection;
import com.kh.app.util.JdbcTemplate;

public class ChanelService {
	ChanelDao chanelDao;
	
	public ChanelService() {
		chanelDao = new ChanelDao();
	}

	public int insert(ChanelVo vo) throws Exception {
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		int result = chanelDao.insert(conn, vo);
		
		//트랜잭션 처리
		try {
			if(result != 1) {
				conn.rollback();
				throw new Exception("[CHANEL-002] 결과값이 1이 아님");
			}
			conn.commit();
		}finally {
			//자원 반납
			conn.close();
		}
		return result;
	}

	public int update(ChanelVo vo) throws Exception {
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		int result = chanelDao.update(conn, vo);
		//트랜잭션 처리
		try {
			if(result != 1) {
				conn.rollback();
				throw new Exception("[CHANEL-004] 결과값이 1이 아님");
			}
			conn.commit();
		}finally {
			//자원 반납
			conn.close();
		}
		return result;
	}

	public int delete(ChanelVo vo) throws Exception {
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		int result = chanelDao.delete(conn, vo);
		//트랜잭션 처리
		try {
			if(result != 1) {
				conn.rollback();
				throw new Exception();
			}
			conn.commit();
		}finally {
			conn.close();
		}
		//자원 반납
		return result;
	}

	public ChanelVo selectOne(String no) throws Exception {
		Connection conn = JdbcTemplate.getConn();
		ChanelVo vo = chanelDao.selectOne(conn, no);
		return vo;
	}

	
}
