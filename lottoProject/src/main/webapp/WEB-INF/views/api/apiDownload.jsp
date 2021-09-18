<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/apiAjax">API 예제</a>
	<h5>전송값 리스트</h5>
	<table class="basicTable">
		<tr>
			<td>번호</td>
			<td>변수명</td>
			<td>설명</td>
			<td>기본값</td>
			<td>타입</td>
		</tr>
		<tr>
			<td>1</td>
			<td>startYear</td>
			<td>시작회차</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>2</td>
			<td>endYear</td>
			<td>종료회차</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>3</td>
			<td>searchNumber</td>
			<td>원하는 숫자</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>4</td>
			<td>orderBy</td>
			<td>정렬순서</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>5</td>
			<td>bonusYN</td>
			<td>보너스여부</td>
			<td></td>
			<td></td>
		</tr>
	</table>
	
	<h5>반환값 리스트은 json 타입으로 {복권번호:복권번호가 추출된 갯수}로 반환됩니다.</h5>
</body>
</html>