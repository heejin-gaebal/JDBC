package com.kh.app.member;

import java.util.Scanner;

public class MemberController {
	 private Scanner sc = new Scanner(System.in);
	 private MemberService service = new MemberService(); //필드에 클래스 생성해줌
	
	//회원가입
	public void join() {
		try {
			//데이터 준비
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();
			
			//서비스 호출
			int result = service.join(id,pwd); //INSERT문은 int 타입 반환
			
			//결과 확인
			if(result == 1) {
				System.out.println("회원가입 성공!!");
			}else {
				System.out.println("회원가입 실패ㅜㅠ");			
			}
			//여기 어딘가에서 예외발생하면 catch 블럭으로 이동
		}catch(Exception e){
			e.printStackTrace(); //에러구문 구현
			System.out.println("회원가입 실패ㅜㅠ");
		}
	}
	
	//회원탈퇴
	public void quit() {
		try {
			//데이터 준비
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();
			
			//서비스 호출
			int result = service.quit(id, pwd);
			
			//결과 확인
			if(result != 1) {
				throw new Exception();
			}else {
				System.out.println("탈퇴 성공!!");
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("[KH-MEMBER-001]탈퇴 실패ㅜㅜ");
		}
	}
	
	public void login() {
		try {
			//데이터 준비
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();
			
			//서비스 호출
			String x = service.login(id,pwd);
			
			if(x == null) {
				throw new Exception();
			}
			System.out.println("로그인 성공");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("로그인 실패");
		}
		
	}
}
