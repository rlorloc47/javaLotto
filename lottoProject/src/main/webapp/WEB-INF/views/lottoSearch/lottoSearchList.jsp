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
</head>
<body>
	<form action="/lottoSearchList" class="searchDiv" method="get">
		<input type="hidden" name="pageNo" value="${lottoSearchVO.pageNo }">
		<div class="clearDiv"></div>
		<button>검색</button>
	</form>
	<table class="basicTable">
		<tr>
			<td>회차</td>
			<td>숫자</td>
			<td>보너스숫자</td>
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
			</tr>
		</c:forEach>
	</table>
	
	<div class="paginate">
	    <a href="javascript:goPage(1)" class="first">&#60;&#60;</a>
	    <span>
	        <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
	            <c:choose>
	                <c:when test="${i eq param.pageNo}"><a href="javascript:goPage(${i})" class="choice">${i}</a></c:when>
	                <c:otherwise><a href="javascript:goPage(${i})">${i}</a></c:otherwise>
	            </c:choose>
	        </c:forEach>
	    </span>
	    <a href="javascript:goPage(${finalPage})" class="last">&#62;&#62;</a>
	</div>
</body>
</html>