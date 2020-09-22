<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<%@page import="java.sql.*"%>

<div class="container">
	<h3>자유게시판</h3> 					
	<div class="panel" >
	  <div  class="panel-body"> 
	  		<span class="glyphicon glyphicon-plus">  조회수</span>
	  		<p>${dto.bhit}</p>
	</div>	
	</div>	
	<div class="panel"  >
	  <div  class="panel-body">
	  		<span class="glyphicon glyphicon-plus">  이름</span> 
			<p>${dto.bname}</p>
		</div>
	</div>				
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus">  제목</span> 
	     <p>${dto.btitle}</p>
	  </div>	
	</div>
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus">  내용</span>
	  	<p>${dto.bcontent}</p>
	  </div> 
	</div>	
	<div class="text-right"    >
		 <a href="${pageContext.request.contextPath}/edit_view.reply?bno=${dto.bno}"  class="btn btn-danger" >수정</a> 
		 <a href="${pageContext.request.contextPath}/delete.reply?bno=${dto.bno}"  class="btn btn-danger" >삭제</a>    
		 <a href="${pageContext.request.contextPath}/reply_view.reply?bno=${dto.bno}"  class="btn btn-danger" >답변</a>    
		 <a href="${pageContext.request.contextPath}/list.reply"  class="btn btn-info" >목록보기</a> 
	</div>						 
</div>	
<%@ include file="/inc/footer.jsp" %>
