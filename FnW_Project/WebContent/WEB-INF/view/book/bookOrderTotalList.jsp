<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstdapcdn.com/bootstdap/3.3.7/css/bootstdap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstdapcdn.com/bootstdap/3.3.7/js/bootstdap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<h3>Book_Order_Total_List</h3>
	<div style = "height: 50px"></div>
	
	<section>
	
		<form action="">
			<table class = "table">
				<tr>
					<td>번호</td>
					<td>서명</td>
					<td>저자</td>
					<td>출판사</td>
					<td>신청인</td>
					<td>처리상태</td>
				</tr>
		<c:forEach items="${bookOrderList}" var="bookOrder_list">
			<tr>
			<td>${bookOrder_list.num }</td>
 				<td><a href="./bookOrderTotalList.book?num=${bookOrder_list.num }">${bookOrder_list.title }</a></td>
				<td>${bookOrder_list.num}</td>
				<td>${bookOrder_list.title}</td>
				<td>${bookOrder_list.writer}</td>
				<td>${bookOrder_list.company}</td>
				<td>${bookOrder_list.id}</td>
				<c:if test="${bookOrder_list.state ne 1}">
					<td>대기</td>
				</c:if>
				<c:if test="${bookOrder_list.state ne 0 }">
					<td>완료</td>
				</c:if>
			</tr>
		</c:forEach>
			</table>
		</form>

		<form action="./bookOrderForm.book">
			<button style = "float: right;" class = "btn btn-default" type = "submit">신청하기</button>		
		</form>
		
	</section>

</body>
</html>