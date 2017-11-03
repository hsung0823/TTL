<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Update Pw Check</title>
</head>
<body>
<h2>Update Pw Check</h2>
<form action="./memberUpdatePwCheck.member" method="post">
<p>ID<input type="text" name="id" value=${member.id } readonly="readonly"></p>
<p>Password<input type="password" name="pw"></p>
<button type="submit">확인</button>
</form>	
</body>
</html>