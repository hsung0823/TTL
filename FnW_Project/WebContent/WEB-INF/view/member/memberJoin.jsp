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
		var check = false;
		
		$("#mailCheck").click(function(){
			var email = $("#email").val();
			/* location.href="./memberEmailCheck.member"; */
			$.ajax({
				url: "./memberEmailCheck.member",
				type: "GET",
				data: {
					email: email
				},
				success:function(data){
					$("#ch").html(data);
				}
			});
			
		});
		
		$("#email").change(function(){
			check=false;
			$("#ch").html("<p style=\"color: red\">이메일 인증 필요</p>");
			
		});
		
		
		$("#ch").on("click", "#check_mail" , function(){
			if($("#num").val() == $("#check").val()){
				alert("인증번호 일치");
				check=true;
				$("#ch").html("<p style=\"color: green\">인증된 이메일</p>");
			}else{
				alert("인증번호 불일치");
				check=false;
			}	
		});
		
		$("#btn").click(function(){
			if(check==true){
				alert("서브밋");
			}else{
				alert("불가");
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
	<p>gender<input type="text" name="gender" ></p>
	<p>addr<input type="text" name="addr"></p>
	<p>phone<input type="text" name="phone"></p>
	<p>email<input type="text" id="email" name="email">
	<input type="button" id="mailCheck" value="이메일 인증"></p>
	<div id="ch"></div>
	<p>library<input type="number" name="location"></p>
	<input type="button" id="btn" value="join">
</form>

</body>
</html>