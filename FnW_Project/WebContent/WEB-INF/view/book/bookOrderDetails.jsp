<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>Book Order Details</h2>
	<form action="../index.jsp" method="post">
		<p>num<input type="number" name="num" value=${bookOrderDetails.num }></p>
		<p>title<input type="text" name="title" value=${bookOrderDetails.title } ></p>
		<p>writer<input type="text" name="writer" value=${bookOrderDetails.writer }></p>
		<p>company<input type="text" name="company" value=${bookOrderDetails.company }></p>
		<p>publish_date<input type="text" name="publish_date" value=${bookOrderDetails.publish_date }></p>
		<p>contents<input type="text" name="contents" value=${bookOrderDetails.contents }></p>
		<p>id<input type="text" name="id" value=${bookOrderDetails.id }></p>
		<p>price<input type="text" name="price" value=${bookOrderDetails.price }></p>
		<p>library<input type="text" name="library" value=${bookOrderDetails.library } ></p>
		<p>state<input type="text" name="state" value=${bookOrderDetails.state } ></p>
		<c:if test="${bookOrderDetails.state ne 2 }">
		<p>cancel<input type="text" name="cancel" value=${bookOrderDetails.cancel } ></p>
		</c:if>
		<button type="submit">확인</button>
		<c:if test="${bookOrderDetails.state eq 2 }">
		<a href="./bookOrderUpdate.book?num=${bookOrderDetails.num }"><input type="button" value="정보 수정"></a>
		<a href="./bookOrderDelete.book?num=${bookOrderDetails.num }"><input type="button" value="신청 취소"></a>
		</c:if>
	</form>	
</body>
</html>