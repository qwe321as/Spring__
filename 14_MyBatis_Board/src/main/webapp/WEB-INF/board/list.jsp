<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<%@include file ="color.jsp" %>

<style>
body {
    width: 100%;
    text-align : center;
}
table {
    margin: 0 auto;
}   

</style>


<body bgcolor="<%=bodyback_c %>">


	<b> 글목록</b>
<form action="list.bd" method="get">
	<select name="whatColumn">
		<option value="all">전체검색
		<option value="subject">제목으로 검색
		<option value="writer">작성자 검색
	</select>
	<input type="text" name="keyword" value="홍길동">
	<input type="submit" value="검색">
</form>
    <table border=1>
    
    	<tr>
    		<td align="right"  colspan="6">
    			<a href="insert.bd">게시글 등록</a>
    		</td>
    	</tr>
    	<tr bgcolor= "<%=value_c%>">
    		<th>번호</th>
    		<th>제목</th>
    		<th>작성자</th>
    		<th>작성일</th>
    		<th>조회</th>
    		<th>IP</th>
    	</tr>
    <c:forEach items ="${lists }" var ="bean">
    	<tr>
    		<td>${bean.num }</td>
    		<td><a href="content.bd?num=${bean.num}">${bean.subject }</a></td>
    		<td>${bean.writer }</td>
    		<td>${bean.regdate }</td>
    		<td>${bean.readcount }</td>
    		<td>${bean.ip }</td>
    	</tr>
    </c:forEach>
    
    
    </table>
    </body>
    ${pageInfo.pagingHtml}