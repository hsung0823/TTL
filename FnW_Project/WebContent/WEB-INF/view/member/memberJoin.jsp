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
		
		$("#id").change(function(){
			var id = $("#id").val();
			
			$.ajax({
				url: "./memberIdCheck.member",
				type: "POST",
				data: {
					id:id
				},
				success:function(data){
					if($("#id").val().length>5){
						if(data.trim() == 'ok'){
							$("#ch_id").html('<p style="color: green">사용가능 아이디</p>');	
							check= true;
						}else{
							$("#ch_id").html('<p style="color: red">중복된 아이디</p>');	
							check= false;
						}
					}else{
						$("#ch_id").html('<p style="color: red">아이디는 6자 이상</p>');	
						check= false;
					}
				}//
			});
			
		});


		$("#mailCheck").click(function(){
			var email = $("#email").val();
			$.ajax({
				url: "./memberEmailCheck.member",
				type: "POST",
				data: {
					email: email
				},
				success:function(data){
					$("#ch_email").html(data);
				}
			});
			
		});

		$("#email").change(function(){
			check=false;
			$("#ch_email").html("<p style=\"color: red\">이메일 인증 필요</p>");
			
		});
		
		$("#ch_email").on("click", "#check_mail" , function(){
			if($("#num").val() == $("#check").val()){
				alert("인증번호 일치");
				check=true;
				$("#ch_email").html("<p style=\"color: green\">인증된 이메일</p>");
			}else{
				alert("인증번호 불일치");
				check=false;
			}	
		});
		
		$("#btn").click(function(){
			if(check==true){
				document.frm.submit();
			}else{
				alert("불가");
			}
		});
		
	});//

</script>
</head>
<body>
<h1>memberJoinForm</h1>

<form action="./memberJoin.member" method="post" id="frm" name="frm">
	<p>id<input type="text" id ="id" name="id"></p>
	<div id="ch_id"></div>
	<p>pw<input type="text" name="pw"></p>
	<p>name<input type="text" name="name"></p>
	<p>birth<input type="date" name="birth"></p>
	<p>gender<input type="text" name="gender" ></p>
	<p>addr<input type="text" name="addr"></p>
	<p>phone<input type="text" name="phone"></p>
	<p>email<input type="text" id="email" name="email">
	<input type="button" id="mailCheck" value="이메일 인증"></p>
	<div id="ch_email"></div>
	<p>library<input type="number" name="location"></p>
	<input type="button" id="btn" value="join">
</form>

</body>
</html>