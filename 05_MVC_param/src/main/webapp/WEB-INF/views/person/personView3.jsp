<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
person/personView3.jsp <br><br>

id1 : ${p.id} <br>
id2 : ${person.id}<br>
id3 : ${person.getId()}<br>
id4 : ${requestScope.person.id}<br><br>

pw : ${person.pw } <br>

name : ${person.getName()}<br>
addr : ${requestScope.person.addr}<br><br>

