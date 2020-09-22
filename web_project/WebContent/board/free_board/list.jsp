<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="/inc/header.jsp" %>
<!--  END HEADER -->
<!--  END HEADER -->

<div class="container">
	<h3>자유게시판</h3>
	<table  class="table table-hover">
	<colgroup>
		<col width="10%"/>
		<col width="*"/>
		<col width="10%"/>
		<col width="20%"/>
		<col width="10%"/>
	</colgroup>
		<thead>
			<tr><th scope="col">번호</th><th scope="col">제목</th>
			      <th scope="col">글쓴이</th><th scope="col">작성일</th><th scope="col">조회</th></tr>
		</thead>
		<tbody>
			 <c:forEach var="item" items="${list.list}" varStatus="status">
			 <tr>
			 <td>${list.list.size()-status.index}</td>
			 <td class="text-left"><a href="${pageContext.request.contextPath}/detail.reply?bno=${item.bno}">${item.btitle}</a></td>
			 <td>${item.bname}</td>
			 <td>${item.bdate}</td>
			 <td>${item.bhit}</td>
			 </tr>
			 </c:forEach>
		</tbody>
	</table>
	<div class="row">
<div class="form-group" style="margin-top:20px; text-align: center;">
<div class="btn-group" role="group">
<c:set var="page" value=""/>
<c:if test="${param.pno>10}">
<a href="${pageContext.request.contextPath}/list.reply?pno=${(list.bottom_start-1)}" class="btn btn-info">이전</a>
</c:if>
<c:forEach var="i" begin="${list.bottom_start}" end="${list.bottom_end}" step="1" varStatus="status">
<c:set var="color" value="white"/>
  <a href="${pageContext.request.contextPath}/list.reply?pno=${(i)}" class="btn btn-default <c:if test="${(i)==list.bottom_current}"><c:set var="color" value="#9797bf"/></c:if>" style="background-color: ${color}">${i}</a>
</c:forEach>
<c:if test="${list.pageAll != list.bottom_end}">
<a href="${pageContext.request.contextPath}/list.reply?pno=${list.bottom_end+1}" class="btn btn-info">다음</a>
</c:if>
</div>
<div class="row">
<div class="col-sm-10"></div>
<div class="col-sm-2"><a href="${pageContext.request.contextPath}/write_view.reply" class="btn btn-info">글쓰기</a></div>
</div>
</div>
</div>
</div>

<!-- END FOOTER -->
<!-- END FOOTER -->
<%@ include  file="/inc/footer.jsp" %>