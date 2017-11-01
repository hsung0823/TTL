<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>memberJoinForm</h1>

<form action="./memberJoin.member" method="post">
	<p>id<input type="text" name="id"></p>
	<p>pw<input type="text" name="pw"></p>
	<p>name<input type="text" name="name"></p>
	<p>birth<input type="date" name="birth"></p>
	<p>gender<input type="text" name="gender"></p>
	<p>addr<input type="text" name="addr"></p>
	<p>phone<input type="text" name="phone"></p>
	<p>email<input type="text" name="email"></p>
	<p>library<input type="number" name="location"></p>
<!-- 	<p>kind<input type="number" name="kind"></p> -->
	<p><button type="submit">join</button></p>
</form>

</body>
</html>