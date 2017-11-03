<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
</head>
<body>
	<h2>MarketTotalList-MyPage</h2>
	<div>
		<form name="frm" class="form-inline" action="./bookOrderList.book"
			method="post">
			<div>
				<span> <select name="kind">
						<option value="title">제목</option>
						<option value="writer">저자</option>
						<option value="company">출판사</option>
				</select> <input type="text" class="form-control" id="search"
					placeholder="Enter" name="search">
				</span>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" class="btn btn-default" value="Search">
					</div>
				</div>
			</div>
		</form>
	</div>
	<h2>Book Order List-Book_Order</h2>
	<table class="table" border="1">
		<tr>
			<th>num</th>
			<th>title</th>
			<th>writer</th>
			<th>company</th>
			<th>publish_date</th>
			<th>price</th>
			<th>library</th>
			<th>state</th>
			<th>cancel</th>
		</tr>
		<c:forEach items="${bookOrderList }" var="bookOrder_list">
			<tr>
				<td>${bookOrder_list.num }</td>
				<td><a
					href="./bookOrderDetails.book?num=${bookOrder_list.num }">${bookOrder_list.title }</a></td>
				<td>${bookOrder_list.writer }</td>
				<td>${bookOrder_list.company }</td>
				<td>${bookOrder_list.publish_date }</td>
				<td>${bookOrder_list.price }</td>
				<td>${bookOrder_list.library }</td>
				<td>${bookOrder_list.state }</td>
				<c:if test="${bookOrder_list.state ne 2 }">
					<td>${bookOrder_list.cancel }</td>
				</c:if>
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
					href="./bookOrderList.book?curPage=${i}&id=${id }&kind=${kind}&search=${search}">${i}</a></li>
			</c:forEach>
			<c:if test="${page.curBlock < page.totalBlock}">
				<li><a
					href="./bookOrderList.book?curPage=${requestScope.page.lastNum+1}">[다음]</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>