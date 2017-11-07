<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Total Library Page</title>
</head>

<body>

<h1>QnA List Service</h1>
<p><a href="./qna/qnaList.qna">QnaList</a></p>

	<c:if test="${not empty sessionScope.member }">
	<h1>${sessionScope.member.id }</h1>
	<h1>MyPage_Hees</h1>
	<p><a href="./member/memberUpdatePwCheck.member">업데이트</a></p>
	<p><a href="./market/marketDealsList.market?id=${member.id }">Market Order List</a></p>
	<p><a href="./seat/seatTotalList.seat?id=${member.id }">Seat Rent List</a></p>
	<p><a href="./book/bookRentList.book?id=${member.id }">Book Rent List</a></p>
	<p><a href="./book/bookOrderList.book?id=${member.id }">Book Order List</a></p>
	<p><a href="./book/bookOrderWishList.book?id=${member.id }">Basket Book Order List</a></p>
	<p><a href="./book/bookRentWishList.book?id=${member.id }">Basket Book Rent List</a></p>
	</c:if>

	<h2>김앤신(통합포털)</h2>
	<p><a href="./book/bookTotalSearch.book">Book_search</a>
	<p><a href="./book/bookOrderTotalList.book">Book_Order(도서 신청)</a>
	<p><a href="./member/memberLogin.member">로그인</a>
	<p><a href="./member/memberJoin.member">회원가입</a>
	<p><a href="./member/memberLogout.member">로그아웃</a>
	<p><a href="./library/libraryView.library">도서관지도</a></p>
	
	<p></p>
	<!-- 도서관 페이지  -->
	<h2>도서관 페이지</h2>
	<p><a href="./library/libraryMain.library">Library_Main_Page</a></p>
	<div style = "height: 10px"></div>
	
	<p><a href="./member/memberList.member">admin 전용 회원리스트 / 블랙리스트</a></p>

	<p><a href="./member/memberIdFind.member">Id Find</a>
	<p><a href="./member/memberPwFind.member">Pw Find</a>
	<p><a href="./member/memberJoinAgree.member">Join Agree</a></p>
	<p>=================================================</p>
	<c:if test="${not empty sessionScope.member }">
	<p><a href="./market/marketDealForm.market?id=${member.id }">마켓판매신청form</a></p><!-- 로그인시만 이용 -->
	<p><a href="./market/marketDealList_personal.market?id=${member.id }">마켓판매신청 개인확인용</a></p><!-- 로그인시만 이용 -->
	</c:if>
	<p>=================================================</p>
	마켓 관리자 승인용
	<c:if test="${not empty member and member.kind eq 10}">
	<p><a href="./market/marketApplicationList.market?id=${member.id }">마켓신청List 관리자용(승인용)</a></p><!--관리자로그인시만 이용 -->
	</c:if>
	
	<p><a href="./notice/noticeList.notice">공지사항</a></p>

	
	<p><a href="./seat/seatList.seat">Seat List</a></p>
	<p><a href="./market/marketTotalList.market">Market Total List</a></p>
	<c:if test="${empty sessionScope.member }">
		login plz
	</c:if>

	<c:if test="${sessionScope.member.kind eq 10 }">
		admin page
	</c:if>

</body>
</html>