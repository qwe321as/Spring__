<%@page import="board.model.BoardDao"%>
<%@page import="board.model.BoardBean"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="color.jsp" %> 
<style type="text/css">
body {
    width: 100%;
    text-align : center;
}
table {
    margin: 0 auto;
}   
</style>     
	content.jsp<br>
	<body bgcolor="<%=bodyback_c %>">
	
	
	
	
	
	
	글내용 보기
	<table border="1" width="450" align="center" cellspacing="0">
	<tr>
		<td width="125"  align="center" bgcolor="<%=value_c %>" >글번호 </td>
		<td width="125"  align="center">${lists.num }</td>  
		<td width="125"  align="center" bgcolor="<%=value_c %>">조회수 </td>
		<td width="125"  align="center">${lists.readcount} </td>
		
	</tr>
	<tr>
		<td width="125"  align="center" bgcolor="<%=value_c %>">작성자 </td>
		<td width="125"  align="center" >${lists.writer }</td>
		<td width="125"  align="center" bgcolor="<%=value_c %>" >작성일</td>
		<td width="125"  align="center" >${lists.regdate }
		
	</tr>
	<tr>
		<td width="125"  align="center" bgcolor="<%=value_c %>">글제목 </td>
		<td colspan="3" align="center" >${lists.subject }</td>
		
		
	</tr>
	<tr>
		<td width="125"  align="center" bgcolor="<%=value_c %>">글내용 </td>
		<td colspan="3">${lists.content }</td>
		
		
	</tr>
	<tr>
			<td colspan=4  align="center" height="30" bgcolor="<%=value_c %>">
				<input type="submit" value="글수정" onClick="location.href='update.bd?num=${lists.num }'">  
				<input type="button" value="글삭제" onClick="location.href='delete.bd?num=${lists.num}'"> 
				<input type="reset"	value="답글쓰기" onClick="location.href='reply.bd?num=${lists.num }&ref=${lists.ref }&re_level=${lists.relevel }&re_step=${lists.restep }'"> 
				<input type="button" value="목록보기" onClick="location.href='list.bd'">
			</td>
		</tr>
	
	
	
	
	</table>