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
<h2>Admin List</h2>
	<table class="table" border="1">
		<tr>
			<th>id</th>
			<th>pw</th>
			<th>name</th>
			<th>birth</th>
			<th>gender</th>
			<th>addr</th>
			<th>phone</th>
			<th>email</th>
			<th>library</th>
			<th>kind</th>
		</tr>
		<c:forEach items="${list }" var="dto">
			<c:if test="${dto.kind == 10 }">
			<tr>
				<td><a href="./memberUpdate.member?id=${dto.id }">${dto.id }</a></td>
				<td>${dto.pw }</td>
				<td>${dto.name }</td>
				<td>${dto.birth }</td>
				<td>${dto.gender }</td>
				<td>${dto.addr }</td>
				<td>${dto.phone }</td>
				<td>${dto.email }</td>
				<td>${dto.library }</td>
				<td>${dto.kind }</td>
			</tr>
			</c:if>
		</c:forEach>
	</table>


<h2>Member All List</h2>
	<table class="table" border="1">
		<tr>
			<th>id</th>
			<th>pw</th>
			<th>name</th>
			<th>birth</th>
			<th>gender</th>
			<th>addr</th>
			<th>phone</th>
			<th>email</th>
			<th>library</th>
			<th>kind</th>
		</tr>
		<c:forEach items="${list }" var="dto">
			<c:if test="${dto.kind <10 }">
			<tr>
				<td><a href="./memberUpdate.member?id=${dto.id }">${dto.id }</a></td>
				<td>${dto.pw }</td>
				<td>${dto.name }</td>
				<td>${dto.birth }</td>
				<td>${dto.gender }</td>
				<td>${dto.addr }</td>
				<td>${dto.phone }</td>
				<td>${dto.email }</td>
				<td>${dto.library }</td>
				<td>${dto.kind }</td>
			</tr>
			</c:if>
		</c:forEach>
	</table>
	
	<h2>BlackList</h2>
	<table class="table" border="1">
		<tr>
			<th>id</th>
			<th>pw</th>
			<th>name</th>
			<th>birth</th>
			<th>gender</th>
			<th>addr</th>
			<th>phone</th>
			<th>email</th>
			<th>library</th>
			<th>kind</th>
		</tr>
		<c:forEach items="${list }" var="dto">
			<c:if test="${dto.kind eq 0 }">
				<tr>
					<td><a href="./memberUpdate.member?id=${dto.id }">${dto.id }</a></td>
					<td>${dto.pw }</td>
					<td>${dto.name }</td>
					<td>${dto.birth }</td>
					<td>${dto.gender }</td>
					<td>${dto.addr }</td>
					<td>${dto.phone }</td>
					<td>${dto.email }</td>
					<td>${dto.library }</td>
					<td>${dto.kind }</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<a href="../index.jsp">home</a>
</body>
</html>