<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>title</title>
<%-- <tiles:insertAttribute name="script" /> --%>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<style type="text/css">
.leftMenuDiv{
	width: 20%;
	min-width: 200px;
	float: left;
	height: 100%;
	background-color: #e8e8e8;
}
#content{
	position: absolute;
	left: 0;
	top: 10%;
	height: 80%;
	width: 100%;
}
.page-contentinbe{
	height: 100%;
}
.bodyDiv{
	width: 80%;
	float: right;
}
.searchDiv{
	background-color: gray;
}
.leftMenuCell{
	cursor: pointer;
}
.clearDiv{
	float: none;
	clear: both;
}

/* 21.09.03 기본테이블 css */
.basicTable{
	width: 100%;
	min-width: 1000px;
	border: 1px solid black;
	border-collapse: collapse;
	margin-bottom: 50px;
}
.basicTable>tbody>tr>td{
	border: 1px solid black;
	text-align: center;
}

/* 21.09.03 페이지 처리 */
.text_center{
	width: 500px;
	margin: 0 auto;
}
.text_center .page li{
	float: left;
    cursor: pointer;
    font-size: 13px;
    width: 26px;
    height: 25px;
	list-style:none;
	padding-left:0px;
}
.text_center .page li>a {
    color: #656565;
}
.text_center .page li:nth-child(1) {
    padding: 0 0;
    box-sizing: border-box;
}
.text_center .page li:nth-child(2) {
    padding: 0 0;
    box-sizing: border-box;
}

/* 21.09.12 화살표 */
.arrow_down .arrow_up{
	width: 10px;
	height: 10px;
}

/* 21.09.12 레이아웃 관련 */
.footer{
	width: 100%;
	height: 10%;
	background-color: gray;
	position:absolute;
	bottom:0;
	left: 0;
}
.wholeDIv{
	width: 100%;
	height: 100%;
}
#headerDiv{
	height: 10%;
	width: 100%;
	position: absolute;
	top: 0;
	left: 0;
	background-color: gray;
}
</style>
<script type="text/javascript">
	function movePage(pageNo) {
		$(".searchDiv>input[name=pageNo]").val(pageNo);
		$(".searchDiv").submit();
	}
</script>
</head>
<body>
	<div class="wholeDIv">
		<tiles:insertAttribute name="header" />
	    <div id="content">
	        <div class="page-contentinbe">
	        	<div class="leftMenuDiv">
					<tiles:insertAttribute name="left" />
				</div>
	        	<div class="bodyDiv">
	        		<tiles:insertAttribute name="body" />
	        	</div>
	        	<div class="clearDiv"></div>
	        </div>
	    </div>
	    <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>