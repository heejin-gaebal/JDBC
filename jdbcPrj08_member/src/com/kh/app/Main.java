package com.kh.app;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("layer 분리!!");
		MemberController memberController = new MemberController();
		memberController.menu();
		
		/*
		 * 레이어를 분리하면 유지보수에 용이 / DB를 바꿀때의 용이성
		 * DataAccessObject DB와 연동할때의 필요 / 역할에 맡게 분리
		 * 오라클 DB연결에 필요한 부분을 Dao로 옮기고
		 * Controller에 Dao 객체 생성하고 Dao의 메서드 호출
		 * 호출메서드로 받아온 결과를 result에 담기
		 * ex) int result = mDo.join(id, pwd);
		 * 
		 * ResultSet인 결과테이블은 리턴을 rs.next()로해주고 
		 * Controller에서 boolean타입으로 리턴받아서 boolean변수에 넣어주고
		 * if문에 boolean변수넣어서 결과 확인
		 * 
		 * controller - service - dao
		 * 
		 * - 비즈니스 로직 (데이터 검증)
		 * 
		 * [에러 발생] ORA-17273: 자동 커밋이 사용으로 설정된 채 커밋할 수 없습니다.
		 * 자동커밋을 비활성화 해줘야 함
		 * 굳이 autoCommit을 끄는 이유 :
		 * 
		 */
		
	}

}
