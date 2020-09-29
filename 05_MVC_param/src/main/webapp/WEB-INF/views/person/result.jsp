<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
person\result.jsp <br>

name1 : ${name} <br>
name2 : ${requestScope.name} <br>
name3 : <%=request.getAttribute("name") %> <br>
name4 : <%=request.getParameter("name") %> <br>
name5 : ${param.name } <br><br>

age1 : ${age} <br>
age2 : ${requestScope.age} <br>
age3 : <%=request.getAttribute("age") %> <br>
age4 : <%=request.getParameter("age") %> <br>
age5 : ${param.age } <br><br>
