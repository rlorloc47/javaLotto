<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr><td>번호</td></tr>
		<c:forEach items="${qnaList }" var="a">
			<tr>
				<td>${a.qna_key }</td>
				<td>${a.title }</td>
				<td>${a.content }</td>
				<td>${a.writer }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>