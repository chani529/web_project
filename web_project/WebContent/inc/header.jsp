<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
  <!-- Theme Made By www.w3schools.com -->
  <title>주거상점</title>
  <meta charset="utf-8">
  <meta name = "google-signin-client_id"content = "388475400021-b6sfkp270nqn165evo3l1ko1a0t9o2hp.apps.googleusercontent.com">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="images/icon.png" rel="shortcut icon" type="images.x-icon">
  <link href="images/icon.png" rel="icon" type="images.x-icon">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/mycss.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
<script>
const ctx = "<%=request.getContextPath()%>";
function getContextPath(){
	return ctx;
}
var nav1=  function(){
	$(".tab-content").empty();
	var a1 = $("<a>").attr("href",'${pageContext.request.contextPath}/list.reply').html("자유게시판");
	var li1 = $("<li>").append(a1);
	var a2 = $("<a>").attr("href",'${pageContext.request.contextPath}/HBList.hb').html("집들이");
	var li2 = $("<li>").append(a2);
	var a3 = $("<a>").attr("href",'${pageContext.request.contextPath}/BList.do').html("질문과답변");
	var li3 = $("<li>").append(a3);
	var ul = $("<ul>").addClass("nav navbar-nav").append(li1).append(li2).append(li3);
	$(".tab-content").append(ul);
}
var nav2=  function(){
	$(".tab-content").empty();
	var a1 = $("<a>").attr("href",'${pageContext.request.contextPath}/SList.st').html("스토어홈");
	var li1 = $("<li>").append(a1);
	var a7 = $("<a>").attr("href",'${pageContext.request.contextPath}/SCart.st').html("장바구니");
	var li7 = $("<li>").append(a7);
	var ul = $("<ul>").addClass("nav navbar-nav").append(li1).append(li7);
	$(".tab-content").append(ul);
}
$(function(){
	$(".nav_commu").mouseover(function(){
		nav1();
	})
	$(".nav_store").mouseover(function(){
		nav2();
	})
	$("#header_nav  li:first").addClass("active");
	$("#header_nav  li:first").mouseover();
	$("#header_nav  li").on("mouseover  click" , function(){
		$("#header_nav  li").removeClass("active");
		$(this).addClass("active");
		$(".nav-pills>li >a").css({"color":"black"});
		$(this).find("a").css({"color":"#547afe"});
	});
	$("#search_btn").on("click",function(){
		if($("#header_search").val()==""){
			alert('빈칸입니다');
			$("#header_search").foucs();
			return false;
		}
	})
})
</script>
<nav class="navbar navbar-default">
  <div class="container">
  <div class="row header_bar">
    <div class="col-sm-1 navbar-header">
    <h1 class="myhidden">주거상점</h1>
      <p><a class="navbar-brand" href="${pageContext.request.contextPath}/SList.st"><img src="${pageContext.request.contextPath}/images/main_typo.PNG" alt="주거상점"/></a></p>
    </div>
    <div class="collapse navbar-collapse col-sm-2" id="myNavbar">
    <h2 class="myhidden">주메뉴</h2>
      <ul class="nav nav-pills" id="header_nav">
	      <li class="nav_commu"><a data-toggle="tab" href="#commu_bar">커뮤니티</a></li>
	      <li class="nav_store"><a href="#">스토어</a></li>
	      <li class="nav_inter"><a href="${pageContext.request.contextPath}/board/javaProject.jsp">JAVA</a></li>
      </ul>
     </div>
     <div class="col-sm-4" id ="header_search_bar">
     <form action="<%=request.getContextPath()%>/Search.st" method="get">
     <fieldset>
      <div class="input-group">
      <input type="search" name="search" id="header_search" class="form-control" placeholder="상품 검색"/>
      <div class="input-group-btn">
      <button class="btn btn-default" type="submit" id="search_btn">
        <i class="glyphicon glyphicon-search"></i>
      </button>
      </div>
      </div>
     </fieldset>
     </form>
      </div>
      <div class="col-sm-3" id="login_navbar">
      <ul class="nav navbar-nav navbar_menu">
      <% if(session.getAttribute("mname")!=null){out.println("<li><a href='"+request.getContextPath()+"/logout.members'>로그아웃</a></li>");}%>
       <%if(session.getAttribute("mname")!=null){
		  out.println("<li><a href='"+request.getContextPath()+"/mypage_view.members'>유저정보</a></li>");
	  } else{
		  out.println("<li><a href='"+request.getContextPath()+"/login_view.members'>로그인</a></li>");
		  out.println("<li><a href='"+request.getContextPath()+"/join_view.members'>회원가입</a></li>");
	  }
	  %>
      </ul>
    </div>
    </div>
    </div>
    <div class="jumbotron">
     <div class="tab-content"></div>
    </div>
</nav>
