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
	<h2>SeatTotalList</h2>
	<table class="table" border="1">
		<tr>
			<th>num</th>
			<th>seat_num</th>
			<th>library</th>
			<th>in_time</th>
			<th>out_time</th>
			<th>state</th>
		</tr>
		<c:forEach items="${seatList }" var="seatTotal_list">
			<tr>
			<td>${seatTotal_list.num }</td>
				<td>${seatTotal_list.seat_num }</td>
				<td>${seatTotal_list.library }</td>
				<td>${seatTotal_list.in_time }</td>
				<td>${seatTotal_list.out_time }</td>
				<td>${seatTotal_list.state }</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<ul class="pagination">
			<c:if test="${page.curBlock>1}">
			<li><button class="go" id="${page.startNum-1}">[이전]</button></li>
			</c:if>
			<c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
			<li><a
				href="./seatTotalList.seat?curPage=${i}&id=${id }">${i}</a></li>
			</c:forEach>
			<c:if test="${page.curBlock < page.totalBlock}">
			<li><a
				href="./seatTotalList.seat?curPage=${requestScope.page.lastNum+1}">[다음]</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>