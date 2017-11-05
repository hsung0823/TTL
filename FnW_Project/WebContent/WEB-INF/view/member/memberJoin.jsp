<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("#mailCheck").click(function(){
			var email = $("#email").val();
			 window.open('./memberEmailCheck.member?email='+email)
			 
			/* location.href="./memberEmailCheck.member?email="+email; */
		});
		
	
		$("#btn").click(function(){
			var ok = '${email}';
			if(ok == 'ok'){
				alert("ok");
			}else{
				alert("no")
			}
		});
		
		
	});//

</script>
</head>
<body>
<h1>memberJoinForm</h1>

<form action="./memberJoin.member" method="post">
	<p>id<input type="text" name="id"></p>
	<p>pw<input type="text" name="pw"></p>
	<p>name<input type="text" name="name"></p>
	<p>birth<input type="date" name="birth"></p>
	<p>gender<input type="text" name="gender"></p>
	<p>addr<input type="text" name="addr"></p>
	<p>phone<input type="text" name="phone"></p>
	<p>email<input type="text" id="email" name="email">
	<input type="button" id="mailCheck" value="이메일 인증"></p>
	<div id="agree"></div>
	<p>library<input type="number" name="location"></p>
	<input type="button" id="btn" value="join">
</form>

</body>
</html>