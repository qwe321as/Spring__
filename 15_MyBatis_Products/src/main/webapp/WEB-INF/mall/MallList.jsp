<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common.jsp"%>
<style>
body{
text-align: center;
}
table{
	border-collapse: collapse;
}
</style>
<h2>주문내역</h2>
<table border="1" align="center">
	<tr>
		<td colspan="5" align="center">주문자 정보 :
		${sessionScope.loginInfo.name}(${sessionScope.loginInfo.id })</td>
	</tr>
	<tr>
		<th>상품번호</th>
		<th>상품명</th>
		<th>주문수량</th>
		<th>단가</th>
		<th>금액</th>
	</tr>
	<c:forEach var="jumun" items="${shoplists}">
		<tr>
			<td align="center">${jumun.pnum}</td>
			<td align="center">${jumun.pname}</td>
			<td align="center">${jumun.qty}</td>
			<td align="center">${jumun.price}</td>
			<td align="center">${jumun.amount}</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="3" align="center"><a href="calculate.mall">결재하기</a>  <a href="list.prd">추가주문</a></td>
		<td colspan="2">총금액:${totalAmount }</td>
	</tr>




</table>