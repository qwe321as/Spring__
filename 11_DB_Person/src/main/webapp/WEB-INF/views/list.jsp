<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
table{
width: 450;
height: auto;
border-collapse: collapse;
}
</style>
list.jsp
<br>
레코드 갯수 : ${fn:length(lists) }
<br>

<table border="1">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>나이</th>
	</tr>
	<c:forEach items="${lists }" var="dto">
		<tr>
			<th>${dto.num }</th>
			<td><a href="delete?num=${dto.num }">${dto.id }</a></td>
			<td><a href="content_view?num=${dto.num }">${dto.name }</a></td>
			<td>${dto.age}</td>
		</tr>
	</c:forEach>
	<tr><td colspan="4" align="right"><input type="button" onclick="location.href='write_view' " value="삽입" > </td></tr>
</table>


