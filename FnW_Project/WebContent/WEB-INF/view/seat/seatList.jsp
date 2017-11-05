<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#seat_1").click(function(){
			
			$.ajax({
				url: "./seatList.seat",
				type: "POST",
				data: {
					library :1
				},
				success:function(data){
					$("#seatList").html(data.trim());
				}
			});
			
		});//
		
		$("#seat_2").click(function(){
			
			$.ajax({
				url: "./seatList.seat",
				type: "POST",
				data: {
					library :2
				},
				success:function(data){
					$("#seatList").html(data.trim());
				}
			});
			
		});//
		
		$("#seat_3").click(function(){
			
			$.ajax({
				url: "./seatList.seat",
				type: "POST",
				data: {
					library :3
				},
				success:function(data){
					$("#seatList").html(data.trim());
				}
			});
			
		});//
		
		/* $("#seatList").on("click", ".seats" , function(){
			alert("as");
		}); */
		
		
	});
</script>
</head>
<body>

<h2>
<a href="#" id="seat_1">1층 Seat
<c:forEach items="${seat1 }" var="dto" varStatus="count" >
	<c:if test="${count.last }">
		${count.index+1 } 개
	</c:if>
</c:forEach>
</a>
</h2>


<h2>
<a href="#" id="seat_2">2층 Seat
<c:forEach items="${seat2 }" var="dto" varStatus="count" >
	<c:if test="${count.last }">
		${count.index+1 } 개
	</c:if>
</c:forEach>
</a>
</h2>

<h2>
<a href="#" id="seat_3">3층 Seat
<c:forEach items="${seat3 }" var="dto" varStatus="count" >
	<c:if test="${count.last }">
		${count.index+1 } 개
	</c:if>
</c:forEach>
</a>
</h2>

<div id="seatList">
</div>

</body>
</html>