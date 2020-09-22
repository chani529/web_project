<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<div class ="container" id="login_view_container">
<div style="text-align: center;">
<h3 id="main_icon_href"><a href="<%=request.getContextPath()%>/login_view.members"><img src="<%=request.getContextPath()%>/images/icon.png" alt="main_icon"/><img src="<%=request.getContextPath()%>/images/main_typo.PNG"/></a>
<br/>관리자 로그인</h3>
</div>
<form action = "<%=request.getContextPath()%>/admin.admin" method ="post" id="login_submit">
<fieldset>
<div class="form-group">
<input type="text" placeholder="이메일" name = "memail" id = "memail" class="form-control"/>
</div>
<div class="form-group">
<input type="password" placeholder="비밀번호" name = "mpass" id = "mpass" class="form-control">
</div>
<div class="form-group" style="text-align: right">
<input type="submit" id = "login_btn" value="로그인" class = "btn btn-info btn-block basic_btn"/>
</div>
</fieldset>
</form>
</div>

<%@ include file="/inc/footer.jsp" %>
