package com.spring.ex1;

public class Order {
	public void order() {

		String msg = "상품 주문";

		Login.login(msg); // 공통 기능
		System.out.println(msg + "하기"); // 핵심 기능
		Logout.logout(msg); // 공통 기능

	}
}
