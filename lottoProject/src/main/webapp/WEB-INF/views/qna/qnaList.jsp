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
	.modifyTr{
		display: none;
	}
</style>
<script type="text/javascript">
	//21.09.08 수정 버튼 클릭 시, 수정 열 보이게 변경
	function showModifyButton(qna_seq) {
		var passwd_yn = $.trim($("#passwd_yn_"+qna_seq).val());
		var passwd = $("#passwd_"+qna_seq).val();
		
		if(passwd_yn == "N"){
			showModifyAction(qna_seq);
		}else{
			ajaxPasswd(qna_seq,passwd,"modify");
		}
	}
	
	//21.09.09 수정 열 보이게 변경 동작
	function showModifyAction(qna_seq) {
		$("#origin_"+qna_seq).hide();
		$("#notOrigin_"+qna_seq).show();
	}
	
	//21.09.06 수정완료 버튼 클릭 시, 수정처리
	function modifyButton(qna_seq) {
		$("#modifyFrm_"+qna_seq).submit();
	}
	
	//21.09.08 삭제 버튼 클릭 시, 삭제 처리
	function delButton(qna_seq,group_seq) {
		var passwd_yn = $.trim($("#passwd_yn_"+qna_seq).val());
		var passwd = $("#passwd_"+qna_seq).val();
		
		if(passwd_yn == "N"){
			delAction(qna_seq);
		}else{
			ajaxPasswd(qna_seq,passwd,"delete");
		}
	}
	
	//21.09.09 삭제처리 동작
	function delAction(qna_seq) {
		var group_seq = $("#group_seq_"+qna_seq).val();
		location.href = "/qnaDel?qna_seq="+qna_seq+"&group_seq="+group_seq;
	}
	
	//21.09.09 비밀번호 확인 ajax
	function ajaxPasswd(qna_seq,passwd,type) {
		var params = {
			'qna_seq' : qna_seq
			,'passwd' : passwd
		}
		//ajax 통신
		$.ajax({
			type : "GET",
			url : "/qnaCheckPasswdAjax",
			data : params,
			success : function(res) {
				if(res.checkYN=="N"){
					alert("패스워드가 일치하지 않습니다");
				}else{
					if(type=="modify"){
						showModifyAction(qna_seq);
					}else if(type=="delete"){
						delAction(qna_seq);
					}
				}
			},error : function() {
				alert("예상치 못한 오류가 발생하였으므로 추후에 다시 시도하여 주시기 바랍니다.");
			}
		});
	}
</script>
</head>
<body>
	<!-- 21.09.09 페이징 처리를 위해서 필요하지만 검색 기능은 필요하지 않아 막아둠 (나는야) -->
	<form action="/qnaList" class="searchDiv" method="get" style="display: none;">
		<input type="hidden" name="pageNo" value="${qnaVO.pageNo }">
		<div class="clearDiv"></div>
		<button>검색</button>
	</form>
	<table class="basicTable">
		<colgroup>
			<col width="10%">
			<col>
			<col width="15%">
			<col width="15%">
			<col width="15%">
		</colgroup>
		<tr>
			<td>번호</td>
			<td>내용</td>
			<td>작성자</td>
			<td>비밀번호</td>
			<td>버튼</td>
		</tr>
		<c:forEach items="${qnaList }" var="a">
			<tr id="origin_${a.qna_seq }">
				<td>
					<c:if test="${a.sort_order eq '1' }">${a.qna_seq }</c:if>
					<c:if test="${a.sort_order ne '1' }">-</c:if>
				</td>
				<td>${a.content }</td>
				<td>${a.writer }</td>
				<td>
					<input type="hidden" value="
						<c:if test="${a.passwd ne null }">Y</c:if>
						<c:if test="${a.passwd eq null }">N</c:if>"
						id="passwd_yn_${a.qna_seq }"
					>
					
					<c:if test="${a.passwd ne null }">o</c:if>
					<c:if test="${a.passwd eq null }">x</c:if>
					
					<input type="hidden" name="group_seq" id="group_seq_${a.qna_seq}" value="${a.group_seq }">
					<input type="text" name="passwd" id="passwd_${a.qna_seq }" placeholder="비밀번호입력">
				</td>
				<td>
					<input type="button" onclick="showModifyButton(${a.qna_seq})" value="수정">
					<input type="button" onclick="delButton(${a.qna_seq},${a.group_seq })" value="삭제">
				</td>
			</tr>
			<!-- 21.09.08 수정 완료 tr -->
			<form id="modifyFrm_${a.qna_seq }" action="/qnaModify" method="get">
				<tr class="modifyTr" id="notOrigin_${a.qna_seq }">
					<td>
						<c:if test="${a.sort_order eq '1' }">${a.qna_seq }</c:if>
						<c:if test="${a.sort_order ne '1' }">-</c:if>
						<input type="hidden" name="qna_seq" value="${a.qna_seq }">
						<input type="hidden" name="group_seq" value="${a.group_seq }">
					</td>
					<td>
						<textarea name="content">${a.content }</textarea>
					</td>
					<td>
						<input type="text" name="writer" value="${a.writer }">
					</td>
					<td><input type="text" name="passwd"></td>
					<td>
						<input type="button" onclick="modifyButton(${a.qna_seq})" value="수정완료">
					</td>
				</tr>
			</form>
		</c:forEach>
		<!-- 21.09.08 댓글 등록 tr -->
		<form action="/qnaInsert" method="get">
			<tr>
				<td>
					-
					<!-- 나는야 상대경로 절대경로 -->
					<!-- <img alt="아래쪽 화살표" src="/WEB-INF/img/arrow_down.png"> -->
					<input type="hidden" name="board_type" value="A">
					<input type="hidden" name="sort_order" value="${fn:length(qnaList)+1 }">
					<input type="hidden" name="qna_seq" value="${qnaVO.qna_seq }">
					<input type="hidden" name="group_seq" value="${qnaVO.group_seq }">
				</td>
				<td><textarea name="content"></textarea></td>
				<td><input type="text" name="writer"></td>
				<td><input type="text" name="passwd"></td>
				<td><button type="submit">등록</button></td>
			</tr>
		</form>
	</table>
	
	<div class="text_center">
		<ul class="page">${pagingStr }
		</ul>
	</div>
	<!-- 21.09.08 원글 등록 tr -->
	<form action="/qnaInsert" method="get">
		<table class="basicTable">
			<colgroup>
				<col>
				<col width="15%">
				<col width="15%">
				<col width="15%">
			</colgroup>
			<tr>
				<td>내용</td>
				<td>작성자</td>
				<td>비밀번호</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" name="board_type" value="Q">
					<input type="hidden" name="sort_order" value="1">
					<textarea name="content"></textarea>
				</td>
				<td><input type="text" name="writer"></td>
				<td><input type="text" name="passwd"></td>
				<td><button type="submit">등록</button></td>
			</tr>
		</table>
	</form>
</body>
</html>