<%@page import="com.fnw.notice.NoticeDTO"%>
<%@page import="com.fnw.notice.NoticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-8 col-centered">
		<table class="table">
			<tr>
				<td colspan="2">
					<%-- 글 제목 --%>${requestScope.view.title}</td>
				<td colspan="2">
					<!-- blank -->
				</td>
				<td id="reg_date">
					<!-- 날짜 -->${requestScope.view.reg_date}</td>
				<td id="hit">
					<!-- 조회수 -->조회수: ${requestScope.view.hit}</td>
			</tr>
			<tr>
				<td colspan="5">
					<!-- blank -->
				</td>
				<td id="writer">
					<!-- 작성자 -->작성자: ${requestScope.view.writer}</td>
			</tr>
			<tr>
				<td colspan="6" id="contents">
					<!-- contents 내용 -->${requestScope.view.contents}</td>
			</tr>
		</table>
	</div>
	
	
	<c:if test="${member.id eq view.writer }">
		<a href="./${requestScope.notice}Update.${requestScope.notice}?num=${requestScope.view.num}">UPDATE</a>
		<a href="./${requestScope.notice}Delete.${requestScope.notice}?num=${requestScope.view.num}">DELETE</a>
	</c:if>
	<a href="./${requestScope.notice}List.${requestScope.notice}">LIST</a>
</body>
</html>