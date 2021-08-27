<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>랜딩페이지</title>
<style type="text/css">
	.landingDiv{
		width: 1200px;
		margin: 0 auto;
	}
	.landingMenuDiv{
		width: 500px;
		margin: 50px;
		float: left;
		cursor: pointer;
	}
	.clearDiv{
		float: none;
		clear: both;
	}
</style>
</head>
<body>
	<div class="landingDiv">
		<div class="landingMenuDiv" onclick="location.href='/raffle'">로또추첨</div>
		<div class="landingMenuDiv">...</div>
		<div class="landingMenuDiv">...</div>
		<div class="landingMenuDiv">...</div>
		<div class="clearDiv"></div>
	</div>
</body>
</html>