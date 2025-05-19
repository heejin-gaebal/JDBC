package com.kh.app;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("====== JDBC 프로젝트 ======");
		
		StudentController st_cont = new StudentController();
		st_cont.menu();
	}

}
