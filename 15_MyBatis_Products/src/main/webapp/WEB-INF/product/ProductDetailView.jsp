<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
body {
	align-content: center;
}

table {
	border-collapse: collapse;
}
</style>
<h2>상품 상세 화면</h2>

<table border="1">
   <tr>
      <td rowspan="6">		
      <img alt="상품이미지" width="100px" height="100px" src="<%=request.getContextPath() %>/resources/${product.image}">
      </td>
      <td>상품명</td>
      <td>${product.name}</td>
   </tr>
   
		<tr>
		<th>가격</th>
		<td>${product.price}</td>
	</tr>

	<tr>
		<th>재고 수량</th>
		<td>${product.stock }</td>
	</tr>
<tr>
		<th>설명</th>
		<td>${product.contents }</td>
	</tr>
<tr>
		<th>주문수량</th>
		<td>주문수량: <form action="add.mall" method="post">
				<input type="hidden" name="num" value="${product.num }">
				<input type="text" name="orderqty" value="1">
<input type="submit" value="주문"> </form></td>
<!-- addmall=>cartaddcontroller -->
	</tr>
<tr>
		<td colspan="3"><a href="list.prd">상품 리스트</a></td> </tr>

</table>