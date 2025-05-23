package com.kh.app.board;

import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardController {

	private Scanner sc = new Scanner(System.in);
	BoardService boardService = new BoardService();
	//insert
	public void insert() throws Exception {
		//데이터 준비
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String content = sc.nextLine();
		
		//서비스 호출
		int result = boardService.insert(title, content);
		
		//결과 확인
		if(result == 1) {
			System.out.println("작성 성공");
		}else {
			System.out.println("작성 실패");
		}
	}
	
	//update
	public void update() throws Exception {
		//데이터 준비
		System.out.print("게시글 번호 :");
		String no = sc.nextLine();
		System.out.print("게시글 내용 :");
		String content = sc.nextLine();
		
		//서비스 호출
		int result = boardService.update(no, content);
		//결과 확인
		if(result == 1) {
			System.out.println("게시글 수정 성공");
		}else {
			System.out.println("게시글 수정 실패");			
		}
	}
	
	//delete
	public void delete() throws Exception {
		//데이터 준비
		System.out.print("게시글 번호 : ");
		String no = sc.nextLine();
		//서비스 호출
		int result = boardService.delete(no);
		//결과 확인
		if(result == 1) {
			System.out.println("게시글 삭제 성공");
		}else {
			System.out.println("게시글 삭제 실패");
		}
	}

	//selectList
	public ArrayList<BoardVo> selectList() throws Exception {
		//데이터 준비
		//서비스 호출
		ArrayList<BoardVo> voList =  boardService.selectList();
		//여러 행의 모든 컬럼이 필요하므로 vo 객체로 리턴받기
		
		//return 이 있으면 해당 메서드 종료되므로 그전에 출력
//		for(int i=0; i < voList.size(); i++) {
//			System.out.println(voList.get(i));			
//		}
		
		//리스트의 모든 요소를 꺼내서 리스트 타입 x에 담는다
		//여기서는 배열리스트 타입이므로 배열리스트 타입으로 지정
		for(BoardVo x : voList) {
			System.out.println(x);
		}
		//배열의 모든 요소에 접근하기 위함
		
		//결과 확인
		return voList;
		
	}

	//selectOne
	public void selectOne() throws Exception {
		//데이터 준비
		System.out.print("no : ");
		String no = sc.nextLine();
		
		//서비스 호출
		
		//한 행만 출력할 것이므로
		BoardVo vo = boardService.selectOne(no);
		//결과 확인
		System.out.println(vo);
	}
	
}
