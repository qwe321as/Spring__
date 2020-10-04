<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common.jsp"%>
<style>
body {
	width: 100%;
	text-align: center;
}

table {
	margin: 0auto;
	border-collapse: collapse;
}
</style>
<script type="text/javascript">
	

</script>
<b>글 내용 보기</b>
	<table  border="1" width="500" align="center">
		<tr>
			<td width="125" align="center" >글번호</td>
			<td>${bean.num }</td>
			<td  width="125" align="center">조회수</td>
			<td>${bean.readcount}</td>
		</tr>
		<tr>
			<td width="125" align="center" >작성자</td>
			<td>${bean.writer}</td>
			<td width="125" align="center" >작성일</td>
			<td>${bean.regdate}</td>
		</tr>
		<tr>
			<td width="125" align="center" >글제목</td>
			<td colspan="3">${bean.subject}</td>

		</tr>
		<tr>
			<td width="125" align="center" >글내용</td>
			<td colspan="3">${bean.content}</td>
		</tr>
		<tr>
			<td colspan="4"  width="125" align="right" >
			<input type="button" value="글수정" onclick="location='update.bo?num=${bean.num}'"> 
			<input type="button" value="글삭제" onclick="location='delete.bo?num=${bean.num}"> 
			<input type="button" value="답글쓰기" onclick="location='reply.bo?ref=${bean.ref}&re_step=${bean.restep}&re_level=${bean.relevel}'"> 
			<input type="button" value="글목록" onclick="location='list.bo?pageNum=${bean.num}'">
			</td>
		</tr>
	</table>
