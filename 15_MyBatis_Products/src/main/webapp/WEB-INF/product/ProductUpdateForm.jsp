<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common.jsp" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>상품 수정 화면</title>
	<meta charset="UTF-8">
	<style type="text/css">
		.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
		}
	</style>
</head>
<body>
ProductUpdateForm.jsp<br><br>
<div id="wrapper">	
	<form:form commandName="product"  method="post"  action="update.prd"  enctype="multipart/form-data">
		<h1><span>상품 수정 화면</span></h1>
		<p>
		<input type="hidden" name="uploadOld" value="${product.image}">
		
		<input type="hidden" value="${product.num}" name="num">
			<label for="name">*상품명</label>
			<input type="text" name="name" id="name" value="${product.name}">
			<form:errors cssClass="err" path="name" />
		</p>
		<p>
			<label for="company">제조 회사</label>
			<input type="text" name="company" id="company" value="${product.company }">
			<form:errors cssClass="err" path="company" />
		</p>
		<p>
			<label for="price">*가격</label>
			<input type="text" name="price" id="price"  value="${product.price}">
			<form:errors cssClass="err" path="price" />
		</p>	
		<p>
			<label for="stock">재고 수량</label>
			<input type="text" name="stock" id="stock"  value="${product.stock}">
			<form:errors cssClass="err" path="stock" />
		</p>	
		<p>
			<label for="point">적립 포인트</label>
			<input type="text" name="point" id="point" value="${product.point}">
			<form:errors cssClass="err" path="point" />
		</p>	
		<p>
			<label for="contents">*설명</label>
			<input type="text" name="contents" id="contents" value="${product.contents}">
				<form:errors cssClass="err" path="contents" />
		</p>	
		<p>
			<label for="upload">*그림 파일</label>
			<img alt="제품사진" width="80px" height="100px"  src="<%=request.getContextPath()%>/resources/${product.image}">
			<input type="file" name="upload" id="upload" value="">
			<form:errors cssClass="err" path="image" />
		</p>	
		<p>
			<label for="inputdate">입고 일자</label>
			<input type="text" name="inputdate" id="inputdate" value="${product.inputdate}">
		</p>	
		<p class="btnRow">
			<input type="submit" value="수정하기" id="btnSubmit">		
		</p>
	</form:form>
</div>
</body>
</html>
