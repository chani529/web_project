<%@page import="com.son.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/inc/header.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
BoardDto dto = (BoardDto)request.getAttribute("dto");
int bno = dto.getBno();
int bhit = dto.getBhit();
String btype = dto.getBtype();
String bname =dto.getBname();
String btitle =dto.getBtitle();
String bcontent = dto.getBcontent().replace("\r\n", "<br>");
%>
<div class = "container">
<h3 class="h3margin">상&nbsp;세&nbsp;보&nbsp;기</h3>
<div class = "form-group" style="margin-top: 20px;">
	<label for ="bhit"><span class="glyphicon glyphicon-plus"></span> 조회수</label>
	<p id = "bhit"><%=bhit %></p>
</div>
	<div class="form-group" style="margin-top:20px;">
		<label for="bname"><span class="glyphicon glyphicon-plus"></span> 이름</label>
		<p class="panel" id="bname" style="padding:8px; border-color: gray; background-color: #e4e4e4;"><%=bname %></p>
	</div>
	<div class="form-group" style="margin-top:20px;">
		<label for="btype"><span class="glyphicon glyphicon-plus"></span> 유형</label>
		<p class="panel" id="btype" style="padding:8px; border-color: gray; background-color: #e4e4e4;"><%=btype %></p>
	</div>
	<div class="form-group" style="margin: 30px 0px 0px 0px;">
		<label for="btitle"><span class="glyphicon glyphicon-plus"></span> 제목</label>
		<p class="panel" id="btitle" style="padding:8px; border-color: gray; background-color: #e4e4e4;"><%=btitle %></p>
	</div>
	<div class="form-group" style="margin: 30px 0px 0px 0px;">
		<label for="bcontent"><span class="glyphicon glyphicon-plus"></span> 내용</label>
	<p class="panel" id="bcontent" style="padding:8px; border-color: gray; background-color: #e4e4e4; word-break: break-all;" ><%=bcontent %></p>
	<div class="containel" style="text-align: right">
	<input type ="button" value ="수정" class="btn btn-danger" onclick="location.href='<%=request.getContextPath()%>/BEdit_view.do?bno=<%=bno %>'">
	<input type ="reset"  value ="삭제" class="btn btn-danger" onclick="location.href='<%=request.getContextPath()%>/BDelete_view.do?bno=<%=bno %>'">
	<input type ="button"  value ="목록보기"  class="btn btn-danger" onclick="location.href='<%=request.getContextPath()%>/BList.do'">
	</div>
	</div>
</div>
<%@ include file ="/inc/footer.jsp" %>