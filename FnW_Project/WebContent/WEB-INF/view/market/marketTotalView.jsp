<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			location.href="./marketBuy.market?num=${dto.num}";
		});
	});

</script>
</head>
<body>
	<h2>Market View</h2>
	
	<table id = "marketList" class="kind" border="1">
			<tr>
				<th>num</th>
				<th>title</th>
				<th>writer</th>
				<th>company</th>
				<th>publish_date</th>
				<th>library</th>
				<th>price</th>
				<th>id</th>
				<th>wish</th>
				<th>approval</th>
				<th>book_state</th>
				<th>buy</th>
			</tr>
				<tr>
					<td>${dto.num }</td>
					<td>${dto.title }</td>
					<td>${dto.writer }</td>
					<td>${dto.company }</td>
					<td>${dto.publish_date }</td>
					<td>${dto.library }</td>
					<td>${dto.price }</td>
					<td>${dto.id }</td>
					<td>${dto.wish }</td>
					<td>${dto.approval }</td>
					<td>${dto.book_state }</td>
					<td><input type="button" id="btn" value="구매하기"></td>
				</tr>
		</table>
</body>
</html>