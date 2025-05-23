package homework.main.movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDao {

	public int insert(Connection conn, MovieVo vo) throws Exception {
		//쿼리 준비
		String sql ="INSERT INTO MOVIE(NO, TITLE, MAINCHA, GENDER, RELESE_DATE) VALUES(SEQ_MOVIE.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getMaincha());
		pstmt.setString(3, vo.getGender());
		pstmt.setString(4, vo.getReleseDate());
		//쿼리 실행
		int result = pstmt.executeUpdate();
		//자원 반납
		pstmt.close();
		return result;
	}

	public int update(Connection conn, MovieVo vo) throws Exception {
		//쿼리 준비
		String sql = "UPDATE MOVIE SET MAINCHA = ?, GENDER = ?  WHERE NO = ?";
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMaincha());
		pstmt.setString(2, vo.getGender());
		pstmt.setString(3, vo.getNo());
		//쿼리 실행
		int result = pstmt.executeUpdate();
		//자원 반납
		pstmt.close();
		
		return result;
	}

	public int delete(Connection conn, MovieVo vo) throws Exception {
		String sql = "UPDATE MOVIE SET PLAY_YN = ? WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPlay_yn());
		pstmt.setString(2, vo.getNo());
		//쿼리 실행
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		return result;
	}

	public MovieVo selectOne(Connection conn, String no) throws Exception {
		//쿼리 준비
		String sql = "SELECT * FROM MOVIE WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		//쿼리 실행
		ResultSet rs = pstmt.executeQuery();
		
		MovieVo vo = null;
		
		if(rs.next()) {
			String title = rs.getString("TITLE");
			String maincha = rs.getString("MAINCHA");
			String gender = rs.getString("GENDER");
			String releseDate = rs.getString("RELESE_DATE");
			String play_yn = rs.getString("PLAY_YN");
			
			vo = new MovieVo(no, title, maincha, gender, releseDate, play_yn);			
		}
		
		//자원 반납
		pstmt.close();
		rs.close();
		return vo;
	}

	public List<MovieVo> selectList(Connection conn) throws Exception {
		//쿼리 준비
		String sql = "SELECT * FROM MOVIE ORDER BY NO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//쿼리 실행
		ResultSet rs = pstmt.executeQuery();
		
		List<MovieVo> voList = new ArrayList<MovieVo>();
		MovieVo vo = null;
		
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String maincha = rs.getString("MAINCHA");
			String gender = rs.getString("GENDER");
			String releseDate = rs.getString("RELESE_DATE");
			String play_yn = rs.getString("PLAY_YN");
			
			vo = new MovieVo(no, title, maincha, gender, releseDate, play_yn);	
			
			voList.add(vo);
		}
		
		//자원 반납
		rs.close();
		pstmt.close();
		
		return voList;
	}
}
