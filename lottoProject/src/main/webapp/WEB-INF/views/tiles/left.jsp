<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.leftMenuOn{
	color: white;
	background-color: gray;
}
</style>
<script type="text/javascript">
	/* 21.09.15 왼쪽 메누 확인 */
	$(document).ready(function() {
		$(".leftMenuCell > div").each(function(index){
			var leftMenu = "${leftMenu}";
			var thisClass = $(this).attr("class");
			if(thisClass == leftMenu && leftMenu != "" && thisClass != ""){
				$(this).addClass("leftMenuOn");
				$("#headerDiv").text($(this).text());
			}
		});
	});
</script>
</head>
<body>
	<div class="leftMenuCell">
		<div class="lottoSearchList" onclick="location.href='/lottoSearchList'">복권 조회</div>
		<div class="percentageList" onclick="location.href='/percentageList'">복권 확률 계산</div>
		<div class="qnaList" onclick="location.href='/qnaList'">문의게시판</div>
		<div class="apiDownload" onclick="location.href='/apiDownload'">API 다운로드</div>
	</div>
</body>
</html>