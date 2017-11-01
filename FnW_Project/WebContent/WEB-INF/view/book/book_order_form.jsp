<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h3>Book_Order_Form</h3>
	<form action="">
		<table class = "table">
			<tr>
				<td>서명</td>
				<td><input type = "text" class = "form-control" name = "title"></td>
				<td>저자</td>
				<td><input type = "text" class = "form-control" name = "writer"></td>
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type = "text" class = "form-control" name = "company"></td>
				<td>출판년도</td>
				<td><input type = "text" class = "form-control" name = "publish_date" placeholder = "출판년도는 숫자만 입력해 주세요"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type = "text" class = "form-control" name = "price"></td>
				<td>비고</td>
				<td><input type = "textarea" class = "form-control" name = "contents"></td>
			</tr>
			
		</table>
	</form>

</body>
</html>