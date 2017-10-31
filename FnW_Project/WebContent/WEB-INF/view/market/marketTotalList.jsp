<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>MarketTotalList</h2>
	<table class="table" border="1">
		<tr>
			<th>num</th>
			<th>title</th>
			<th>writer</th>
			<th>company</th>
			<th>publish_date</th>
			<th>library</th>
			<th>price</th>
			<th>approval</th>
		</tr>
		<c:forEach items="${marketTotal }" var="mTotal_list">
			<tr>
			<td>${mTotal_list.num }</td>
				<td>${mTotal_list.title }</td>
				<td>${mTotal_list.writer }</td>
				<td>${mTotal_list.company }</td>
				<td>${mTotal_list.publish_date }</td>
				<td>${mTotal_list.library }</td>
				<td>${mTotal_list.price }</td>
				<td>${mTotal_list.approval }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>