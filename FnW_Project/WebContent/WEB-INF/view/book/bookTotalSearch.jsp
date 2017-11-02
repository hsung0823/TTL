<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Integration_Book_Search_Page</h3>
	<section>
	
		<div class="row-right">
			<form name="frm" class="form-inline" action="./bookTotalSearch.book" method="post">
					<!-- KIND -->
					<div class="form-group">
						<div class="col-sm-10">
							<select name="kind">
								<option value="title">제목</option>
								<option value="writer">저자</option>
								<option value="company">출판사</option>
							</select>
						</div>
					</div>

					<!-- SEARCH -->
					<div class="form-group">
						<div class="col-sm-10">
							<input type="text" class="form-control" id="search" placeholder="Enter" name="search">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" class="btn btn-default" value="Search">
						</div>
					</div>
			</form>
			
			
			<form action="">
				<table>
						<tr>
							<td>num</td>
							<td>title</td>
							<td>writer </td>
							<td>company </td>
						</tr>
					<c:forEach items="${list }" var="dto">
						
						<tr>	
							<td>${dto.num }</td>
							<td>${dto.title }</td>
							<td>${dto.writer }</td>
							<td>${dto.company }</td>
						</tr>			
					</c:forEach>
			
				</table>
			</form>
		</div>
		
	</section>

</body>
</html>