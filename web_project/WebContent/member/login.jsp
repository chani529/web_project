<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/inc/header.jsp" %>
  <script src="<%=request.getContextPath()%>/js/login.js"> </script>
   <script>
   $(function(){
	   <%
	   String cookie = request.getHeader("Cookie");
	   String nameCookie = null;
	   String noticeCookie = null;
	   if(cookie!=null){
	 	  Cookie[] cookies = request.getCookies();
	 	  for(int i =0;i<cookies.length;i++){
	 		  if(cookies[i].getName().equals("nameCookie")){
	 			  nameCookie=cookies[i].getValue();
	 			  break;
	 		  }
	 	  }
	   }
	   %>
	
   })
    </script>
<div class ="container" id="login_view_container">
<div style="text-align: center;">
<h3 id="main_icon_href"><a href="<%=request.getContextPath()%>/login_view.members"><img src="<%=request.getContextPath()%>/images/main_icon.PNG"/></a></h3>
</div>
<form action = "<%=request.getContextPath()%>/login.members" method ="post" id="login_submit">
<fieldset>
<div class="form-group">
<input type="text" placeholder="이메일" name = "memail" id = "memail" maxlength="30" class="form-control" 
<% if(nameCookie!=null){  %>
value="<%=nameCookie %>">
<% } %>
</div>
<div class="form-group">
<input type="password" placeholder="비밀번호" name = "mpass" id = "mpass" maxlength="20" class="form-control">
</div>

<div class="form-group">
<input type="checkbox" name = "id_chkbox" id = "id_chkbox"
<% if(nameCookie!=null){  %>
	checked 
<%} %>
>
<label for="id_chkbox" style="margin-top:10px">아이디기억하기</label>
</div>
<div class="form-group" style="text-align: right">
<input type="submit" id = "login_btn" value="로그인" class = "btn btn-info btn-block basic_btn"/>
</div>
</fieldset>
</form>
<div class = "form-group" style="text-align: center;" id="login_href">
<a href="<%=request.getContextPath()%>/join_view.members" class="blackhref">회원가입</a>
</div>

<div class = "form-group" style="text-align: center; margin-bottom: 100px;">
<p class="grayPoint">SNS계정으로 간편 로그인/회원가입</p>
<p>
<div class="row">
<div class="col-sm-4">
<script src="https://apis.google.com/js/platform.js"></script>
<div class="g-signin2" id="google_btn" data-onsuccess="onSignIn"></div>
    <script>
        function onSignIn(googleUser) {
            var profile = googleUser.getBasicProfile();
            var id_token = googleUser.getAuthResponse().id_token;
            console.log("ID Token: " + id_token);
        	$.ajax({
        		url:"${pageContext.request.contextPath}/GoogleLogin",
        		type:"post",
        		dataType:"text",
        		data:{"foreignid":profile.getId(),"mname":profile.getName(),"mimage":profile.getImageUrl(),"memail":profile.getEmail()},
        		success:function(text){
				location.href="${pageContext.request.contextPath}/mypage_view.members"
        		}
        		})
        };
    </script>
    </div>
    <div class="col-sm-2"></div>
    <div class="col-sm-4">
<a href = "https://kauth.kakao.com/oauth/authorize?client_id=da2939f67a392415c27c151203c6e60f&redirect_uri=http://diffkdl529.cafe24.com/t001/KakaoLogin&response_type=code">
<img src="<%=request.getContextPath()%>/images/kakao_login_medium_narrow.png" id="kakaoIcon" alt="kakao_icon"/>
</a>
</div>
</div>
</div>

</div>
<%@ include file ="/inc/footer.jsp" %>