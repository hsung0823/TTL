<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Member Update</h2>
	
<form action="./memberUpdate.member" method="post">
	<p>id<input type="text" name="id" value=${dto.id } readonly="readonly"></p>
	<p>pw<input type="text" name="pw" value=${dto.pw } ></p>
	<p>name<input type="text" name="name" value=${dto.name } ></p>
	<p>birth<input type="date" name="birth" value=${dto.birth } ></p>
	<p>gender<input type="text" name="gender" value=${dto.gender } ></p>
	<p>addr<input type="text" name="addr" value=${dto.addr } ></p>
	<p>phone<input type="text" name="phone" value=${dto.phone } ></p>
	<p>email<input type="text" name="email" value=${dto.email } ></p>
	<p>location<input type="text" name="location" value=${dto.location } ></p>
	<p>kind<input type="number" name="kind" value=${dto.kind } ></p>
	<button type="submit">update</button>
	<a href="./memberList.member"><input type="button" value="list"></a>
</form>	
</body>
</html>