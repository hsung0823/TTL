<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>MarketTotal List</h2>
	<table id = "marketList" class="kind" border="1">
			<tr>
				<th>num</th>
				<th>title</th>
				<th>writer</th>
				<th>company</th>
				<th>publish_date</th>
				<th>library</th>
				<th>price</th>
				<th>id</th>
				<th>wish</th>
				<th>approval</th>
				<th>book_state</th>
			</tr>
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.num }</td>
					<td><a href="./marketTotalView.market?num=${dto.num }">${dto.title }</a></td>
					<td>${dto.writer }</td>
					<td>${dto.company }</td>
					<td>${dto.publish_date }</td>
					<td>${dto.library }</td>
					<td>${dto.price }</td>
					<td>${dto.id }</td>
					<td>${dto.wish }</td>
					<td>${dto.approval }</td>
					<td>${dto.book_state }</td>
				</tr>
			</c:forEach>
		</table>
		
		<div style = "text-align: center;">
			<ul class="pagination pagination-sm">
				<c:if test="${page.curBlock>1}">
				<li><a href = "./marketTotalList.market?curPage=${page.startNum-1}">[이전]</a></li>
				</c:if>
				
				<c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
				<li><a id="pa" href="./marketTotalList.market?curPage=${i}">${i}</a></li>
				</c:forEach>

				<c:if test="${page.curBlock < page.totalBlock}">
				<li><a href="./marketTotalList.market?curPage=${page.lastNum+1}">[다음]</a></li>
				</c:if>
			</ul>
		</div>
</body>
</html>