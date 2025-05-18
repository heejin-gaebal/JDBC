package com.kh.app;

import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
	
			System.out.println("zzz");
			
			List db = new ArrayList();
			
			//insert
			db.add("카리나");
			db.add("윈터");
			db.add("닝닝");
			db.add("지젤");
			db.add("아이유");
			
			//select
			System.out.println(db.get(0));
			System.out.println(db.get(1));
			System.out.println(db.get(2));
			System.out.println(db.get(3));
			System.out.println(db.get(4));
	}

}
