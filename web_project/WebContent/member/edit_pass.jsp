<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/inc/header.jsp" %>
<script src="<%=request.getContextPath()%>/js/edit_pass.js"></script>
<%request.setCharacterEncoding("utf-8");
String mname=(String)session.getAttribute("mname");; %>
<div class = "container panel panel-success" id="edit_pass_view_container">
<h3>비밀번호변경</h3>
<form action="<%=request.getContextPath()%>/mypage_pass.members" method="post">
<fieldset>
<legend>새 비밀번호</legend>
<div class ="form-group">
<label for="mpass">현 비밀번호</label>
<input type="password" class="form-control" id="mpass" name="mpass">
</div>
<div class ="form-group">
<label for="change_mpass">새 비밀번호</label>
<p>8자 이상 입력해주세요.</p>
<input type="password" class="form-control" id="change_mpass" name="change_mpass">
</div>
<div class ="form-group">
<label for="mpass_chk">새 비밀번호 확인</label>
<input type="password" class="form-control" id="mpass_chk">
</div>
<div class = "form-group"  style="text-align: right; margin: 20px 0px 10px 0px;">
<input type="submit" name = "update_btn" id = "update_btn" class ="form-control btn btn-info" value="회원정보수정">
</div>
</fieldset>
</form>
</div>
<%@ include file ="/inc/footer.jsp" %>