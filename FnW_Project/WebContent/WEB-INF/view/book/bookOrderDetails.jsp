<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>Book Rent Details</h2>
<form action="../index.jsp" method="post">
		<p>num<input type="text" name="num" value=${bookRentDTO.num }></p>
		<p>title<input type="text" name="title" value=${bookRentDTO.title } ></p>
		<p>section<input type="date" name="section" value=${bookRentDTO.section } ></p>
		<p>writer<input type="text" name="writer" value=${bookRentDTO.writer }></p>
		<p>publish_date<input type="text" name="publish_date" value=${bookRentDTO.publish_date }></p>
		<p>id<input type="text" name="id" value=${bookRentDTO.id }></p>
		<p>library<input type="text" name="library" value=${bookRentDTO.library } ></p>
		<p>in_time<input type="text" name="in_time" value=${bookRentDTO.in_time } ></p>
		<p>out_time<input type="text" name="out_time" value=${bookRentDTO.out_time } ></p>
		<p>late_date<input type="text" name="late_date" value=${bookRentDTO.late_date } ></p>
		<button type="submit">확인</button>
		<a href="./bookRentDelete.book?num=${bookRentDTO.num }"><input type="button" value="내역 삭제"></a>
	</form>	
</body>
</html>