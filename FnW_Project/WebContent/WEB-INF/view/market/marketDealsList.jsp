<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
		var y = '${year}';
		
		$(".years").each(function() {
			if($(this).val()==y){
				$(this).attr("selected", true);
				
			}
		});
		
	
	
});
</script>
</head>
<body>
	<h2>MarketTotalList-MyPage</h2>
	<div>
	<form name="frm" class="form-inline" action="./marketDealsList.market" method="post">
	
		<div>
			<span>
				<select id="year" name="year">
		            <option class="years" value="2017" >2017</option>
		            <option class="years" value="2016">2016</option>
		            <option class="years" value="2015">2015</option>
		            <option class="years" value="2014">2014</option>
		            <option class="years" value="2013">2013</option>
  			      </select>
       			 년
       			 <select id="month" name="month">
		            <option value="01">01</option>
		            <option value="02">02</option>
		            <option value="03">03</option>
		            <option value="04">04</option>
		            <option value="05">05</option>
		            <option value="06">06</option>
		            <option value="07">07</option>
		            <option value="08">08</option>
		            <option value="09">09</option>
		            <option value="10">10</option>
		            <option value="11">11</option>
		            <option value="12">12</option>
		        </select>
    		    월
		        <select id="day" name="day">
		            <option value="01">01</option>
		            <option value="02">02</option>
		            <option value="03">03</option>
		            <option value="04">04</option>
		            <option value="05">05</option>
		            <option value="06">06</option>
		            <option value="07">07</option>
		            <option value="08">08</option>
		            <option value="09">09</option>
		            <option value="10">10</option>
		            <option value="11">11</option>
		            <option value="12">12</option>
		            <option value="13">13</option>
		            <option value="14">14</option>
		            <option value="15">15</option>
		            <option value="16">16</option>
		            <option value="17">17</option>
		            <option value="18">18</option>
		            <option value="19">19</option>
		            <option value="20">20</option>
		            <option value="21">21</option>
		            <option value="22">22</option>
		            <option value="23">23</option>
		            <option value="24">24</option>
		            <option value="25">25</option>
		            <option value="26">26</option>
		            <option value="27">27</option>
		            <option value="28">28</option>
		            <option value="29">29</option>
		            <option value="30">30</option>
		            <option value="31">31</option>
		        </select>
		        일 이전 까지
      		  </span>
      		  <div class="form-group">
	      		  <div class="col-sm-offset-2 col-sm-10">
	      		 	 <input type="submit" class="btn btn-default" value="Search">
	      		  </div>
      		  </div>
		</div>
		</form>
	</div>


	<table class="table" border="1">
		<tr>
			<th>num</th>
			<th>title</th>
			<th>writer</th>
			<th>company</th>
			<th>publish_date</th>
			<th>T_date</th>
			<th>library</th>
			<th>price</th>
			<th>state</th>
			<th>delivery</th>
		</tr>
		<c:forEach items="${bookDeals }" var="bookDeals_list">
			<tr>
				<td>${bookDeals_list.num }</td>
				<td><a
					href="./marketDealsDetails.market?num=${bookDeals_list.num }">${bookDeals_list.title }</a></td>
				<td>${bookDeals_list.writer }</td>
				<td>${bookDeals_list.company }</td>
				<td>${bookDeals_list.publish_date }</td>
				<td>${bookDeals_list.t_date }</td>
				<td>${bookDeals_list.library }</td>
				<td>${bookDeals_list.price }</td>
				<td>${bookDeals_list.state }</td>
				<td>${bookDeals_list.delivery }</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<ul class="pagination">
			<c:if test="${page.curBlock>1}">
			<li><button class="go" id="${page.startNum-1}">[이전]</button></li>
			</c:if>
			<c:forEach begin="${page.startNum}" end="${page.lastNum}" var="i">
			<li><a
				href="./marketDealsList.market?curPage=${i}&id=${id }">${i}</a></li>
			</c:forEach>
			<c:if test="${page.curBlock < page.totalBlock}">
			<li><a
				href="./marketDealsList.market?curPage=${requestScope.page.lastNum+1}">[다음]</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>