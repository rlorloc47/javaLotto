<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	google.charts.load('current', {'packages':['bar']});
	google.charts.setOnLoadCallback(drawStuff);
	
	function drawStuff() {
		var jsonData = $.parseJSON('${jsonArray}');
		
		for (a = 0; a < jsonData.length; a++) {
			var data = new google.visualization.arrayToDataTable(jsonData[a]);
	
			var options = {
				width: 900,
				legend: { position: 'none' },
				bars: 'vertical', // Required for Material Bar Charts.
				axes: {
				  x: {
				    0: { side: 'top', label: '복권 차트'} // Top x-axis.
				  }
				},
				bar: { groupWidth: "90%" }
			};
			
			//21.09.06 DIV 추가하고 해당 DIV에 chart data 널기
			var divElement = document.createElement("DIV");
			divElement.className += 'chart_div';
			$("#chartDivParent").append(divElement);
			
			var chart = new google.charts.Bar(divElement);
			chart.draw(data, options);
		}
};
</script>
<meta charset="UTF-8">
<title>로또확률계산</title>
</head>
<body>
	<form action="/percentageList" class="searchDiv" method="get">
		<div class="searchYear">
			<input type="text" name="startYear" value="${percentageVO.startYear  }" placeholder="시작회차">
			<input type="text" name="endYear" value="${percentageVO.endYear }" placeholder="종료회차">
		</div>
		<div class="searchNumber">
			<c:forEach begin="1" end="45" step="1" var="a">
				<input id="number_${a }" type="checkbox" name="searchNumber" value="${a}"
					<c:if test="${percentageVO.searchNumber eq null }">checked="checked"</c:if>
					<c:forEach items="${fn:split(percentageVO.searchNumber, ',') }" var="searchNumberCell">
						<c:if test="${a eq searchNumberCell }">checked="checked"</c:if>
					</c:forEach>
				>
					<label for="number_${a }">${a }</label>
				<c:if test="${a%5 eq 0 }"><br/></c:if>
			</c:forEach>
		</div>
		<div class="orderDiv">
			<select name="orderBy">
				<option value="">전체</option>
				<option value="percentDesc" <c:if test="${percentageVO.orderBy eq 'percentDesc' }">selected</c:if>>확률업</option>
				<option value="percentAsc" <c:if test="${percentageVO.orderBy eq 'percentAsc' }">selected</c:if>>확률다운</option>
				<option value="numberDesc" <c:if test="${percentageVO.orderBy eq 'numberDesc' }">selected</c:if>>숫자업</option>
				<option value="numberAsc" <c:if test="${percentageVO.orderBy eq 'numberAsc' }">selected</c:if>>숫자다운</option>
			</select>
		</div>
		<div>
			<input type="checkbox" name="bonusYN" value="Y" id="bonusYN"
				<c:if test="${percentageVO.bonusYN eq 'Y' }">checked</c:if>
			><label for="bonusYN">보너스 여부</label>
		</div>
		<div class="clearDiv"></div>
		<button>검색</button>
	</form>
	<%-- <table>
		<tr><td>번호</td></tr>
		<c:forEach items="${percentageList }" var="a">
			<tr>
				<td>${a.ball_number }</td>
				<td>${a.ballCount }개</td>
			</tr>
		</c:forEach>
	</table> --%>
	<div id="chartDivParent"></div>
</body>
</html>