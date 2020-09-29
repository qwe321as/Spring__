<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>

TravelListForm.jsp<br>
<h2>여행 리스트 화면</h2>
<form action="list.tv" method="get">
	<select name="searchColumn">
		<option value="all">전체검색
		<option value="area">관심지역
		<option value="style">여행타입
	</select>
	<input type="text" name="searchWord" value="">
	<input type="submit" value="검색">
</form>

<table border="1" style="border-collapse: collapse;">
<tr>
		<td colspan="8" align="right">
			<input type="button" value="추가하기" onClick="location.href='insert.tv'">
		</td>	
	</tr>
	<tr>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>관심지역</th>
		<th>여행타입</th>
		<th>예상비용</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	
<c:forEach items="${lists}" var="travel">
	<tr>
		<td>${travel.num}</td>
		<td>${travel.name}</td>
		<td>${travel.age}</td>
		<td>${travel.area}</td>
		<td>${travel.style}</td>
		<td>${travel.price}</td>
		<td><a href="delete.tv?num=${travel.num}">삭제</a></td>
		<td><a href="update.tv?num=${travel.num}">수정</a></td>
	</tr>
</c:forEach>	
	
</table>
	${pageInfo.pagingHtml }<br>






