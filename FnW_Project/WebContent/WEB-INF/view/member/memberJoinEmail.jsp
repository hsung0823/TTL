<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	
		$("#send").click(function(){
			$.ajax({
				url: "../memberEmailCheck.jsp",
				type: "POST",
				data: {
					
				},
				success:function(data){
					$("#ch").load(data);
				}
			});//
		});// 
		
	});//
	
</script>
</head>
<body>
	<h2>email check</h2>
	
	<form action="./memberEmailCheck.member" method="post">
		<input type="text" value=${param.email } name="email" >
		<button type="submit" id="send">send</button>
	</form>
	
	<div id="ch">
	</div>
	
</body>
</html>