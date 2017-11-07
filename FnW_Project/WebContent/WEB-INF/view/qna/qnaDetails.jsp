<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$(".replyUpdate").click(function() {
		var c = $(this).attr("title");
		
		var s = $("#update"+c).html();
		var chtml = "<textarea>"+s+"</textarea>";
		chtml+="<a href='../qnaReply/qnaReplyUpdate.qnaReply?num="+c+"'>";
		chtml+="<input type='button' value='완료'>";
		chtml+="</a>";
		$("#update"+c).html(chtml);
		
		$(".btn"+c).hide();
	});
});
</script>
</head>
<body>
<h2>QnA Details</h2>
<form action="../index.jsp" method="post">
		<p>num<input type="text" name="num" value=${qnaDTO.num }></p>
		<p>type<input type="text" name="type" value=${qnaDTO.type } ></p>
		<p>title<input type="text" name="title" value=${qnaDTO.title } ></p>
		<p>contents<input type="text" name="contents" value=${qnaDTO.contents }></p>
		<p>writer<input type="text" name="writer" value=${qnaDTO.writer }></p>
		<p>date<input type="text" name="date" value=${qnaDTO.reg_date }></p>
		<p>hit<input type="text" name="hit" value=${qnaDTO.hit } ></p>
		<p>kind<input type="text" name="kind" value=${qnaDTO.kind } ></p>
		<button type="submit">확인</button>
		<a href="./qnaDelete.qna?num=${qnaDTO.num }"><input type="button" value="삭제"></a>
		<a href="./qnaUpdate.qna?num=${qnaDTO.num }"><input type="button" value="수정"></a>
</form>	
<hr>
<form action="../qnaReply/qnaReplyInsert.qnaReply?num=${qnaDTO.num }" method="post">
	<p><textarea name="reply"></textarea><button>등록</button> </p>
</form>
<c:if test="${rDTO ne null }">
<table>
<c:forEach items="${rDTO }" var="DTO" varStatus="i">
	<tr>
		<td>${DTO.writer }</td>
		<td>${DTO.reg_date }</td>
	</tr>
	<tr>
		<td id="${DTO.num }"><div id="update${i.index}">${DTO.contents }</div></td>
	
		<td class="btn${i.index}"><input type="button" class="replyUpdate" title="${i.index}" value="수정"></td>
		<td class="btn${i.index}"><a href="../qnaReply/qnaReplyDelete.qnaReply?num=${DTO.num }"><input type="button" value="삭제"></a></td>
		
	</tr>
</c:forEach>
</table>
</c:if>
</body>
</html>