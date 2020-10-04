<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="style.css" rel="stylesheet" type="text/css">
<%@include file="common.jsp"%>
<style>
body {
	width: 100%;
	text-align: center;
}

table {
	margin: 0auto;
}
</style>
<c:set var="path" value="${pageContext.request.contextPath }" />
<script type="text/javascript" src="${path }/js/jquery.js"></script>
<script type="text/javascript" src="${path }/js/script.js"></script>
<b>답글쓰기</b>
<form method="post" name="writeform" action="reply.bo" onsubmit="return writeSave()">
	<input type="hidden" name="ref" value="${ref}" >
	<input type="hidden" name="re_step" value="${re_step }" >
	<input type="hidden" name="re_level" value="${re_level}" >
	<table border="1" width="450px" align="center" cellspacing="0">
		<tr align="right">
			<td colspan="2" ><a href="list.jsp">글목록</a></td>
		</tr>
		<tr>
			<td width="100" align="center" >이름</td>
			<td><input type="text" size="30" maxlength="10" name="writer"
				value="이예지"></td>
		</tr>
		<tr>
			<td width="100" align="center">제목</td>
			<td width="350"><input type="text" size="50" value="[답글]"
				maxlength="50" name="subject"></td>
		</tr>
		<tr>
			<td width="100" align="center" >Email</td>
			<td width="350"><input type="text" size="50" maxlength="30"
				value="qw" name="email"></td>
		</tr>
		<tr>
			<td width="100" align="center">내용</td>
			<td width="350"><textarea name="content" id="adc" rows="13"
					cols="50">내용은 이게 좋겠어</textarea></td>
		</tr>
		<tr>
			<td align="center">비밀번호</td>
			<td><input type="password" size="10" maxlength="12"
				value="1147" name="passwd"></td>
		</tr>
		<tr> 
			<td colspan=2 align="center" height="30">
				<input type="submit" value="글쓰기" >
				<input type="reset" value="다시작성"> 
				<input type="button" value="목록보기" onclick="location='list.bo'">
			</td>
		</tr>
	</table>
</form>