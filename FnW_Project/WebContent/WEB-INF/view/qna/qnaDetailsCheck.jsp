<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>QnA Details</h2>
<form action="./qnaDetailsCheck.qna" method="post">
		<p>num<input type="text" name="num" value=${num }></p>
		<p>pw<input type="text" name="pw"></p>
		<input type="submit" value="확인"> 
	</form>	
</body>
</html>