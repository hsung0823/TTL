<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Book Information</title>
<!-- <!-- <script type="text/javascript"> -->
	
<!-- // $(function(){ -->
<!-- // 	var check = false; -->
	
<!-- // 	$("#btn").click(function() { -->
		
<!-- // 		$ajax({ -->
<!-- // 			url: "./bookRent.book?num=", -->
<!-- // 			type: "GET", -->
<!-- // 			data: { -->
<%-- // 				num:${book.num}, --%>
<!-- // 				result:result -->
<!-- // 			}, -->
<!-- // 			success: function(data) { -->
<!-- // 				alert(data); -->
<!-- // 			} -->
<!-- // 		}); -->
<!-- // 	}); -->
<!-- // }); -->

<!-- <!-- </script> --> 

</head>
<body>
	<h2>책 상세정보 페이지</h2>
	<div style = "height: 30px"></div>
	<section>
		<form action="./bookRent.book?num=${ book.num }&rent_id=${member.id}">
			<table class="table">
				<tr>
					<td>번호</td>
					<td>서명</td>
					<td>저자</td>
					<td>출판사</td>
					<td>출판년도</td>
					<td>도서위치</td>
					<td>대여여부</td>
				</tr>
				<tr>
					<td>${ book.num }</td>
					<td>${ book.title }</td>
					<td>${ book.writer }</td>
					<td>${ book.company }</td>
					<td>${ book.publish_date }</td>
					<td>${ book.section }</td>
					<c:choose>
						<c:when test="${ book.state == 0 and not empty member }">
							<td><button class = "btn btn-default" type = "submit" id = "btn">대여</button></td>
						</c:when>
						<c:when test="${ book.state == 1 }">
							<td>대여불가</td>
						</c:when>
					</c:choose>
				</tr>
			</table>
		</form>

	</section>

</body>
</html>