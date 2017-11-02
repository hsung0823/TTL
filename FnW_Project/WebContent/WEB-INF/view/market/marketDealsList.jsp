<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>MarketTotalList</h2>


	<table class="table" border="1">
		<tr>
			<th>num</th>
			<th>title</th>
			<th>writer</th>
			<th>company</th>
			<th>publish_date</th>
			<th>T_date</th>
			<th>library</th>
			<th>price</th>
			<th>state</th>
			<th>delivery</th>
		</tr>
		<c:forEach items="${bookDeals }" var="bookDeals_list">
			<tr>
				<td>${bookDeals_list.num }</td>
				<td><a
					href="./marketDealsDetails.market?num=${bookDeals_list.num }">${bookDeals_list.title }</a></td>
				<td>${bookDeals_list.writer }</td>
				<td>${bookDeals_list.company }</td>
				<td>${bookDeals_list.publish_date }</td>
				<td>${bookDeals_list.t_date }</td>
				<td>${bookDeals_list.library }</td>
				<td>${bookDeals_list.price }</td>
				<td>${bookDeals_list.state }</td>
				<td>${bookDeals_list.delivery }</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<ul class="pagination">
			<c:if test="${page.curBlock>1}">
			<li><button class="go" id="${page.startNum-1}">[이전]</button></li>
			</c:if>
			<c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
			<li><a
				href="./${requestScope.board}List.${requestScope.board}?curPage=${i}">${i}</a></li>
			</c:forEach>
			<c:if test="${page.curBlock < page.totalBlock}">
			<li><a
				href="./${requestScope.board}List.${requestScope.board}?curPage=${requestScope.page.lastNum+1}">[다음]</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>