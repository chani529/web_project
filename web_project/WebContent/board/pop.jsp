<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>팝업창</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <style>
  .notice{
	width: 90%;
    height: 90%;
    text-align: center;
    top: 20%;
    left: 20%;
    box-shadow: 0 0 5px;
    padding: 10px;
    border-radius: 20px;
    margin: 5%;
}
  </style>
</head>
<body>
<script>
$(function(){
	$("#close").on("click",function(){
		if($("input:checkbox[id=subpop]").is(":checked")==true){
			setCookie("notice", "1", 1);
		}		
			self.close();
	})
	   var setCookie = function(name, value, day) {
        var date = new Date();
        date.setTime(date.getTime() + day * 60 * 60 * 24 * 1000);
        document.cookie = name + '=' + value + ';expires=' + date.toUTCString() + ';path=/';
    };

})
</script>
<div class="container">
<div class="row">
<div class="col-sm-6">
   <div class="notice">
    	<h3>포트폴리오공지사항</h3>
    	<p>
    		본사이트는 상업적목적이 아닌 개인 포트폴리오 용도로 제작되었으며
    		홈페이지의 일부내용과 기타이미지 등은 그 출처가 따로 있음을 밝힙니다.
    	</p>
    	<p><img src="<%=request.getContextPath()%>/images/QRCodeImg.jpg" style="width: 200px;"> </p>
    	<p>
    	<input type="checkbox" id="subpop" name="subpop"/>
    	<label for ="subpop">오늘 하루동안 이창 열지 않음.</label>
    	<input type="button" value="[close]" class="btn btn-danger" id="close" onclick="closeView()"/>
    	</p>
    </div>
</div>
<div class="col-sm-6 r1">
<div class="row">
<div class="col-sm-12 text-center">
<h3>포트폴리오 소개영상</h3>
</div>
</div>
<div class="row">
<iframe width="400" height="250" src="https://www.youtube.com/embed/tibKGus0AWg" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>
</div>
</div>
</div>
</body>
</html>