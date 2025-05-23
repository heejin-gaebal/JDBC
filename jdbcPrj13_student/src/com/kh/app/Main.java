package com.kh.app;

import com.kh.app.student.StudentController;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("============= 학생관리 프로그램 ============= ");
		
		StudentController studentController = new StudentController();
//		studentController.insert();
//		studentController.update();
//		studentController.delete();
//		studentController.selectOne();
		studentController.selectList();
	}

}
