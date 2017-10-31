<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>MarketTotalList</h2>
<table class="table" border="1">
		<tr>
			<th>title</th>
			<th>writer</th>
			<th>company</th>
			<th>publish_date</th>
			<th>price</th>
			<th>id</th>
			<th>library</th>
			
		</tr>
		<c:forEach items="${marketTotal }" var="mTotal_list">
			<tr>
				<td>${mTotal_list.title }</td>
				<td>${mTotal_list.writer }</td>
				<td>${mTotal_list.company }</td>
				<td>${mTotal_list.publish_date }</td>
				<td>${mTotal_list.price }</td>
				<td>${mTotal_list.id }</td>
				<td>${mTotal_list.library }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>