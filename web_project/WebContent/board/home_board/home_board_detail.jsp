<%@page import="com.son.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/inc/header.jsp" %>
<div class="container" style="width: 75%;">
<div class="row">
<h3 class="h3margin"><strong>집들이사진</strong></h3>
</div>
<div class="row">
<div class="col-sm-8">
<p><img src="${pageContext.request.contextPath}/upload/${dto.bfile}" alt="${dto.bfile}" style="max-width: 100%; border-radius: 10px;"/></p>
<table class="table" style="width: 60%;">
<tr><th scope="row">건물</th><td>
<c:set var="res" value="${dto.residence}"/>
<c:choose>
<c:when test="${res == 0}">원룸&amp;오피스텔</c:when>
<c:when test="${res == 1}">아파트</c:when>
<c:when test="${res == 2}">빌라&amp;연립</c:when>
<c:when test="${res == 3}">단독주택</c:when>
<c:when test="${res == 4}">상업공간</c:when>
<c:when test="${res == 5}">사무공간</c:when>
<c:when test="${res == 6}">기타</c:when>
</c:choose>
</td></tr>
<tr><th scope="row">평수</th><td>${dto.realArea}</td></tr>
<tr><th scope="row">분야</th><td>
<c:set var="exp" value="${dto.expertise}"/>
<c:choose>
<c:when test="${exp == 0}">리모델링</c:when>
<c:when test="${exp == 1}">홈스타일링</c:when>
<c:when test="${exp == 2}">부분공사</c:when>
<c:when test="${exp == 3}">건축</c:when>
</c:choose>
</td></tr>
<tr><th scope="row">가족형태</th><td>${dto.family}</td></tr>
</table>

</div>
<div class="col-sm-4">
<h4><strong>온라인집들이</strong></h4>
<h5 class="strong_font">${dto.btitle}</h5>
<p class="small-font">${dto.bdate}</p>
<p><img src="${pageContext.request.contextPath}/upload/${dto.mimage}" alt="${dto.mimage}" class="hb_profile"/>  ${dto.mname}</p>
<p>조회 수 : ${dto.bhit}</p>
<c:if test="${sessionScope.mname==dto.mname}">
<div class="form-group">
<a class="btn btn-primary form-control" style="width: 45%; " href="${pageContext.request.contextPath}/HBEdit_view.hb?bno=${param.bno}">수정</a>
<a class="btn btn-primary form-control" style="width: 45%;" href="${pageContext.request.contextPath}/HBDelete.hb?bno=${param.bno}">삭제</a>
</div>
</c:if>
</div>
</div>
<div class="row">
<div class="col-sm-12">
<p style="word-break: break-all;">${dto.bcontent}</p>
</div>
</div>
</div>
<%@ include file ="/inc/footer.jsp" %>