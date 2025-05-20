package com.kh.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MemberController {
	private Scanner sc = new Scanner(System.in);
	//메뉴
	public void menu() throws Exception {
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		
		System.out.println("번호 입력");
		String num = sc.nextLine();
		
		switch(num) {
		case "1" : join(); break;
		case "2" : login(); break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	//회원가입
	public void join() throws Exception {
		System.out.println("------ 회원가입 ------");
		
		//데이터 준비
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		
		MemberService service = new MemberService();
		int result = service.join(id, pwd);
		
		//실행확인
		if(result == 1) {
			System.out.println("회원가입 성공ㅋㅋ");
		}else {
			throw new Exception();
		}
	}
	
	//로그인
	public void login() throws Exception {
		System.out.println("------ 로그인 ------");
		//데이터 준비
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine(); 
		
		MemberService service = new MemberService();
		boolean isOk = service.login(id, pwd);
		
		//실행결과
		if(isOk) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");			
		}
	}
}
