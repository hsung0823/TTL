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
<form action="./qnaWrite.qna" method="post">
		<p>num<input type="text" name="num"></p>
		<p>type<input type="text" name="type"></p>
		<p>title<input type="text" name="title"></p>
		<p>contents<input type="text" name="contents"></p>
		<p>writer<input type="text" name="writer"></p>
		<p>date<input type="date" name="date"></p>
		<p>hit<input type="text" name="hit"></p>
		<p>kind<input type="text" name="kind"></p>
		<button type="submit">확인</button>
</form>	
</body>
</html>