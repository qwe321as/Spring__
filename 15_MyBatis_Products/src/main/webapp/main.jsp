<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


main.jsp<br><br><br>

<%
	String viewProduct = request.getContextPath() + "/list.prd";

	String viewOrder = request.getContextPath() + "/order.mall";
	
	//HttpSession session = new HttpSession();
	//session.setAttribute(name, value);
%>

<a href="<%=viewProduct%>">상품 목록 보기</a> <br><br><br>

<a href="<%=viewOrder%>">나의 주문 내역</a> <br><br><br>
