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
		//${check }  -> sessionScope.check  => 인증번호 //String
		var num = $("#num").val();
		
		$("#btn").click(function(){
			
			if(num == '${check }' ){
				alert("eq");
			}else{
				alert("ne");
			} 
			
		});
		
		
		
	});//

</script>    
</head>
<body>
	<form action="">
	
		<p>인증번호입력<input type="text" id="num"></p>
	
		<input type="button" id="btn" value ="확인">
		${check }
	
	</form>

</body>
</html>


    
    