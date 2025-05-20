package com.kh.app.member;

import java.util.Scanner;

public class MemberController {
	private Scanner sc = new Scanner(System.in);
	private MemberService memberService = new MemberService();
	
	//회원가입
	public void join() throws Exception {

		//데이터 준비
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		
		//서비스 호출
		int result = memberService.join(id, pwd);
		
		//결과 확인
		if(result == 1) {
			System.out.println("회원가입 성공!!");
		}else {
			System.out.println("회원가입 실패ㅜㅠ");
		}
	}
	
	//로그인
	public void login() throws Exception {

		//데이터 준비
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		
		//서비스 호출
		String x = memberService.login(id, pwd);
		
		//결과 확인
		System.out.println("로그인 성공한 아이디 : " + x);
	}
}
