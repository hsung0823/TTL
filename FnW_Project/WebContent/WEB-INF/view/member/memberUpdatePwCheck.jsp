<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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