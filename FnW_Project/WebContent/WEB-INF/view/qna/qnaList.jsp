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
<h2>Qna List</h2>
	<div>
		<form name="frm" class="form-inline" action="./qnaList.qna"
			method="post">
			<div>
				<span> <select name="kind">
						<option value="title">제목</option>
						<option value="writer">저자</option>
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
	<table id = "qnaList" border="1">
	<tr>
		<th>num</th>
		<th>title</th>
		<th>date</th>
		<th>writer</th>
		<th>hit</th>
	</tr>
	<c:forEach items="${list }" var="qnaList">
		<tr>
			<td>${qnaList.num }</td>
			<td><a href="./qnaDetailsCheck.qna?num=${qnaList.num }">${qnaList.title }</a></td>
			<td>${qnaList.reg_date }</td>
			<td>${qnaList.writer }</td>
			<td>${qnaList.hit }</td>
		</tr>
	</c:forEach>
	<tr>
	<a href="./qnaWrite.qna"><input type="button" value="글쓰기"></a>
	</tr>
	</table>
	<div style = "text-align: center;">
			<ul class="pagination pagination-sm">
				<c:if test="${page.curBlock>1}">
				<li><a href = "./qnaList.qna?curPage=${page.startNum-1}">[이전]</a></li>
				</c:if>
				
				<c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
				<li><a id="pa" href="./qnaList.qna?curPage=${i}&kind=${kind}&search=${search}">${i}</a></li>
				</c:forEach>

				<c:if test="${page.curBlock < page.totalBlock}">
				<li><a href="./qnaList.qna?curPage=${page.lastNum+1}">[다음]</a></li>
				</c:if>
			</ul>
		</div>
</body>
</html>