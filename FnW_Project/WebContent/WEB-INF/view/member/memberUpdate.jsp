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
		<p>id<input type="text" name="id" value=${member.id } readonly="readonly"></p>
		<p>pw<input type="password" name="pw" value=${member.pw } ></p>
		<p>name<input type="text" name="name" value=${member.name } readonly="readonly"></p>
		<p>birth<input type="date" name="birth" value=${member.birth } ></p>
		<p>gender<input type="text" name="gender" value=${member.gender } readonly="readonly"></p>
		<p>addr<input type="text" name="addr" value=${member.addr } ></p>
		<p>phone<input type="text" name="phone" value=${member.phone } ></p>
		<p>email<input type="text" name="email" value=${member.email } ></p>
		<p>library<input type="text" name="library" value=${member.library } ></p>
		<button type="submit">회원정보 수정</button>
		<a href="./memberDelete.member?id=${member.id }"><input type="button" value="회원 탈퇴"></a>
	</form>	
</body>
</html>