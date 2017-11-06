<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">

	$(function() {
		var library = ${member.library}
	});

</script>
</head>
<body>
	<h3>마켓신청form</h3>
	<div style = "height: 50px"></div>
	<form action="./marketDealForm.market" method="post">
		<input type = "hidden" class = "form-control" name = "id" value = ${member.id}>
		<table class = "table">
			<tr>
				<td>책제목</td>
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
				<td>정가</td>
				<td><input type = "text" class = "form-control" name = "price"></td>
			</tr>
			<tr>
				<td>도서관명</td>
				<td><select name = "library">
					<option value = "1" id = "1">기흥구</option>
					<option value = "2" id = "2">송파구</option>
					<option value = "3" id = "3">장안구</option>
					<option value = "4" id = "4">강남구</option>
					<option value = "5" id = "5">분당구</option>
				</select></td>
			</tr>
		</table>
		<button style = "float: right;" class = "btn btn-default" type = "submit">CONFIRM</button>
	</form>

</body>
</html>