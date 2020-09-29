<%@page import="com.spring.ex.Person"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
person/personView2.jsp <br><br>

id : <%=request.getParameter("id") %><br>
pw : ${param.pw }<br>
name : ${param.name }<br>
addr : ${param.addr }<br><br>

per.id1 : ${requestScope.per.getId() }<br>
per.id2 : ${requestScope.per.id }<br>
per.id3 : ${per.getId() }<br>
per.id4 : ${per.id }<br>

per.id5 : <%=request.getAttribute("per") %><br>
per.id6 : <%=((Person)request.getAttribute("per")).getId() %><br><br>



per.pw1 : ${per.getPw() }<br><br>


per.name : ${requestScope.per.getName() }<br><br>
per.addr : <%=((Person)request.getAttribute("per")).getAddr() %><br> 


