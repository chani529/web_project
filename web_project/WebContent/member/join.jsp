<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<script src="<%=request.getContextPath()%>/js/join.js"></script>
<script>
$(function(){
	$("#email_menu, #memail").on("change",function(){
		if($("#memail").val()!=""&&$("#email_menu").val()!=""){
			$.ajax({
				url:"${pageContext.request.contextPath}/DoubleEmail",
				type:"get",
				dataType:"text",
				data:{"memail":$("#memail").val(),"email_menu":$("#email_menu").val()},
				success:function(text){
					if(text != 0){
						$("#memail").parent().parent().parent().find("label").css("color","red");
						$("#memail").css("border","1px solid red");
		  				$("#email_menu").css("border","1px solid red");
		  				$("#memail").parent().find(".redfont").css("color","red");	
		  				$("#memail").parent().find(".redfont").html($("#memail").val()+"@"+$("#email_menu").val()+"은(는) 중복된 이메일입니다");	
		  				$("#memail").parent().find(".redfont").show();
		  				$("#memail").parent().find(".margin20").hide();
						$("#memail").val("");
						$("#memail").focus();
					}else{
						$("#memail").parent().parent().parent().find("label").css("color","black");
						$("#memail").css("border","1px solid #ccc");
		  				$("#email_menu").css("border","1px solid #ccc");
		  				$("#memail").parent().find(".redfont").css("color","blue");	
		  				$("#memail").parent().find(".redfont").html("사용가능한 이메일입니다");	
		  				$("#memail").parent().find(".redfont").show();	
					}
				}
			})//ajax
		}
	})
	
	$("#mname").on("change",function(){
		if($("#mname").val()!=""){
			$.ajax({
				url:"${pageContext.request.contextPath}/DoubleMname",
				type:"get",
				dataType:"text",
				data:{"mname":$("#mname").val()},
				success:function(text){
					if(text != 0){
						$("#mname").parent().find("label").css("color","red");
						$("#mname").css("border","1px solid red");
		  				$("#mname").parent().find(".redfont").css("color","red");	
		  				$("#mname").parent().find(".redfont").html($("#mname").val()+"은(는) 중복된 별명입니다");	
		  				$("#mname").parent().find(".margin20").hide();
		  				$("#mname").parent().find(".redfont").show();
		  				$("#mname").val("");
						$("#mname").focus();
					}else{
						$("#mname").parent().find("label").css("color","black");
						$("#mname").css("border","1px solid #ccc");
		  				$("#mname").parent().find(".redfont").css("color","blue");	
		  				$("#mname").parent().find(".redfont").html("사용가능한 별명입니다");
		  				$("#mname").parent().find(".margin20").hide();
		  				$("#mname").parent().find(".redfont").show();	
					}
				},
				error:function(){
				}
			})//ajax
		}
	})
})
</script>
<div class="container" id="join_view">
	<h3 style="margin-bottom: 30px;">회원가입</h3>
	
	<form action="<%=request.getContextPath()%>/join.members" method="post">
		<fieldset>
			<legend>필수정보입력</legend>
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label for="memail">(*) 이메일</label>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<input type="text" name="memail" id="memail" class="form-control">
						<p class="margin20">필수 입력 항목입니다.</p>
						<p class="redfont">이메일 중복입니다</p>
					</div>
					<div class="col-sm-1">@</div>
					<div class="col-sm-5">
						<select id="email_menu" name="email_menu" class="form-control">
							<option value="">선택해주세요</option>
							<option value="naver.com">naver.com</option>
							<option value="hanmail.net">hanmail.net</option>
							<option value="daum.net">daum.net</option>
							<option value="gmail.com">gmail.com</option>
							<option value="hotmail.com">hotmail.com</option>
							<option value="outlook.com">outlook.com</option>
							<option value="icloud.com">icloud.com</option>
						</select>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="mpass">(*) 비밀번호</label>
				<p class="grayPoint">8자 이상 입력해주세요</p>
				<input type="password"
					name="mpass" id="mpass" class="form-control">
					<p class="margin20">필수 입력 항목입니다.</p>
			</div>
			<div class="form-group">
				<label for="mpass_chk">(*) 비밀번호 확인</label>
				<input type="password"
					name="mpass_chk" id="mpass_chk" class="form-control"/>
					<p class="margin20">확인을 위해 비밀번호를 한 번 더 입력해주세요.</p>
			</div>
			<div class="form-group" id="join_agree">
				<label for="mname">(*) 별명</label>
				<p class="grayPoint">다른 유저와 겹치지 않는 별명을 입력해주세요 (2~15자)</p>
				<input type="text" name="mname"
					id="mname" class="form-control"/>
					<p class="margin20">필수 입력 항목입니다.</p>
					<p class="redfont">별명 중복입니다</p>
			</div>
			<div class="form-group" id="terms">
				<label for="allCheck">(*) 약관동의</label>
				<div class="panel panel-info" style="padding: 20px;">
				<div class="form-group">
					<input type="checkbox" id="allCheck">
					<label for="allCheck"><strong>전체동의</strong></label>
				</div>
					<hr/>
				<div class="form-group">
					<input type="checkbox" id="ageCheck" class="chk" name="chkbox">
					<label for="ageCheck">만 14세 이상입니다. <span class="bluePoint">(필수)</span></label>
				</div>
				<div class="form-group">
					<input type="checkbox" id="agreeCheck1" class="chk" name="chkbox">
					<label for="agreeCheck1"><a data-toggle="modal" data-target="#agree1" class="underandblack">이용약관</a><span class="bluePoint"> (필수)</span></label>
				</div>
				<div class="form-group">
					<input type="checkbox" id="agreeCheck2" class="chk" name="chkbox">
					<label for="agreeCheck2"><a data-toggle="modal" data-target="#agree2" class="underandblack">개인정보처리방침</a><span class="bluePoint"> (필수)</span></label>
				</div>
				<div class="form-group">
					<input type="checkbox" id="optionCheck" class="chk">
					<label for="optionCheck">이벤트,프로모션 알림 메일 및 SMS 수신 <span class="grayPoint">(선택)</span></label>				
				</div>
				</div>
			</div>

			<div class="form-group">
				<input type="submit" name="sign_btn" value="회원가입 완료" id="sign_btn"
					class="btn btn-info btn-block basic_btn">
			</div>
			<div class="form-group" style="text-align: right;">
				<p>이미 아이디가 있으신가요?<a href="<%=request.getContextPath()%>/login_view.members">로그인</a></p>
			</div>
		</fieldset>
	</form>
	
	<div class="modal fade" id="agree1" role="dialog" style="margin-top: 150px;">
	<div class="modal-dialog">
	<div class="modal-content">
	<div class="modal-header">
	<h4 class="modal-title">이용약관</h4>
	<div class="modal-body" style="height: 300px; overflow-y: scroll;">
	<pre style="white-space: pre-line;">
	<%@ include file="/src/agree1.txt" %>
	</pre>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
	</div>
	</div>
	</div>
	</div>
	</div>
	
	<div class="modal fade" id="agree2" role="dialog" style="margin-top: 150px;">
	<div class="modal-dialog">
	<div class="modal-content">
	<div class="modal-header">
	<h4 class="modal-title">개인정보처리방침</h4>
	<div class="modal-body" style="height: 300px; overflow-y: scroll;">
	<pre style="white-space: pre-line;">
	<%@ include file="/src/agree2.txt" %>
	</pre>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
	</div>
	</div>
	</div>
	</div>
	</div>
</div>
<%@ include file="../inc/footer.jsp"%>
