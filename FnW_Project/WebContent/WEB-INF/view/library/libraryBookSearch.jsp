<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

	<h2>도서 검색 페이지</h2>
	
	<section>
		<div class="row-right">
			<form name="frm" class="form-inline" action="./libraryBookSearch.library" method="post">
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
						<td>대여여부</td>
					</tr>
					${list }
					<c:forEach items="${list}" var="dto">
						<a href="../book/bookInformation.book?num=${dto.num}">
						<tr>	
							<td>${dto.num }</td>
							<td>${dto.title }</td>
							<td>${dto.writer }</td>
							<td>${dto.company }</td>

							<c:choose>
								<c:when test="${dto.state == 0 }"><td><button class = "btn btn-default" id = "rent_btn" type = "submit" href = "#">대여</button></td></c:when>
								<c:when test="${dto.state == 1 }"><td>대여 불가</td></c:when>
							</c:choose>
						</tr>
						</a>
					</c:forEach>
				</table>
			</form>

		</div>

		<div style = "text-align: center;">
			<ul class="pagination pagination-sm">
				<c:if test="${page.curBlock>1}">
				<li><a href = "./libraryBookSearch.library?curPage=${page.startNum-1}&search=${search}&kind=${kind}">[이전]</a></li>
				</c:if>
				
				<c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
				<li><a
					href="./libraryBookSearch.library?curPage=${i}&search=${search}&kind=${kind}">${i}</a></li>
				</c:forEach>
				
				<c:if test="${page.curBlock < page.totalBlock}">
				<li><a
					href="./libraryBookSearch.library?curPage=${requestScope.page.lastNum+1}&search=${search}&kind=${kind}">[다음]</a></li>
				</c:if>
			</ul>
		</div>

	</section>

</body>
</html>