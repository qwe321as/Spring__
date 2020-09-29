package com.spring.ex2;

public class BoardImpl implements Board{

	String msg = "게시물 등록 ";
	
	@Override
	public void board() {
		System.out.println(msg + "하기"); // 핵심기능
	}

}
