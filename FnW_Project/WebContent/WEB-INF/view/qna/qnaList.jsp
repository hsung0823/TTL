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
<h2>Qna List</h2>
	<table id = "qnaList" border="1">
	<tr>
		<th>num</th>
		<th>title</th>
		<th>date</th>
		<th>writer</th>
		<th>hit</th>
	</tr>
	<c:forEach items="${list }" var="qnaList">
		<tr>
			<td>${qnaList.num }</td>
			<td><a href="./qnaDetailsCheck.qna?num=${qnaList.num }">${qnaList.title }</a></td>
			<td>${qnaList.reg_date }</td>
			<td>${qnaList.writer }</td>
			<td>${qnaList.hit }</td>
		</tr>
	</c:forEach>
	<tr>
	<a href="./qnaWrite.qna"><button>글쓰기</button></a>
	</tr>
	</table>
</body>
</html>