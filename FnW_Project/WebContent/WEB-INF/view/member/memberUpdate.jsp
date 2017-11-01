<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
		<p>library<input type="number" name="library" value=${member.library } ></p>
		
		<c:if test="${sessionScope.member.kind ne 10 }">
		<p>kind<input type="hidden" name="kind" value=${member.kind }></p>
		</c:if>
		
		<c:if test="${sessionScope.member.kind eq 10 }">
		<%-- <p>kind<input type="number" name="kind" value=${member.kind }></p>  --%>
		
		<select name="kind">
			<option value=10>운영자</option>
			<option value=1 selected="selected">일반</option>
			<option value=0>블랙</option>
		</select>
		</c:if>
		<button type="submit">회원정보 수정</button>
		<a href="./memberDelete.member?id=${member.id }"><input type="button" value="회원 탈퇴"></a>
	</form>	
</body>
</html>