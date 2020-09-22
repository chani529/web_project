<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<div class="container">
<h3>검색 결과</h3>
<div class="row form-group storeList">
<c:forEach var="list" items="${list.list}" varStatus="status">
<div class="col-sm-4 form-group hei320" onclick="location.href='${pageContext.request.contextPath}/SDetail.st?sno=${list.sno}'">
<c:set var="upload" value="${pageContext.request.contextPath}/upload/${list.simage}"/>
<c:if test="${list.simage.indexOf(\"http\")!=-1}">
<c:set var="upload" value="${list.simage}"/>
</c:if>
<img class="hb_images form-group" alt="${list.simage}" src="${upload}"/>
<p class="production_brand">${list.smaker}</p>
<p class="production_sname">${list.sname}</p>
<span class="production_ssale">${list.ssale}%</span><span class="production_sprice">${list.sprice}원</span>
<c:if test="${list.sdelivery!=0}">
<p class="btn btn-default freeDelivery">무료배송</p>
</c:if>
</div>
</c:forEach>
</div>
<div class="form-group" style="margin-top:20px; text-align: center;">
<div class="btn-group" role="group">
<c:set var="page" value=""/>
<c:if test="${param.pno>10}">
<a href="${pageContext.request.contextPath}/Search.st?pno=${(list.bottom_start-1)}&search=${param.search}" class="btn btn-info">이전</a>
</c:if>
<c:forEach var="i" begin="${list.bottom_start}" end="${list.bottom_end}" step="1" varStatus="status">
<c:set var="color" value="white"/>
  <a href="${pageContext.request.contextPath}/Search.st?pno=${i}&search=${param.search}" class="btn btn-default <c:if test="${(i)==list.bottom_current}"><c:set var="color" value="#9797bf"/></c:if>" style="background-color: ${color}">${i}</a>
</c:forEach>
<c:if test="${list.pageAll != list.bottom_end}">
<a href="${pageContext.request.contextPath}/Search.st?pno=${list.bottom_end+1}&search=${param.search}" class="btn btn-info">다음</a>
</c:if>

<c:if test="${list.list == '[]'}">
<div class="text-center">
<img src="${pageContext.request.contextPath}/images/cute.png" alt="검색 결과가 없습니다.">
<h3>검색 결과가 없습니다</h3>
<a href="${pageContext.request.contextPath}/SList.st" class="btn btn-info basic_btn">홈으로 가기</a>
</div>
</c:if>
</div>
</div>
</div>
<%@ include file="/inc/footer.jsp" %>