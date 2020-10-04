<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<b>글삭제</b>
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

<form method="post" action="delete.bo" name="delFrom">
<table border="1" width="500" align="center" cellspacing="0">
<tr>
<th width="125" align="center">
비밀번호를 입력하주세요</th>
</tr>
<tr>
<td align="center">
<input type="hidden" name="num" value="${num }">
비밀번호: <input type="password" name="passwd" size="8" maxlength="12">
</td>
</tr>
<tr>
<td width="125" align="center">
<input type="submit" value="글삭제" >
<input type="button" value="글목록" onclick="location='list.jsp'">
</td>
</tr>
</table>
</form>