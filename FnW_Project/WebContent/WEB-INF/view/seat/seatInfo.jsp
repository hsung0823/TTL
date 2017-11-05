<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		/* $("#btn").click(function(){
			
			$.ajax({
				url: "./seatInfo.seat",
				type: "POST",
				data: {
					state: '${seat.state }',
					id : '${member.id }',
					seat_num : '${seat.seat_num }'
				},
				success:function(data){
					
				}
			});
		});// */
	});
</script>
</head>
<body>
<p>seat Info</p>
<table border="1">
	<tr>
		<th>Seat_Num</th>
		<th>Library</th>
		<th>State</th>
		<th>Id</th>
		<th>Time</th>
	</tr>
	<tr>
		<td>${seat.seat_num }</td>
		<td>${seat.library }</td>
		<td>${seat.state }</td>
		<td>${seat.id }</td>
		<td>${seat.reserve_time }</td>
	</tr>
</table>
<form action="./seatInfo.seat" method="post">
	<input type="hidden" name="seat_num" value=${seat.seat_num }>
	<input type="hidden" name="id" value=${member.id }>
	<!-- <input type="button" id="btn" value="예약하기"> -->
	<button type="submit"> 예약</button>
</form>

</body>
</html>