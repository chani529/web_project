<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<script>
$(function(){
	var group_num = $("input[name=prod_num]").length;
	var gnum = new Array(group_num);
	var gprice = new Array(group_num);
	var gdelivery = new Array(group_num);
	var total = 0;
	var total_del =0;
	for (var i = 0; i < group_num; i++) {
		gnum[i]= $("input[name=prod_num]").eq(i).val();
		gdelivery[i]= parseInt($(".prod_delivery").eq(i).text());
		gprice[i]=$("input[name=prod_num]").eq(i).val() * $("input[name=prod_num]").eq(i).parent().parent().parent().parent().find(".prod_price").text();
		total_del+=gdelivery[i];
		total+=gprice[i];
	}
	$("#total_del").html(numberFormat(total_del));
	$("#total").html(numberFormat(total));
	$("#total_price").html(numberFormat(total+total_del));
	
	$("#allChk").on("click",function(){
		if($("#allChk").prop("checked")) {
		$("input[name=prod_chk]").prop("checked",true);
		}else{
		$("input[name=prod_chk]").prop("checked",false);
		}
	})//allChk
	
	$("#buy_btn").on("click",function(){
		if($("input[name=prod_chk]:checked").length==0){
			alert("한개 이상 상품을 선택해주세요.");
			return false;
		}
	})
	
$("#selDelete").on("click",function(){
		var checkedNum = $("input[name=prod_chk]:checked").length;
		var delNum = new Array(checkedNum);
		for(var i=0; i<checkedNum; i++){                          
			delNum[i] = $("input[name=prod_chk]:checked").eq(i).val();
		}
		$("input[name=prod_chk]:checked").parent().parent().remove();
		jQuery.ajaxSettings.traditional = true;
		
		var group_num = $("input[name=prod_num]").length;
		var gnum = new Array(group_num);
		var gprice = new Array(group_num);
		var gdelivery = new Array(group_num);
		var total = 0;
		var total_del =0;
		for (var i = 0; i < group_num; i++) {
			gnum[i]= $("input[name=prod_num]").eq(i).val();
			gdelivery[i]= parseInt($(".prod_delivery").eq(i).text());
			gprice[i]=$("input[name=prod_num]").eq(i).val() * $("input[name=prod_num]").eq(i).parent().parent().parent().parent().find(".prod_price").text();
			total_del+=gdelivery[i];
			total+=gprice[i];
		}
		$("#total_del").html(numberFormat(total_del));
		$("#total").html(numberFormat(total));
		$("#total_price").html(numberFormat(total+total_del));
		
		
		$.ajax({//remove Cookie
			url:"${pageContext.request.contextPath}/DelCart",
			type:"get",
			dataType:"text",
			data:{"delNum":delNum},
			success:function(data){
				if(data==1){location.href='${pageContext.request.contextPath}/SCart.st'}
			}
		})//ajax
	})//selDelete
$("#allDel").on("click",function(){
	location.href='<%=request.getContextPath()%>/AllDelCart';
})//allDel
})//ready
$(document).on("change","input[name=prod_num]",function(e){
	var group_num = $("input[name=prod_num]").length;
	var gnum = new Array(group_num);
	var gprice = new Array(group_num);
	var total = 0;
	for (var i = 0; i < group_num; i++) {
		gnum[i]= $("input[name=prod_num]").eq(i).val();
		gprice[i]=$("input[name=prod_num]").eq(i).val() * $("input[name=prod_num]").eq(i).parent().parent().parent().parent().find(".prod_price").text();
		total+=gprice[i];
	}
	$("#total").html(numberFormat(total));
	$("#total_price").html(numberFormat(total+parseInt($("#total_del").text().toString().replaceAll(",",""))));
})

function numberFormat(inputNumber) {
	   return inputNumber.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
</script>
<c:choose>
<c:when test="${list == null}">
<div style="background-color: lightgray; height: 430px;">
<div class="text-center">
<img src="${pageContext.request.contextPath}/images/cute.png" alt="장바구니가 비어있습니다">
<h3>장바구니가 비어있습니다</h3>
<a href="${pageContext.request.contextPath}/SList.st" class="btn btn-info basic_btn">상품 구매하러 가기</a>
</div>
</div>
</c:when>
<c:otherwise>
<div class="container cart_list">
<div class="row form-group">
<h3>장바구니</h3>
</div>
<div class="row">
<div class="col-sm-6">
<input type="checkbox" id="allChk"><label class="chackboxView" for="allChk"></label><label for="allChk" class="font17">전체 선택</label>
</div>
<div class="col-sm-3">
<p><span class="font17" id="selDelete">선택 삭제</span><span class="font17" id="allDel">전체 삭제</span></p>
</div>
</div>
<div class="row">
<form action="${pageContext.request.contextPath}/SBuyView.st" method="post">
<fieldset>
<div class="col-sm-8 result" style="height: auto;">
<div class="row">
<c:forEach var="cart" items="${list}" varStatus="status">
<div class="well form-group" id="${cart.indexId}" style="display: flex; align-items: center;">
<div class="col-sm-1">
<input type="checkbox" id="prod_chk${cart.indexId}" name="prod_chk" class="prod_chk" value="${cart.indexId}">
<label class="chackboxView" for="prod_chk${cart.indexId}"></label>
</div>
<div class="col-sm-3">
<c:set var="upload" value="${pageContext.request.contextPath}/upload/"/>
<c:if test="${cart.simage.indexOf(\"http\")!=-1}">
<c:set var="upload" value=""/>
</c:if>
<img src="${upload}${cart.simage}" alt="${cart.simage}" style="width: 100%; border-radius: 10px;"/>
</div>
<div class="col-sm-8">
<p class="cart_sname">${cart.sname}</p>
<div class="well" style="background-color: white;">
<div class="row">
<div class="col-sm-12">
<p class="cart_option_content">${cart.option_content}</p>
</div>
</div>
<div class="row">
<div class="col-sm-12">
<p>배송비 : <span class="prod_delivery">${cart.sdelivery}</span> 원</p>
</div>
</div>
<div class="row">
<div class="col-sm-9">
<p><span class="prod_price">${cart.option_price}</span><span>원</span></p>
</div>
<div class="col-sm-3">
<p><span><input type="number" name="prod_num" value="${cart.num}" class="form-control" min='0' max='999'/></span></p>
</div>
</div>
</div>
</div>
</div>
</c:forEach>

</div>
</div>
<div class="col-sm-4" style="height: 500px;">
<div class="cart_info">
<div class="row">
<div class="col-sm-6">
<p>총 상품금액 : </p>
</div>
<div class="col-sm-6">
<p style="text-align: right;"><strong id="total"></strong> <strong>원</strong></p>
</div>
</div>
<div class="row form-group">
<div class="col-sm-6">
<p>총 배송비 : </p>
</div>
<div class="col-sm-6">
<p style="text-align: right;"><strong id="total_del"></strong> <strong>원</strong></p>
</div>
</div>
<div class="row">
<div class="col-sm-6">
<p>결재비용 : </p>
</div>
<div class="col-sm-6">
<p style="text-align: right;"><strong id="total_price"></strong> <strong>원</strong></p>
</div>
</div>
</div>
<div class="form-group">
<input type="submit" class="form-control btn btn-info basic_btn" id="buy_btn" value="상품 구매하기"/>
</div>
</div>
</fieldset>
</form>
</div>
</div>
</c:otherwise>
</c:choose>

<%@ include file="/inc/footer.jsp" %>