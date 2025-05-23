package homework.main.movie;

import java.util.List;
import java.util.Scanner;

public class MovieController {

	 private Scanner sc = new Scanner(System.in);
	 MovieService movieService = new MovieService();
	
	public void insert() {
		try {
			//데이터 준비
			System.out.print("제목 : ");
			String title = sc.nextLine();
			System.out.print("주인공 : ");
			String maincha = sc.nextLine();
			System.out.print("성별 : ");
			String gender = sc.nextLine();
			System.out.print("개봉일 : ");
			String relDate = sc.nextLine();
			
			//서비스 호출
			MovieVo vo = new MovieVo();
			vo.setTitle(title);
			vo.setMaincha(maincha);
			vo.setGender(gender);
			vo.setReleseDate(relDate);
			int result = movieService.insert(vo);
			
			//결과 반환
			if(result == 1) {
				System.out.println("☆영화 등록 완료☆");
			}else {
				throw new Exception();
			}		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("※영화 등록 실패※");
		}
	}

	public void update() {
		try {
			//데이터 준비
			System.out.print("번호 : ");
			String no = sc.nextLine();
			System.out.print("변경할 주인공이름 : ");
			String maincha = sc.nextLine();
			System.out.print("변경할 주인공성별 : ");
			String gender = sc.nextLine();
			//서비스 호출
			MovieVo vo = new MovieVo();
			vo.setNo(no);
			vo.setMaincha(maincha);
			vo.setGender(gender);
			int result = movieService.update(vo);
			//결과 반환
			if(result != 1) {
				throw new Exception("문제!!!!!!");
			}		
			System.out.println("☆영화 정보 수정 완료☆");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("※영화 정보 수정 실패※");
		}
	}

	public void delete() {
		try {
			//데이터 준비
			System.out.print("번호 : ");
			String no = sc.nextLine();
			System.out.print("상영여부 Y/N : ");
			String playYn = sc.nextLine();
			//서비스 호출
			MovieVo vo = new MovieVo(); 
			vo.setNo(no);
			vo.setPlay_yn(playYn);
			int result = movieService.delete(vo);
			//결과 반환
			if(result == 1) {
				System.out.println("☆종영 설정 완료☆");
			}else {
				throw new Exception();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("※종영 설정 실패※");
		}		
	}

	public void selectOne() {
		try {
			//데이터 준비
			System.out.println("영화정보를 확인 할 번호 : ");
			String no = sc.nextLine();
			//서비스 호출
			MovieVo vo = movieService.selectOne(no);
			//결과 반환
			System.out.println(vo);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("※영화정보 확인 실패※");
		}
		
	}

	public void selectList() {
		//데이터 준비
		try {
			//서비스 호출
			List<MovieVo> voList = movieService.selectList();
			for(MovieVo x : voList) {
				System.out.println(x);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("※영화 전체정보 확인 실패※");
		}
	}
}
