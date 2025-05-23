package com.kh.app.student;

import java.util.List;
import java.util.Scanner;

public class StudentController {
	private final Scanner sc; 
	private final StudentService studentService;
	
	//생성자 만들어주기
	public StudentController(){
		sc = new Scanner(System.in);
		studentService= new StudentService();
	}
	
	public void insert() {
		try {
			//데이터 준비 : name, gender
			System.out.println("학생 이름 : ");
			String name = sc.nextLine();
			System.out.println("학생 성별 : ");
			String gender = sc.nextLine();
			//서비스 호출
			StudentVo vo = new StudentVo();
			vo.setName(name);
			vo.setGender(gender);
			
			int result = studentService.insert(vo);
			//결과 반환
			if(result != 1) {
				throw new Exception("[STUDENT-001]result값이 1이 아님");
			}
			System.out.println("등록 성공!");
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("등록 실패..");
		}
		
	}

	public void selectOne() throws Exception {
		//데이터 준비 : name, gender
		System.out.println("번호 : ");
		String num = sc.nextLine();
		//서비스 호출
		StudentVo vo = studentService.selectOne(num);	
		System.out.println(vo);
	}

	public void selectList() throws Exception {
		//서비스 호출
		List<StudentVo> voList = studentService.selectList();
		//결과 반환
		for (StudentVo vo : voList) {
			System.out.println(vo);
		}
	}

}
