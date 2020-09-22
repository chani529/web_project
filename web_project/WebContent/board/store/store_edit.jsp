<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
<div class="container panel panel-info">
<h3 class="panel-heading top_margin">test</h3>
<form action="${pageContext.request.contextPath}/SEdit.st" method="post"
enctype="multipart/form-data" id="post_submit">
<fieldset>
<div class="row">
<div class="col-sm-4">
<div class="form-group">
<label for="scategory">카테고리</label>
<select id="scategory" class="form-control">
<option>소파/거실가구</option>
<option>침실/가구</option>
<option>침실가구</option>
<option>드레스룸</option>
<option>학생/서재가구</option>
<option>수납가구</option>
<option>테이블</option>
<option>의자/스툴</option>
<option>유아용가구</option>
</select>
</div>
</div>
<div class="col-sm-4">
<div class="form-group">
<label for="sub_scategory">카테고리</label>
<select id="sub_scategory" class="form-control">
</select>
</div>
</div>
<div class="col-sm-4">
<div class="form-group">
<label for="sub_sub_scategory">카테고리</label>
<select id="sub_sub_scategory" class="form-control">

</select>
</div>
</div>
</div>
<div class="form-group">
<label for="sname">제품명</label>
<input type="text" id="sname" name="sname" class="form-control"/>
</div>
<div class="form-group">
<label for="sprice">가격</label>
<input type="number" id="sprice" name="sprice" class="form-control"/>
</div>
<div class="form-group">
<label for="ssale">할인률</label>
<input type="number" id="ssale" name="ssale" class="form-control"/>
</div>
<div class="form-group">
<label for="delivery">배송비</label>
<input type="number" id="delivery" name="delivery" class="form-control"/>
</div>
<div class="form-group">
<label for="scontent">내용</label>
<textarea id="scontent" name="scontent" class="form-control"></textarea>
</div>
<div class="form-group">
<label for="simage">메인이미지</label>
<input type="file" id = "simage" name = "simage" class="form-control"/>
</div>
</fieldset>
</form>
</div>
</body>
</html>