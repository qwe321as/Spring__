package com.spring.ex1;

public class Board {
	public void board() {
		
		String msg = "게시물 등록";
		
		Login.login(msg); // 공통 기능
		System.out.println(msg + "하기"); // 핵심 기능
		Logout.logout(msg); // 공통 기능
		
	}
}
