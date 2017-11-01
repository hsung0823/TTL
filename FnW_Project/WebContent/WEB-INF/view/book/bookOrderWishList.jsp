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
			<th>publish_date</th>
			<th>library</th>
			<th>price</th>
			<th></th>
			<th>state</th>
		</tr>
		<c:forEach items="${bookOrderWishList }" var="bookOrderWish_list">
			<tr>
			<td>${bookOrderWish_list.num }</td>
 				<td>${bookOrderWish_list.title }</td>
				<td>${bookOrderWish_list.writer }</td>
				<td>${bookOrderWish_list.publish_date }</td>
				<td>${bookOrderWish_list.library }</td>
				<td>${bookOrderWish_list.price }</td>
				<td><a href="./bookOrderWishDelete.book?num=${bookOrderWish_list.num }"><input type="button" value="삭제"></a></td>
				<c:if test="${bookOrderWish_list.state eq 2 }">
				<td><a href=""><input type="button" value="대여"></a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>