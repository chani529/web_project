<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<script>
$(function(){
nav1();	
})
</script>
<div class="container" id="hb_list_container">
<h3 style="margin-bottom: 50px;">집들이</h3>
<div class="row">
<c:forEach var="item" items="${list.list}" varStatus="status">
<div class="col-sm-3 hb_posts">
<div class="row">
<p><a href="${pageContext.request.contextPath}/HBDetail_view.hb?bno=${item.bno}"><img src="${pageContext.request.contextPath}/upload/${item.bfile}" class="hb_images"/></a></p>
</div>
<div class="hb_list_info">
<div class="row">
<p class="hb_title">${item.btitle}</p>
</div>
<div class="row">
<c:set var="upload" value="${pageContext.request.contextPath}/upload/"/>
<c:if test="${item.mimage.indexOf(\"http\")!=-1}">
<c:set var="upload" value=""/>
</c:if>
<p><img src="${upload}${item.mimage}" alt="${item.mimage}" class="hb_profile"/> ${item.mname}</p>
</div>
<div class="row">
조회수 : ${item.bhit}
</div>
</div>
</div>
</c:forEach>
</div>
<div class="row">
<div class="form-group" style="margin-top:20px; text-align: center;">
<div class="btn-group" role="group">
<c:set var="page" value=""/>
<c:if test="${list.pno>110}">
<a href="${pageContext.request.contextPath}/HBList.hb?pno=${(list.bottom_start-2)*list.onPageLimit}" class="btn btn-info">이전</a>
</c:if>
<c:forEach var="i" begin="${list.bottom_start}" end="${list.bottom_end}" step="1" varStatus="status">
<c:set var="color" value="white"/>
  <a href="${pageContext.request.contextPath}/HBList.hb?pno=${(i-1)*12}" class="btn btn-default <c:if test="${i==list.bottom_current}"><c:set var="color" value="#9797bf"/></c:if>" style="background-color: ${color}">${i}</a>
</c:forEach>
<c:if test="${list.pageAll != list.bottom_end}">
<a href="${pageContext.request.contextPath}/HBList.hb?pno=${(list.bottom_end)*12}" class="btn btn-info">다음</a>
</c:if>
</div>
<div class="row">
<div class="col-sm-10"></div>
<div class="col-sm-2"><a href="${pageContext.request.contextPath}/HBWrite_view.hb" class="btn btn-info">글쓰기</a></div>
</div>
</div>
</div>
</div>
<%@ include file="/inc/footer.jsp" %>
