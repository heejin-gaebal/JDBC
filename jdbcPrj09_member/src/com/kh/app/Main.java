package com.kh.app;

import com.kh.app.member.MemberController;

public class Main {

	public static void main(String[] args) {
		System.out.println("JDBC - MEMBER - layer");
	
		MemberController memberController = new MemberController();
		memberController.join();
		memberController.quit();
		memberController.login();
	}
}
