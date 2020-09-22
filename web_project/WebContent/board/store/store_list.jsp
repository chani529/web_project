<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<script>
$(function(){
	   $.ajax({
		   url:"${pageContext.request.contextPath}/PopUpServlet",
		   type:"get",
		   dataType:"text",
		   success:function(data){
			   console.log(data);
			   if(data != 1){
				var url = "${pageContext.request.contextPath}/board/pop.jsp";
		 	    var name = "popup test";
		 	    var option = "width = 800px, height = 450px, top = 100, left = 200, location = no"
		 	    window.open(url, name, option);  
			   }
		   }
	   })//ajax
	
	var cnt = 1;
	$('.collapse').on('show.bs.collapse', function(){
		$(this).prev().find(".glyphicon-chevron-down").removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-up");
		}).on('hide.bs.collapse', function(){
		$(this).prev().find(".glyphicon-chevron-up").removeClass("glyphicon-chevron-up").addClass("glyphicon-chevron-down");
		});
	$("#store_accordion h5").on("click",function(){
		cnt = 1;
		$(".hitList").empty();
		$(".storeList").empty();
		$(".sel_category").text($(this).text());
		$.ajax({
			url:"${pageContext.request.contextPath}/StoreListAction",
			type:"get",
			dataType:"json",
			data:{"cate":$(this).text()},
			success:function(data){
				for (var i = 0; i < data[0].hitList.length; i++) {
					var info = $("<div class='col-sm-2 form-group hei320' onclick=location.href='${pageContext.request.contextPath}/SDetail.st?sno="+data[0].hitList[i].sno+"'>");
					var simage =null;
					var freeDelivery = null;
					if(data[0].hitList[i].simage.indexOf("http")!=-1){
						simage = $("<img class='hb_images form-group' alt='상품사진' src="+data[0].hitList[i].simage+" />");
					}else{
						simage = $("<img class='hb_images form-group' alt='상품사진' src='${pageContext.request.contextPath}/upload/"+data[0].hitList[i].simage+"' />");
					}
					var brand=$("<p class='production_brand'>"+data[0].hitList[i].smaker+"</p>");
					var sname=$("<p class='production_sname'>"+data[0].hitList[i].sname+"</p>");
					var sprice=$("<span class='production_ssale'>"+data[0].hitList[i].ssale+"%</span><span class='production_sprice'>"+data[0].hitList[i].sprice+"원</span>");
					if(data[0].hitList[i].sdelivery==0){
						freeDelivery=$("<p class='btn btn-default freeDelivery'>무료배송</p>");						
					}
					info.append(simage).append(brand).append(sname).append(sprice).append(freeDelivery);
					$(".hitList").append(info);
				}
				for (var i = 0; i < data[1].allList.length; i++) {
					var info = $("<div class='col-sm-4 form-group hei320' onclick=location.href='${pageContext.request.contextPath}/SDetail.st?sno="+data[1].allList[i].sno+"'>");
					var simage =null;
					var freeDelivery = null;
					if(data[1].allList[i].simage.indexOf("http")!=-1){
						simage = $("<img class='hb_images form-group' alt='상품사진' src="+data[1].allList[i].simage+" />");
					}else{
						simage = $("<img class='hb_images form-group' alt='상품사진' src='${pageContext.request.contextPath}/upload/"+data[1].allList[i].simage+"'/>");
					}
					var brand=$("<p class='production_brand'>"+data[1].allList[i].smaker+"</p>");
					var sname=$("<p class='production_sname'>"+data[1].allList[i].sname+"</p>");
					var sprice=$("<span class='production_ssale'>"+data[1].allList[i].ssale+"%</span><span class='production_sprice'>"+data[1].allList[i].sprice+"원</span>");
					if(data[1].allList[i].sdelivery==0){
						freeDelivery=$("<p class='btn btn-default freeDelivery'>무료배송</p>");						
					}
					info.append(simage).append(brand).append(sname).append(sprice).append(freeDelivery);
					$(".storeList").append(info);
				}
			}//success
		})
	});
	
	$(window).on("scroll",function() {
	    if(Math.floor($(window).scrollTop()) == $(document).height()-$(window).height()||Math.floor($(window).scrollTop()+1) == $(document).height()-$(window).height()) {
	    	$.ajax({
				url:"${pageContext.request.contextPath}/StoreScrollAction",
				type:"get",
				dataType:"json",
				data:{"cate":$(".sel_category").text(),"start":cnt},
				success:function(data){
					cnt++;
					console.log(cnt);
					console.log(data);
					for (var i = 0; i < data.length; i++) {
						var info = $("<div class='col-sm-4 form-group hei320' onclick=location.href='${pageContext.request.contextPath}/SDetail.st?sno="+data[i].sno+"'>");
						var simage =null;
						var freeDelivery = null;
						if(data[i].simage.indexOf("http")!=-1){
							simage = $("<img class='hb_images form-group' alt='상품사진' src="+data[i].simage+" />");
						}else{
							simage = $("<img class='hb_images form-group' alt='상품사진' src='${pageContext.request.contextPath}/upload/"+data[i].simage+"'/>");
						}
						var brand=$("<p class='production_brand'>"+data[i].smaker+"</p>");
						var sname=$("<p class='production_sname'>"+data[i].sname+"</p>");
						var sprice=$("<span class='production_ssale'>"+data[i].ssale+"%</span><span class='production_sprice'>"+data[i].sprice+"원</span>");
						if(data[i].sdelivery==0){
							freeDelivery=$("<p class='btn btn-default freeDelivery'>무료배송</p>");						
						}
						info.append(simage).append(brand).append(sname).append(sprice).append(freeDelivery);
						$(".storeList").append(info);
					}
				}//success
			})
	    }
	});
});
</script>
<div class="container">
<div class="row">
<div class="col-sm-3">
<%@ include file="/board/store/store_accordion.jsp" %>
</div>
<div class="col-sm-9">
<div class="row">
<h3 class="sel_category">스토어</h3>
</div>
<div class="row form-group">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
  </ol>
  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="${pageContext.request.contextPath}/upload/159522749752921888.png" alt="#">
    </div>
    <div class="item">
      <img src="${pageContext.request.contextPath}/upload/159557670268413438.jpg" alt="#">
    </div>
  </div>
  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
<div class="row">
<h4>인기 상품</h4>
</div>
<div class="row form-group hitList">
<c:forEach var="list" items="${hitList}" varStatus="status">
<div class="col-sm-2 form-group hei320" onclick="location.href='${pageContext.request.contextPath}/SDetail.st?sno=${list.sno}'">
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
<div class="row form-group">
<div class="row">
<div class="col-sm-4">
<h4>전체 상품</h4>
</div>
<div class="col-sm-8 text-right">
<a href="${pageContext.request.contextPath}/SWrite_view.st" class="btn btn-info">글쓰기</a>
</div>
</div>
</div>
<div class="row form-group storeList">
<c:forEach var="list" items="${list}" varStatus="status">
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
</div>
</div>
</div>
<%@ include file="/inc/footer.jsp" %>