<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>bookDealsDetailDetails</h2>
	<form action="../index.jsp" method="post">
		<p>num<input type="text" name="num" value=${bookDealsDetail.num }></p>
		<p>title<input type="text" name="title" value=${bookDealsDetail.title } ></p>
		<p>writer<input type="text" name="writer" value=${bookDealsDetail.writer }></p>
		<p>company<input type="date" name="company" value=${bookDealsDetail.company } ></p>
		<p>publish_date<input type="text" name="publish_date" value=${bookDealsDetail.publish_date }></p>
		<p>t_date<input type="text" name="t_date" value=${bookDealsDetail.t_date }></p>
		<p>price<input type="text" name="price" value=${bookDealsDetail.price } ></p>
		<p>library<input type="text" name="library" value=${bookDealsDetail.library } ></p>
		<p>kind<input type="text" name="kind" value=${bookDealsDetail.kind } ></p>
		<p>state<input type="text" name="state" value=${bookDealsDetail.state } ></p>
		<p>delivery<input type="text" name="delivery" value=${bookDealsDetail.delivery } ></p>
		<button type="submit">확인</button>
		<a href="./marketDealsDelete.market?num=${bookDealsDetail.num }"><input type="button" value="내역 삭제"></a>
	</form>	
</body>
</html>