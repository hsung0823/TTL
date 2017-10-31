<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>MarketTotalDetails</h2>
	<form action="./index.jsp" method="post">
		<p>num<input type="text" name="id" value=${marketTotal.num }></p>
		<p>title<input type="text" name="pw" value=${marketTotal.title } ></p>
		<p>writer<input type="text" name="name" value=${marketTotal.writer }></p>
		<p>company<input type="date" name="birth" value=${marketTotal.company } ></p>
		<p>publish_date<input type="text" name="gender" value=${marketTotal.publish_date }></p>
		<p>library<input type="text" name="addr" value=${marketTotal.library } ></p>
		<p>price<input type="text" name="phone" value=${marketTotal.price } ></p>
		<p>approval<input type="text" name="email" value=${marketTotal.approval } ></p>
		<button type="submit">확인</button>
	</form>	
</body>
</html>