<%@page import="com.spring.ex.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
person/personView4.jsp <br><br>

id1 : ${p.id} <br>
id2 : ${person.id}<br>
id3 : ${person.getId()}<br>
id4 : ${requestScope.person.id}<br><br>

id5 : ${abcd.id}<br>
id6 : ${requestScope.abcd.id}<br>
id7 : ${requestScope.abcd.getId()}<br>
id8 : <%=((Person)request.getAttribute("abcd")).getId() %><br>


pw : ${abcd.getPw() }<br>
name : ${abcd.name }<br>
addr : <%= ((Person)request.getAttribute("abcd")).getAddr() %> <br>










