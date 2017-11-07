<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">

 $(function(){
	 var kind = '${kind}';
	 $(".kind").each(function(){
		 if($(this).val() == kind) {
			 $(this).attr("selected", true);
		 }
	 });
	 
 });

</script>
</head>
<body>

	<h3>Integration_Book_Search_Page</h3>
	<section>

		<div class="row-right">
			<form name="frm" class="form-inline" action="./bookTotalSearch.book" method="post">
					<!-- KIND -->
					<div class="form-group">
						<div class="col-sm-10">
							<select name="kind" id = "kind">
								<option class = "kind" value="title">제목</option>
								<option class = "kind" value="writer">저자</option>
								<option class = "kind" value="company">출판사</option>
							</select>
						</div>
					</div>

					<!-- SEARCH -->
					<div class="form-group">
						<div class="col-sm-10">
							<input type="text" class="form-control" id="search" placeholder="Enter" name="search" value = "${search}">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" id = "search" class="btn btn-default" value="Search">
						</div>
					</div>
			</form>
		
			<form action="#"> <!-- 대여하기 -->
				<table class = "table">
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>저자</td>
						<td>출판사</td>
						<td>비치 도서관</td>
						<td>대여여부</td>
					</tr>
					<c:forEach items="${ list }" var="dto">
							<tr>
								<td>${dto.num }</td>
								<td><a href="./bookInformation.book?num=${dto.num}">${dto.title }</a></td>
								<td>${dto.writer }</td>
								<td>${dto.company }</td>
	
								<c:choose>
									<c:when test="${dto.library == 1 }"><td>kim_lib</td></c:when>
									<c:when test="${dto.library == 2 }"><td>gee_lib</td></c:when>
									<c:when test="${dto.library == 3 }"><td>hs_lib</td></c:when>
									<c:when test="${dto.library == 4 }"><td>ssin_lib</td></c:when>
								</c:choose>
								
								<c:choose>
									<c:when test="${ dto.state == 0 and not empty member }">
										<td><button class = "btn btn-default" type = "submit" id = "btn">대여</button></td>
									</c:when>
									<c:when test="${ dto.state == 0 and empty member }">
										<td>대여가능</td>
									</c:when>
									<c:when test="${ dto.state == 1 }">
										<td>대여불가</td>
									</c:when>
								</c:choose>
							</tr>
					</c:forEach>
				</table>
			</form>

		</div>

		<div style = "text-align: center;">
			<ul class="pagination pagination-sm">
				<c:if test="${page.curBlock>1}">
				<li><a href = "./bookTotalSearch.book?curPage=${page.startNum-1}&search=${search}&kind=${kind}">[이전]</a></li>
				</c:if>
				
				<c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
				<li><a
					href="./bookTotalSearch.book?curPage=${i}&search=${search}&kind=${kind}">${i}</a></li>
				</c:forEach>
				
				<c:if test="${page.curBlock < page.totalBlock}">
				<li><a
					href="./bookTotalSearch.book?curPage=${requestScope.page.lastNum+1}&search=${search}&kind=${kind}">[다음]</a></li>
				</c:if>
			</ul>
		</div>

	</section>

</body>
</html>