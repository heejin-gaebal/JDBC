package com.kh.app.chanelDb;

import java.util.Scanner;

public class ChanelController {
	private final Scanner sc;
	private final ChanelService chanelServ;
	public ChanelController() {
		sc = new Scanner(System.in);
		chanelServ = new ChanelService();
	}
	public void menu() {
		while(true) {
			System.out.println("관리메뉴 번호");
			System.out.println("1. 제품 등록");
			System.out.println("2. 제품 수정");
			System.out.println("3. 제품 삭제");
			System.out.println("4. 제품 단건목록");
			System.out.println("5. 판매중인 제품 검색");
			System.out.println("6. 단종된 제품 검색");
			System.out.println("7. 모든 제품 검색");
			
			int menuNum = Integer.parseInt(sc.nextLine());
			
			switch(menuNum) {
			case 1 : insert(); break;
			case 2 : update(); break;
			case 3 : delete(); break;
			case 4 : selectOne(); break;
			case 5 : selectDelN(); break;
			case 6 : selectDelY(); break;
			case 7 : selectList(); break;
			default : System.out.println("잘못선택하셨습니다.");
			}
			
			if(menuNum == 0) {
				System.out.println("시스템종료");
				break;
			}
		}
	}
	
	public void insert() {
		try {
			//데이터 준비
			System.out.println("1. 제품 등록");
			System.out.print("제품명 : ");
			String product = sc.nextLine();
			System.out.print("제품가격 : ");
			String price = sc.nextLine();
			System.out.print("제품 입고수량 : ");
			int qntty = Integer.parseInt(sc.nextLine());

			//서비스 호출
			ChanelVo vo = new ChanelVo();
			vo.setProduct(product);
			vo.setPrice(price);
			vo.setQuantity(qntty);
			
			int result = chanelServ.insert(vo);
			
			//결과 반환
			if(result != 1) {
				throw new Exception("[CHANEL-001] 결과값이 1이 아님");
			}
			System.out.println("제품등록 완료!! \n");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("제품등록 실패..");
		}
		
	}
	
	public void update() {
		try {
			System.out.println("2. 제품 수정");
			//데이터 준비
			System.out.print("제품 번호 : ");
			String no = sc.nextLine();
			System.out.print("제품명 : ");
			String product = sc.nextLine();
			//서비스 호출
			
			ChanelVo vo = new ChanelVo();
			vo.setProduct(product);
			vo.setNo(no);
			
			int result = chanelServ.update(vo);
			//결과 반환
			if(result != 1) {
				throw new Exception("[CHANEL-002] 결과값이 1이 아님");
			}
			System.out.println("제품수정 완료!! \n");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("제품수정 실패.");
		}
	}
	
	public void delete() {
		try {
			System.out.println("3. 제품 삭제");
			//데이터 준비
			System.out.print("제품번호 : ");
			String no = sc.nextLine();
			System.out.print("단종시킬까요? : ");
			String delYn = sc.nextLine();
			//서비스 호출
			ChanelVo vo = new ChanelVo();
			vo.setNo(no);
			vo.setDel_yn(delYn);
			
			int result = chanelServ.delete(vo);
			//결과 반환
			//결과 반환
			if(result != 1) {
				throw new Exception("[CHANEL-002] 결과값이 1이 아님");
			}
			System.out.println("제품수정 완료!! \n");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("제품수정 실패");
		}
	}
	
	public void selectOne() throws Exception {
		System.out.println("4. 제품 단건목록");
		//데이터 준비
		String no = sc.nextLine();
		//서비스 호출
		ChanelVo vo = chanelServ.selectOne(no);
		//결과 반환
		System.out.println(vo);
	}
	public void selectDelN() {
		System.out.println("5. 판매중인 제품 검색");
		//데이터 준비
		//서비스 호출
		//결과 반환
	}
	public void selectDelY() {
		System.out.println("6. 단종된 제품 검색");
		//데이터 준비
		//서비스 호출
		//결과 반환
	}
	public void selectList() {
		System.out.println("7. 모든 제품 검색");
		//데이터 준비
		//서비스 호출
		//결과 반환
	}

	//데이터 준비
	//서비스 호출
	//결과 반환
}
