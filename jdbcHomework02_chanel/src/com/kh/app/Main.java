package com.kh.app;

import com.kh.app.chanelDb.ChanelController;

public class Main {

	public static void main(String[] args) {

		System.out.println("[CHANEL MANAGE SYSTEM]");
		
		ChanelController chanelCont = new ChanelController();
		chanelCont.menu();
	}

}
