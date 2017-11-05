<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
function chk(){
 var req1 = document.form.req1.checked;
 var req2 = document.form.req2.checked;
 var req3 = document.form.req3.checked; 
 var num = 0;
 if((req1&&req2&&req3) == true){
  num = 1;
 }
 if(num==1){
  document.form.submit();
 }else{
  alert("개인정보 약관에 동의하셔야 합니다.");
 }
}


function all_chk() 
{
	if((form.req1.checked||form.req1.checked||form.req1.checked)==false)
		{
		form.req1.checked = true;
		form.req2.checked = true;
		form.req3.checked = true;
		}
	else if((form.req1.checked||form.req1.checked||form.req1.checked)==true)
		{
			form.req1.checked = false;
			form.req2.checked = false;
			form.req3.checked = false;
		}

}

function nochk(){
 alert("동의하지 않으면 가입하실 수 없습니다");
location.href="../index.jsp";
}
</script>



<form action="./memberJoin.member" name="form" method="get">

 <table>
   <tr>
   <td>
   <textarea>
	동의1
   </textarea>
   <br>
   <input type="checkbox" name="req1">동의1 
   </td>
  </tr>
   <tr>
   <td>
   <textarea>
	동의2
   </textarea>
   <br>
   <input type="checkbox" name="req2">동의2
   </td>
  </tr>
   <tr>
   <td>
   <textarea>
	동의3
   </textarea>
   <br>
   <input type="checkbox" name="req3">동의3
   </td>
  </tr>
  <tr>
   <td>
    <input type="button" value="동의" onclick="chk()"/>&nbsp;
    <input type="button" value="동의하지 않습니다" onclick="nochk()"/>&nbsp;
    <input type="button" value="전체 동의" name="allCheck" onclick="all_chk()"/>
   </td>
  </tr>
 </table>
</form>

</body>
</html>