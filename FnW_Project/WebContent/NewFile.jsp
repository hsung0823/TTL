<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

var i = 0;
$(document).ready(function() {
 
    var currentPage = 1;
    checkForHash();
 
    $("#btn1").add("#btn2").add("#btn3").on("click", function(e) {
        currentPage = $(this).val();
        showPage($(this).val());
    });
 
    
    $(".link").on("click", function(e) {
        document.location.hash = "#" + currentPage;
    });
});
 
function checkForHash() {
    if(document.location.hash){
        var HashLocationName = document.location.hash;
        HashLocationName = HashLocationName.replace("#","");
        $("#display").html(HashLocationName)
    } else {
        $("#display").html($("#btn1").val())
    }
}
 
function showPage(value) {
    $("#display").html(value)
} 
</script>
</head>
<body>
<div id="display"></div>
<input type="button" value="11" id="btn1">&nbsp;
<input type="button" value="22" id="btn2">&nbsp;
<input type="button" value="33" id="btn3">&nbsp;
<br/>
<a href="http://www.google.com" class="link">Google :)</a>
</body>
</html>