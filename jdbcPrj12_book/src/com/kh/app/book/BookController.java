package com.kh.app.book;

import java.util.List;
import java.util.Scanner;

public class BookController {

	Scanner sc = new Scanner(System.in);
	BookService bookService = new BookService();
	
	public void insert() throws Exception {
		//데이터 준비
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("작가 : ");
		String author = sc.nextLine();
		System.out.print("가격 : ");
		String price = sc.nextLine();
		
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setAuthor(author);
		vo.setPrice(price);
		
		//서비스 호출
		int result = bookService.insert(vo); //행 전체를 출력
		//결과 확인
		if(result == 1) {
			System.out.println("도서 등록 성공");
		}else {
			System.out.println("도서 등록 실패");
		}
	}

	public void update() throws Exception {
		//데이터 준비
		System.out.print("no : ");
		String no = sc.nextLine();
		System.out.print("가격 : ");
		String price = sc.nextLine();
		
		BookVo vo = new BookVo();
		vo.setNo(no);
		vo.setPrice(price);
		
		//서비스 호출
		int result = bookService.update(vo);
		//결과 확인
		if(result == 1) {
			System.out.println("가격 수정 성공");
		}else {
			System.out.println("가격 수정 실패");
		}
	}

	public void delete() throws Exception {
		//데이터 준비
		System.out.print("no : ");
		String no = sc.nextLine();
		//서비스 호출
		int result = bookService.delete(no);
		//결과 확인
		if(result == 1) {
			System.out.println("도서 삭제 성공");
		}else {
			System.out.println("도서 삭제 실패");
		}
	}

	public void selectList() throws Exception {
		//데이터 준비
		//서비스 호출 - 여러개의 행을 받아와서 객체에 넣어주기 - 배열
		List<BookVo> voList = bookService.selectList();
		
		//결과 확인 - 향상된 for문 리스트에서 요소 하나씩 꺼내기 반복
		for(BookVo x : voList) {
			System.out.println(x);
		}
	}

	public void selectOne() throws Exception {
		//데이터 준비
		System.out.print("no : ");
		String no = sc.nextLine();
		//서비스 호출
		BookVo vo = bookService.selectOne(no);
		//결과 확인
		System.out.println(vo);
	}

}
