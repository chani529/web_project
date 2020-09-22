<%@page import="com.son.dto.BoardDto"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>

<%
request.setCharacterEncoding("utf-8");
BoardDto dto = (BoardDto)request.getAttribute("dto");
String bno =""+ dto.getBno();
String bname = dto.getBname();
String btype = dto.getBtype();
String btitle = dto.getBtitle();
String bcontent = dto.getBcontent();
%>
<script>
$(document).ready(function(){
    $("select option[value='<%=btype%>']").attr("selected", true);
});
</script>
<script src="<%=request.getContextPath()%>/js/cq_js/cq_edit_script.js"></script>
<div class="container">
<h3 class ="h3margin">글&nbsp;수&nbsp;정</h3>

<form action = "<%=request.getContextPath()%>/BEdit.do?bno=<%=bno %>" method = "post" id="edit_submit">
<fieldset>
<legend>UPDATE</legend>
	<div class = "form-group">
	<label for = "bname">이름</label>
	<p class="panel" id="bname" style="padding:8px; border-color: gray; background-color: #e4e4e4;"><%=bname %></p>
	</div>
	<div class = "form-group">
	<label for = "btype">유형</label>
	<select id="btype" name="btype" class="form-control">
				<option value="">유형</option>
				<option value="회원정보문의">회원정보문의</option>
				<option value="쿠폰/포인트 문의">쿠폰/포인트 문의</option>
				<option value="주문/결제 관련 문의">주문/결제 관련 문의</option>
				<option value="취소/환불 관련 문의">취소/환불 관련 문의</option>
				<option value="배송 관련 문의">배송 관련 문의</option>
				<option value="서비스 개선 제안">서비스 개선 제안</option>
				<option value="시스템 오류 제보">시스템 오류 제보</option>
				<option value="기타 문의">기타 문의</option>
			</select>
	</div>
	<div class = "form-group">
	<label for = "btitle">제목</label>
	<input type ="text" class = "form-control" id ="btitle" name = "btitle" value="<%=btitle %>">
	</div>
	<div class = "form-group">
	<label for = "bcontent">내용</label>
	<textarea name = "bcontent" id = "bcontent" rows="10" cols="8" class="form-control"><%=bcontent %></textarea>
	</div>
	<div class = "form-group" style="text-align: right; margin-top:20px;">
		<input type ="submit" id = "update_btn" value="수정" class="btn btn-danger">
		<input type ="reset"  value="초기화" class="btn btn-danger">
		<input type ="button" value="목록보기" onclick="location.href='<%=request.getContextPath()%>/BList.do'" class="btn btn-danger">
	</div>
</fieldset>
</form>
</div>
<%@ include file ="/inc/footer.jsp" %>