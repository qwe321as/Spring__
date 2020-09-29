<%@page import="com.spring.ex.MusicBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

WEB-INF\views\music\result4.jsp<br>

title : ${musicBean.title }<br>
signer : ${musicBean.getSinger() }<br>
<%-- price : <%=((MusicBean)request.getAttribute("musicBean")).getPrice() %><br> --%>


title : ${mb.title }<br>
signer : ${mb.getSinger() }<br>
price : <%=((MusicBean)request.getAttribute("mb")).getPrice() %><br>