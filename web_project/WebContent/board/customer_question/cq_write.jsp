<%@page import="com.son.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp"%>
<%request.setCharacterEncoding("UTF-8");
MemberDto dto =(MemberDto)request.getAttribute("dto");
%>
<script src="<%=request.getContextPath()%>/js/cq_js/cq_write_script.js"></script>
<div class="container panel panel-success" id="cq_write_container">
	<h3 id="customer_sound">고객의 소리</h3>
	<form action="<%=request.getContextPath()%>/BWrite.do" method="post" id="write_submit">
		<div class="form-group">
		<div class="row">
		<div class="col-sm-4">
			<select id="question_type" name="question_type" class="form-control">
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
			<div class="col-sm-4"></div>
			<div class="col-sm-4"><a href="#">상품/배송 등 쇼핑	 관련 문의는 고객센터</a></div>
			
		</div>
		<div class="row">
			<div class="col-sm-4">
				<p class="form-control"><%=dto.getMname() %></p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
					<p class="form-control"><%=dto.getMemail() %></p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-8">
				<input type="text" name = "btitle" id="btitle" placeholder="제목" class="form-control">
			</div>
		</div>
			<div class="row">
			<div class="col-sm-8">
				<textarea name = "bcontent" id="bcontent" maxlength="500" class="form-control"></textarea>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<input type="submit" id="write_btn" class="form-control btn btn-info" value="보내기">
			</div>
		</div>
		</div>
	</form>
</div>
<%@ include file="/inc/footer.jsp"%>
