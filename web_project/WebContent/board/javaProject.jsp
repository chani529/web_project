<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<div class="container panel panel-info">
<div class="row">
<div class="col-sm-12">
<h3 class="panel-heading">JAVA PORTFOLIO</h3>
</div>
</div>
<div class="row">
<div class="col-sm-7">
<iframe width="560" height="315" src="https://www.youtube.com/embed/QXf2BGvu9wM" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>
<div class="col-sm-5">
<pre style="white-space: pre-wrap; font-size: 15px;">
Java Swing기반의 편의점 할인 정보 검색, 등록이 가능한 프로그램을 목표로 시작하였으며,
스레드를 이용해  프로그램 실행 시 펴늬라는 편의점 할인 정보를 크롤링하여 정보를 지속적으로 갱신하도록 구성하였습니다.
 주요 기능으론 TCP/IP를 이용한 소켓 통신, 파일 출력, 캘린더, 상품 crud,  유저 crud등이 있습니다.
</pre>
<a href="<%=request.getContextPath()%>/upload/Java_project.zip" class="btn btn-info">다운로드</a>
</div>
</div>
</div>
<%@ include file="/inc/footer.jsp" %>