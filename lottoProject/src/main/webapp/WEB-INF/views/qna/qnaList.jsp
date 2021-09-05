<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="basicTable">
		<tr>
			<td>번호</td>
			<td>내용</td>
			<td colspan="2">작성자</td>	
		</tr>
		<c:forEach items="${qnaList }" var="a">
			<tr>
				<td>
					<c:if test="${a.sort_order eq '1' }">${a.qna_seq }</c:if>
					<c:if test="${a.sort_order ne '1' }">-</c:if>
				</td>
				<td>${a.content }</td>
				<td colspan="2">${a.writer }</td>
			</tr>
		</c:forEach>
		<form action="/qnaInsert" method="get">
			<tr>
				<td>
					-
					<input type="hidden" name="board_type" value="A">
					<input type="hidden" name="sort_order" value="${fn:length(qnaList)+1 }">
					<input type="hidden" name="qna_seq" value="${qnaVO.qna_seq }">
					<input type="text" name="group_seq" value="${qnaVO.qna_seq }">
				</td>
				<td><textarea name="content"></textarea></td>
				<td><input type="text" name="writer"></td>
				<td><button type="submit">등록</button></td>
			</tr>
		</form>
	</table>
	<form action="/qnaInsert" method="get">
		<table class="basicTable">
			<tr>
				<td>내용</td>
				<td>작성자</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" name="board_type" value="Q">
					<input type="hidden" name="sort_order" value="1">
					<textarea name="content"></textarea>
				</td>
				<td><input type="text" name="writer"></td>
				<td><button type="submit">등록</button></td>
			</tr>
		</table>
	</form>
</body>
</html>