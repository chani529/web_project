<%@page import="com.son.dto.MemberDto"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp"%>
<script src="<%=request.getContextPath()%>/js/edit.js"></script>
<%
	request.setCharacterEncoding("utf-8");
MemberDto dto = (MemberDto) request.getAttribute("dto");
%>
<div class="container panel panel-success" id="mypage_edit_container"
	style="margin-top: 100px; padding: 50px;">
	<h3 style="margin-bottom: 50px;">회원정보수정</h3>
	<form action="<%=request.getContextPath()%>/mypage_edit.members"
		method="post" id="edit_submit" enctype="multipart/form-data">
		<fieldset>
			<div class="container" style="width: 55%; float: left;">
				<div class="row">
					<div class="col-sm-2">
						<label>이메일</label>
						<p>*필수항목</p>
					</div>
					<div class="col-sm-5">
						<p class="form-control"><%=dto.getMemail().substring(0, dto.getMemail().indexOf('@'))%></p>
					</div>
					<div class="col-sm-1" style="margin-top: 5px;">@</div>
					<div class="col-sm-4">
						<p class="form-control"><%=dto.getMemail().substring(dto.getMemail().indexOf('@') + 1)%></p>
					</div>
				</div>
				<c:if test="<%=dto.getForeignid()==null%>">
				<div class="row" style="margin-top: 50px;">
					<div class="col-sm-2">
						<label for="mpass">패스워드</label>
						<p>*필수항목</p>
					</div>
					<div class="col-sm-10">
						<input type="password" name="mpass" id="mpass"
							class="form-control" />
					</div>
				</div>
				<script>
				jQuery(document).ready(function(){
					jQuery("#edit_btn").submit(function(){
						if($("#bpass").val()==("")){
							alert("패스워드가 빈칸입니다");
							$("#bpass").focus();
							return false;
						}
					})
				})
				</script>
				</c:if>
				<div class="row" style="margin-top: 50px;">
					<div class="col-sm-2">
						<label for="mname">별명</label>
						<p>*필수항목</p>
					</div>
					<div class="col-sm-10">
						<input type="text" name="mname" id="mname" class="form-control"
							value="<%=dto.getMname()%>">
					</div>
				</div>
				<div class="row" style="margin-top: 50px;">
					<div class="col-sm-2">
						<label for="mbirthday" style="margin-top: 7px;">생년월일</label>
					</div>
					<div class="col-sm-10">
						<input type="date" name="mbirthday" id="mbirthday"
							class="form-control">
					</div>
				</div>
				<div class="row" style="margin-top: 50px;">
					<div class="col-sm-2">
						<label for="mimage">프로필<br>이미지
						</label>
					</div>
					<div class="col-sm-10">
						<div class="mimage_view">
							<img src="${pageContext.request.contextPath}/upload/${dto.mimage}" alt="${dto.mimage}" class="profile_view"/>
						</div>

						<input type="file" id="mimage" name="mimage" class="form-control"
						 onchange="setThumbnail(event);"  />
		<script>
		function setThumbnail(event) {
			$(".mimage_view").empty();
			var reader = new FileReader();
			reader.onload = function(event) {
				var img = $("<img>").attr("src", event.target.result).addClass("profile_view");
				$(".mimage_view").html(img); };
				reader.readAsDataURL(event.target.files[0]);
			}
		</script>
					</div>
				</div>
				<div class="row" style="margin-top: 50px;">
					<div class="col-sm-2">
						<label for="mintro" style="margin-top: 7px;">한줄 소개</label>
					</div>
					<div class="col-sm-10">
						<input type="text" name="mintro" id="mintro" class="form-control"
							<%if (dto.getMintro() != null) {%> value="<%=dto.getMintro()%>"
							<%}%>>
					</div>
				</div>
				<div class="row" style="margin-top: 50px;">
					<div class="col-sm-2"></div>
					<div class="col-sm-8">
						<input type="submit" name="update_btn" id="update_btn"
							class="form-control btn btn-info" value="회원정보수정">
					</div>
				</div>
				<div class="form-group"
					style="text-align: right; margin: 20px 0px 10px 0px;"></div>
			</div>
		</fieldset>
	</form>
	
</div>
<%@ include file="/inc/footer.jsp"%>