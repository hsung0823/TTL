<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-8 col-centered">
			<form action="./${notice}Update.${notice}" method="post">
				<input type="hidden" name="num" value="${view.num}">
				<table class="table">
					<tr>
						<tr>
						<td colspan="2"><%-- 글 제목 --%><input class="form-control" type="text" name="title" value="${view.title}" placeholder="제목없음"></td>
						<td colspan="2"><!-- blank --></td>
						<td id="reg_date"><!-- 날짜 --></td>
						<td id="writer"><!-- 작성자 --><input class="form-control" type="text" name="writer" readonly="readonly" value="${requestScope.view.writer}" placeholder="작성자"></td>
					</tr>
					<tr>
					 	<td colspan="6" id="contents"><!-- contents 내용 --><textarea class="form-control" name="contents" placeholder="내용을 입력하세요.">${view.contents} </textarea></td>
					</tr>
				</table>
				
				<button>UPdate</button>
			</form>
			</div>
</body>
</html>