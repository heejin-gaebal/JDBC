package homework.main.movie;

import java.sql.Connection;
import java.util.List;

import homework.main.util.JdbcTemplate;

public class MovieService {

	MovieDao movieDao = new MovieDao();

	public int insert(MovieVo vo) throws Exception {
		//비즈니스 로직
		if(vo.getTitle().length() < 2) {
			throw new Exception("두 글자 이상 입력필요");
		}
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		int result = movieDao.insert(conn, vo);
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

	public int update(MovieVo vo) throws Exception {
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		int result = movieDao.update(conn, vo);
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

	public int delete(MovieVo vo) throws Exception {
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		int result = movieDao.delete(conn, vo);
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

	public MovieVo selectOne(String no) throws Exception {
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		MovieVo vo = movieDao.selectOne(conn, no);
		//트랜잭션 처리
		//자원 반납
		conn.close();
		return vo;
	}

	public List<MovieVo> selectList() throws Exception {
		//DB연결
		Connection conn = JdbcTemplate.getConn();
		//DAO 호출
		List<MovieVo> voList = movieDao.selectList(conn);
		//자원 반납
		conn.close();
		return voList;
	}

}
