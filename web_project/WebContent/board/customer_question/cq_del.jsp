<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/inc/header.jsp" %>
<%request.setCharacterEncoding("utf-8");
String bno = request.getParameter("bno");
String n = request.getParameter("n");
%>
<script src="<%=request.getContextPath()%>/js/del_script.js"></script>
<div class ="container">
<h3 class ="h3margin">삭&nbsp;제</h3>
<form action ="<%=request.getContextPath()%>/BDelete.do?&bno=<%=bno %>" method="post" id = "delete_btn">
<fieldset>
<label for="bpass">비밀번호</label>
<input type ="password" class ="form-control" id ="bpass" name = "bpass">
<p>(*)수정, 삭제시 필수입니다.</p>
<div class = "form-group" style = "text-align: right;">
<input type="submit" id = "del_btn" value = "확 인" class="btn btn-danger">
<input type="button" id = "back_btn" value = "취 소" onclick="location.href='<%=request.getContextPath()%>/BDetail?bno=<%=bno %>'" class="btn btn-danger">
</div>
</fieldset>
</form>
</div>
<%@ include file ="/inc/footer.jsp" %>