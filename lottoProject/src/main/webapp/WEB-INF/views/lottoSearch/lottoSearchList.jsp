<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.ballDiv{
	float: left;
	border-radius: 30px;
	width: 30px;
	height : 30px;
	margin-right: 5px;
	color: white;
}
.ballCellYellow{
	background-color: #fcc43d;
}
.ballCellBlue{
	background-color: #8cc6e7;
}
.ballCellRed{
	background-color: #f18d80;
}
.ballCellPurple{
	background-color: #a7a2de;
}
.ballCellGreen{
	background-color: #6bce9e;
}
</style>

<script type="text/javascript">
//21.09.12 담청지역 표시
function showWinLottoAjax(history_idx) {
	var params = {
		'history_idx' : history_idx
	}
	//ajax 통신
	$.ajax({
		type : "GET",
		url : "/showWinLottoAjax",
		data : params,
		success : function(res) {
			$(".removeTr").remove();	//이전회차 삭제 처리
			$(".hideWinTr").hide();	//"상단에 원하는 회차~" 문구 숨기기
			
			var tbody = $(".winTable");
			$.each(res.lottoWinList,	function(idx, val) {
				tbody.append($('<tr class=removeTr>').append($('<td>',	{text : (idx+1)}))
						              .append($('<td>',	{text : val.address_ori}))
									  .append($('<td>',	{text : val.code_content}))
									  .append($('<td>',	{text : val.win_order}))
									  .append($('<td>',	{text : val.company_name})));
			});
		},error : function() {
			alert("예상치 못한 오류가 발생하였으므로 추후에 다시 시도하여 주시기 바랍니다.");
		}
	});
}
</script>
</head>
<body>
	<form action="/lottoSearchList" class="searchDiv" method="get">
		<input type="hidden" name="pageNo" value="${lottoSearchVO.pageNo }">
		<input type="text" name="searchKeyword" placeholder="회차" value="${lottoSearchVO.searchKeyword }">
		<div class="clearDiv"></div>
		<button>검색</button>
	</form>
	<table class="basicTable">
		<tr>
			<td>회차</td>
			<td>숫자</td>
			<td>보너스숫자</td>
			<td>담청지역 확인버튼</td>
		</tr>
		<c:forEach items="${lottoSearchList }" var="a">
			<tr>
				<td>${a.history_idx }회차</td>
				<td>
					<c:forEach var="b" items="${fn:split(a.ballList,',')}">
						<div class="ballDiv 
							<c:choose>
								<c:when test="${b lt 10 }">ballCellYellow</c:when>
								<c:when test="${b lt 20 }">ballCellBlue</c:when>
								<c:when test="${b lt 30 }">ballCellRed</c:when>
								<c:when test="${b lt 40 }">ballCellPurple</c:when>
								<c:when test="${b lt 50 }">ballCellGreen</c:when>
							</c:choose>
						">${b }</div>
					</c:forEach>
					<div class="clearDiv"></</div>
				</td>
				<td>
					<div class="ballDiv
						<c:choose>
							<c:when test="${a.bonus_number lt 10 }">ballCellYellow</c:when>
							<c:when test="${a.bonus_number lt 20 }">ballCellBlue</c:when>
							<c:when test="${a.bonus_number lt 30 }">ballCellRed</c:when>
							<c:when test="${a.bonus_number lt 40 }">ballCellPurple</c:when>
							<c:when test="${a.bonus_number lt 50 }">ballCellGreen</c:when>
						</c:choose>
						">${a.bonus_number }
					</div>
				</td>
				<td>
					<input type="radio" name="winLotto" onclick="showWinLottoAjax(${a.history_idx})">
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="text_center">
		<ul class="page">${pagingStr }
		</ul>
	</div>
	
	<table class="basicTable winTable">
		<colgroup>
			<col width="5%">
			<col>
			<col width="10%">
			<col width="10%">
			<col width="25%">
		</colgroup>
		<tr>
			<td>번호</td>
			<td>주소</td>
			<td>자동여부</td>
			<td>당첨등수</td>
			<td>상호명</td>
		</tr>
		<tr class="hideWinTr">
			<td colspan="5">상단에 원하는 회차를 선택하여 주시기 바랍니다</td>
		</tr>
	</table>
</body>
</html>