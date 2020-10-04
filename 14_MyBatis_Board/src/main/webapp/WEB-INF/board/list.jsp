<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<style>
body {
	width: 100%;
	text-align: center;
}

table {
	margin: 0auto;
	align-content: center;
}
</style>
list.jsp
<bR>
<c:set var="path" value="${pageContext.request.contextPath }" />
<b>글목록(전체글 : ${count }) </b>
<form action="list.bo" method="get">
	<select name="searchColumn">
		<option value="all">전체검색
		<option value="subject">제목으로검색
		<option value="writer">작성자로 검색
	</select> <input type="text" name="searchWord" value=""> <input
		type="submit" value="검색">
</form>
<table border="1" style="width: 700; border-collapse: collapse; align-content: center;">
	<tr>
		<td align="right" colspan="6"><a href="write.bo">글쓰기</a></td>
	</tr>
	<c:if test="${count eq 0 }">
		<tr>
			<td>게시판에 저장된 글이 없습니다.</td>
		</tr>
	</c:if>
	<c:if test="${count ne 0 }">
		<tr>
			<th width="50">번호</th>
			<th width="250">제목</th>
			<th width="100">작성자</th>
			<th width="150">작성일</th>
			<th width="50">조회</th>
			<th width="100">ip</th>
		</tr>
		<c:forEach items="${lists}" var="bean">
			<tr>
				<td align="center">${bean.num }</td>
				<td align="left">
				<c:if test="${bean.relevel > 0 }">
						<img alt="답글이미지  level" src="${path }/images/level.gif" <%-- width="${wid }" --%>
							height="16">
						<img alt="답글이미지" src="${path }/images/re.gif">
					</c:if> <c:if test="${bean.relevel< 0 }">
						<img alt="답글이미지  level" src="${path }/images/level.gif" height="16">
					</c:if> <c:if test="${bean.readcount > 10 }">
						<img alt="hot" src="${path }/images/hot.gif" height="16">
					</c:if> 
					<a href="content.bo?num=${bean.num}">${bean.subject}</a></td>
				<td align="center">${bean.writer}</td>
				<td align="center">${bean.regdate} </td>
				<td align="center">${bean.readcount}</td>
				<td align="center">${bean.ip }</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
	${pageInfo.pagingHtml }<br>

