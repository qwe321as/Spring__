<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
Travel_start.jsp <br>

<%
	String viewPage = request.getContextPath() + "/list.tv";
	response.sendRedirect(viewPage);
	
%>