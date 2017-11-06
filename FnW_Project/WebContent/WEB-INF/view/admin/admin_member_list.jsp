<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		

	$("#btn_admin").click(function() {
		
 		$(".kind1").attr("style", "background-color: #fff");
 		$("#btn_admin").attr("style", "background-color: #dcdcdc");
		
		$.ajax({
			url:"./memberList.member",
			type:"POST",
			data: {
				kind:10
			},
			success:function(data){
				$("#list").html(data);
			}
		});
		
		$("#info").html("Admin List");
		
	});

	$("#btn_member").click(function() {
		
 		$(".kind1").attr("style", "background-color: #fff");
 		$("#btn_member").attr("style", "background-color: #dcdcdc");
 		
 		$.ajax({
			url:"./memberList.member",
			type:"post",
			data: {
				kind:1
			},
			success:function(data){
				$("#list").html(data);
			}
		});
 		$("#info").html("Member List");
 		
	});

	$("#btn_black").click(function() {
	
		$(".kind1").attr("style", "background-color: #fff");
		$("#btn_black").attr("style", "background-color: #dcdcdc");
	
		$.ajax({
			url:"./memberList.member",
			type:"post",
			data: {
				kind:0
			},
			success:function(data){
				$("#list").html(data);
			}
		});
		$("#info").html("Black List");
		
	});

	
	
	});
</script>
</head>
<body>
	<div style = "height: 100px"></div>

	<form name="frm" class="form-inline" action="./admin_member_list.member" method="post">
			<!-- SEARCH -->
			<div class="form-group">
				<div class="col-sm-10">
					<input type="text" class="form-control" id="search" placeholder="ID 검색" name="search" value = "${search}">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" id = "search" class="btn btn-default" value="Search">
				</div>
			</div>
	</form>
	
	<div style = "height: 50px"></div>
	
	<form action="">
		<table class = "table">
			<tr>
				<td><input type = "button" id = "btn_admin" class = "btn btn-default kind1" value = "ADMIN"></td>
				<td><input type = "button" id = "btn_member" class = "btn btn-default kind1" style = "background-color: #dcdcdc" value = "MEMBER"></td>
				<td><input type = "button" id = "btn_black" class = "btn btn-default kind1" value = "BLACKLIST"></td>
			</tr>
		</table>
	</form>

	<h2 id="info" >Member List</h2>
	
	<div id = "list"> 
		<table id = "member" class="kind" border="1">
			<tr>
				<th>id</th>
				<th>pw</th>
				<th>name</th>
				<th>birth</th>
				<th>gender</th>
				<th>addr</th>
				<th>phone</th>
				<th>email</th>
				<th>library</th>
				<th>kind</th>
			</tr>
			<c:forEach items="${list }" var="dto">
				<tr>
					<td><a href="./memberUpdate.member?id=${dto.id }">${dto.id }</a></td>
					<td>${dto.pw }</td>
					<td>${dto.name }</td>
					<td>${dto.birth }</td>
					<td>${dto.gender }</td>
					<td>${dto.addr }</td>
					<td>${dto.phone }</td>
					<td>${dto.email }</td>
					<td>${dto.library }</td>
					<td>${dto.kind }</td>
				</tr>
			</c:forEach>
		</table>
		<div style = "text-align: center;">
			<ul class="pagination pagination-sm">
				<c:if test="${page.curBlock>1}">
				<li><a href = "./memberList.member?curPage=${page.startNum-1}&search=${search}">[이전]</a></li>
				</c:if>
				
				<c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
				<li><a id="pa" href="./memberList.member?curPage=${i}&kind=${kind}">${i}</a></li>
				</c:forEach>

				<c:if test="${page.curBlock < page.totalBlock}">
				<li><a href="./memberList.member?curPage=${page.lastNum+1}&search=${search}">[다음]</a></li>
				</c:if>
			</ul>
		</div>
	</div>




	<a href="../index.jsp">home</a>
</body>
</html>