<%@page import="com.son.dto.MemberDto"%>
<%@page import="java.net.InetAddress"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/inc/header.jsp" %>
<script src="${pageContext.request.contextPath}/js/delete.js"></script>
<div class = "container">
<div class="container"  style="width: 1000px;">
<h3 class ="panel-heading">나의 프로필</h3>
<div id="left">
<c:set var="upload" value="${pageContext.request.contextPath}/upload/"/>
<c:if test="${dto.mimage.indexOf(\"http\")!=-1}">
<c:set var="upload" value=""/>
</c:if>
<img src="${upload}${dto.mimage}" style="height: 150px; width: 150px; margin:auto; border-radius: 100px;"/>
<p class="strong_font" style="margin-top:20px;">${dto.mname}</p>

<div id = "content">
<table class = "table table-striped">
<caption>M&nbsp;Y&nbsp;P&nbsp;A&nbsp;G&nbsp;E</caption>
<colgroup>
		<col width="30%"/>
		<col width="*"/>
</colgroup>
<tbody>
	<tr><th scope="row">이메일</th><td>${dto.memail}</td></tr>
	<tr><th scope="row">별명</th><td>${dto.mname}</td></tr>
	<tr><th scope="row">가입날짜</th><td>${dto.mdate.substring(0,10)}</td></tr>
</tbody>
</table>
</div>
</div>
<div id="mypage_content">
<h3>구매 이력</h3>
<div class="row">
<table class="table">
	<colgroup>
		<col width="18%"/>
		<col width="10%"/>
		<col width="*"/>
		<col width="30%"/>
	</colgroup>
<thead>
<tr>
	<th scope="col">주문일(결제 금액)</th>
	<th scope="col" colspan="2">상품명/주문옵션/주문번호</th>
	<th scope="col">배송지</th>
</tr>
</thead>
<tbody>
<c:forEach var="list" items="${list}" varStatus="status">
<tr style= "border-top: 2px solid;">
<td>${list.bdate}</td>
<c:set var="upload" value="${pageContext.request.contextPath}/upload/${list.simage}"/>
<c:if test="${list.simage.indexOf(\"http\")!=-1}">
<c:set var="upload" value="${list.simage}"/>
</c:if>
	<td rowspan="2"><img src="${upload}" alt="구매상품사진" style="width: 90px;"></td>
	<td><strong>${list.sname}</strong></td>
	<td rowspan="2">${list.address}</td>
</tr>
<tr>
	<td rowspan="2">${list.bprice}원</td>
</tr>
<tr>
	<td>구매옵션</td>
	<td>${list.option_content}</td>
	<td>${list.address1}</td>
</tr>

</c:forEach>
</tbody>
</table>

</div>
<c:if test="${list=='[]'}">
<strong>구매 이력이 없습니다</strong>
</c:if>
</div>
</div>
<div class="form-group"  style="text-align:center; margin: 20px 0px 10px 0px;">
<input type="button" id = "edit_btn" value="회원정보 수정" class = "btn btn-success"
onclick="location.href='${pageContext.request.contextPath}/mypage_edit_view.members'"/>
<c:if test="${dto.mpass!=null}">
<input type="button" id = "pass_edit_btn" value="비밀번호 수정" class = "btn btn-success"
onclick="location.href='${pageContext.request.contextPath}/mypage_pass_view.members'"/>
</c:if>
<input type="button" id = "delete_btn" value="탈퇴" class = "btn btn-success"
onclick="location.href='${pageContext.request.contextPath}/mypage_view.members'"/>
</div>
</div>
<%@ include file="/inc/footer.jsp" %>
