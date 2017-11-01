<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyPage</title>
</head>
<body>
	<c:if test="${not empty sessionScope.member }">
	<h1>${sessionScope.member.id }</h1>
	<h1>MyPage_Hees</h1>
	<p><a href="./member/memberUpdatePwCheck.member">MyPage Update O</a></p>
	<p><a href="./market/bookDealsList.market?id=${member.id }">Market Order List O</a></p>
	<p><a href="./seat/seatTotalList.seat?id=${member.id }">Seat Rent List O</a></p>
	<p><a href="./book/bookRentList.book">Book Rent List</a></p>
	</c:if>

	
	<h2>kim</h2>
	<p><a href="./member/memberLogin.member">login</a>
	<p><a href="./member/memberJoin.member">Join</a>
	<p><a href="./member/memberLogout.member">Logout</a>
	<p><a href="./member/memberList.member">admin 전용 회원리스트 / 블랙리스트</a></p>
	
	
	<c:if test="${empty sessionScope.member }">
		login plz
	</c:if>
	
</body>
</html>