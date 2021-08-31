<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	google.charts.load('current', {'packages':['bar']});
	google.charts.setOnLoadCallback(drawStuff);
	
	function drawStuff() {
		var jsonData = ('${jsonArray}');
		
		var data = new google.visualization.arrayToDataTable($.parseJSON(jsonData));
		 
		var options = {
			//title: 'Chess opening moves',
			width: 900,
			legend: { position: 'none' },
			/* chart: { title: 'Chess opening moves',
			         subtitle: 'popularity by percentage' }, */
			bars: 'vertical', // Required for Material Bar Charts.
			axes: {
			  x: {
			    0: { side: 'top', label: '복권 차트'} // Top x-axis.
			  }
			},
			bar: { groupWidth: "90%" }
		};
		
		var chart = new google.charts.Bar(document.getElementById('chart_div'));
		chart.draw(data, options);
};
</script>
<meta charset="UTF-8">
<title>로또확률계산</title>
</head>
<body>
	<form action="/percentageList" class="searchDiv" method="get">
		<div class="searchYear">
			<input type="text" name="startYear" value="${startYear }">
			<input type="text" name="endYear" value="${endYear }">
		</div>
		<div class="searchNumber">
			숫자기준
			<c:forEach begin="1" end="45" step="1" var="a">
				<input id="number_${a }" type="checkbox" name="searchNumber" value="${a}">
					<label for="number_${a }">${a }</label>
				<c:if test="${a%5 eq 0 }"><br/></c:if>
			</c:forEach>
		</div>
		<div class="orderDiv">
			<select name="orderBy">
				<option value="">전체</option>
				<option value="percentDesc">확률업</option>
				<option value="percentAsc">확률다운</option>
				<option value="numberDesc">숫자업</option>
				<option value="numberAsc">숫자다운</option>
			</select>
		</div>
		<div class="clearDiv"></div>
		<button>검색</button>
	</form>
	<table>
		<tr><td>번호</td></tr>
		<c:forEach items="${percentageList }" var="a">
			<tr>
				<td>${a.ball_number }</td>
				<td>${a.ballCount }개</td>
			</tr>
		</c:forEach>
	</table>
	<div id="chart_div"></div>
</body>
</html>