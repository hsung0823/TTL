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
<h2>Book Rent List</h2>
<table class="table" border="1">
		<tr>
			<th>num</th>
			<th>title</th>
			<th>section</th>
			<th>writer</th>
			<th>company</th>
			<th>publish_date</th>
			<th>id</th>
			<th>library</th>
			<th>in_time</th>
			<th>out_time</th>
			<th>late_time</th>
		</tr>
		<c:forEach items="${bookRentList }" var="bookRent_list">
			<tr>
			<td>${bookRent_list.num }</td>
 				<td><a href="./bookOrderDetails.book?num=${bookRent_list.num }">${bookRent_list.title }</a></td>
 				<td>${bookRent_list.section }</td>
				<td>${bookRent_list.writer }</td>
				<td>${bookRent_list.company }</td>
				<td>${bookRent_list.publish_date }</td>
				<td>${bookRent_list.id }</td>
				<td>${bookRent_list.library }</td>
				<td>${bookRent_list.in_time }</td>
				<td>${bookRent_list.out_time }</td>
				<td>${bookRent_list.late_date }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>