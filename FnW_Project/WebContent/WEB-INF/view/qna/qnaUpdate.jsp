<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>QnA Details</h2>
<form action="./qnaUpdate.qna" method="post">
		<p>num<input type="text" name="num" value=${qnaDTO.num }></p>
		<p>type<input type="text" name="type" value=${qnaDTO.type } ></p>
		<p>title<input type="text" name="title" value=${qnaDTO.title } ></p>
		<p>contents<input type="text" name="contents" value=${qnaDTO.contents }></p>
		<p>writer<input type="text" name="writer" value=${qnaDTO.writer }></p>
		<p>date<input type="text" name="date" value=${qnaDTO.reg_date }></p>
		<p>hit<input type="text" name="hit" value=${qnaDTO.hit } ></p>
		<p>kind<input type="text" name="kind" value=${qnaDTO.kind } ></p>
		<button type="submit">확인</button>
</form>	
</body>
</html>