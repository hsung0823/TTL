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
	<p><a href="./member/memberUpdatePwCheck.member">MyPage Update</a></p>
	<p><a href="./market/marketDealsList.market?id=${member.id }">Market Order List</a></p>
	<p><a href="./seat/seatTotalList.seat?id=${member.id }">Seat Rent List</a></p>
	<p><a href="./book/bookRentList.book?id=${member.id }">Book Rent List</a></p>
	<p><a href="./book/bookOrderList.book?id=${member.id }">Book Order List</a></p>
	<p><a href="./book/bookOrderWishList.book?id=${member.id }">Basket Book Order List</a></p>
	<p><a href="./book/bookRentWishList.book?id=${member.id }">Basket Book Rent List</a></p>
	<p><a href="./seat/seatList.seat">Seat_On List</a></p>
	</c:if>

	<h2>김앤신(통합포털)</h2>
	<p><a href="./book/bookTotalSearch.book">Book_search</a>
	<p><a href="./member/memberLogin.member">Login</a>
	<p><a href="./member/memberJoin.member">Join</a>
	<p><a href="./member/memberLogout.member">Logout</a>
	<p><a href="./library/libraryView.library">도서관지도</a></p>
	<p><a href="./member/memberList.member">admin 전용 회원리스트 / 블랙리스트</a></p>

	<p><a href="./member/memberIdFind.member">Id Find</a>
	<p><a href="./member/memberPwFind.member">Pw Find</a>

	<c:if test="${empty sessionScope.member }">
		login plz
	</c:if>

	<c:if test="${sessionScope.member.kind eq 10 }">
		admin page
	</c:if>

</body>
</html>