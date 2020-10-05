<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %> 
<script type="text/javascript">
	function insert(){
		location.href='insert.prd'; 
	}
</script>   
ProductList.jsp<br><br>
<form action="list.prd" method="get">
	<select name="whatColumn">
		<option value="all">전체 검색
		<option value="name">상품명
		<option value="contents">설명
	</select>
	<input type="text" name="keyword" value="오렌지">
	<input type="submit" value="검색">
</form>

<table border="1">
	<tr>
		<td colspan="6" align="right">
			<input type="button" value="추가하기" onclick="insert()">
		</td>
	</tr>
	
	<tr>
		<th>상품번호</th>
		<th>상품명</th>
		<th>설명</th>
		<th>가격</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	<c:forEach items="${lists }" var="product">
		<tr>
			<td>
				${product.num }
			</td>
			
			<td>
				${product.name }
			</td>
			
			<td>
				${product.contents }
			</td>
			<td>
				${product.price }
			</td>
			<td>
				삭제
			</td>
			<td>
				수정
			</td>
		</tr> 
	</c:forEach>
</table>

${pageInfo.pagingHtml } 


















