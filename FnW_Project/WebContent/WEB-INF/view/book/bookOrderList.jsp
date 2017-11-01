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
<h2>Book Order List-Book_Order</h2>
<table class="table" border="1">
		<tr>
			<th>num</th>
			<th>title</th>
			<th>writer</th>
			<th>company</th>
			<th>publish_date</th>
			<th>price</th>
			<th>library</th>
			<th>state</th>
			<th>cancle</th>
		</tr>
		<c:forEach items="${bookOrderList }" var="bookOrder_list">
			<tr>
			<td>${bookOrder_list.num }</td>
 				<td><a href="./bookOrderDetails.book?num=${bookOrder_list.num }">${bookOrder_list.title }</a></td>
				<td>${bookOrder_list.writer }</td>
				<td>${bookOrder_list.company }</td>
				<td>${bookOrder_list.publish_date }</td>
				<td>${bookOrder_list.price }</td>
				<td>${bookOrder_list.library }</td>
				<td>${bookOrder_list.state }</td>
				<td>${bookOrder_list.cancle }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>