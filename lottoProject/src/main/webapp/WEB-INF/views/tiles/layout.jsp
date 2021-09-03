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
.paginate{
	width: 300px;
	margin: 0 auto;
}
</style>
<script type="text/javascript">
	function goPage(pageNo) {
		$(".searchDiv>input[name=pageNo]").val(pageNo);
		$(".searchDiv").submit();
	}
</script>
</head>
<body>
    <%-- <tiles:insertAttribute name="header" /> --%>
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
</body>
</html>