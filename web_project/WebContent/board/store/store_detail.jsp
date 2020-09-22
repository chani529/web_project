<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<script>
$(function(){
	$.ajax({
		url:"${pageContext.request.contextPath}/Option",
		type:"get",
		dataType:"json",
		data:{"sno":'${dto.sno}'},
		success:function(data){
			console.log(data);
			$.each(data, function(key, value){
			    var menu =$("<select id='menu' class='form-group form-control' onchange='addMenu(this)'>")
					menu.append( $("<option value=''>"+key+"</option>"));
				console.log(value);
			    for (var i = 0; i < value.length; i++) {
					var option_value  = $("<option id = "+value[i].ono+" value="+value[i].option_price+">"+value[i].option_content+"("+value[i].option_price+"원)"+"</option>")
					menu.append(option_value);
			    }
			    $(".result").append(menu);
			});
		}//success
	})
	$("#cart").on("click",function(){
		if($("#total").text()==0){ alert("구매옵션을 선택해주세요"); return false; }
		var group_num = $("input[name=prod_num]").length;
		var ono = new Array(group_num);
		var prod_num = new Array(group_num);
		for (var i = 0; i < group_num; i++) {
			prod_num[i]= $("input[name=prod_num]").eq(i).val();
			ono[i]=$(".option_no").eq(i).text();
			console.log("num "+ prod_num[i]);			
			console.log("ono "+ ono[i]);			
		}
		jQuery.ajaxSettings.traditional = true;
		$.ajax({
			url:"${pageContext.request.contextPath}/AddCart",
			type:"GET",
			data:{"sno":'${dto.sno}',"ono":ono,"prod_num":prod_num},
			success:function(){
				$(".result1").empty();
				$("#total").text(0);
			}
		})	
	})
	$("#prod_num").on("change",function(e){
		alert($(e).val());
	})
})
var changeVal = function(e){
$(e).attr("value",$(e).val());
}
var addMenu = function(e){
	var div = $("<div class='well'>");
	var onoTag = $("<p class='option_no'>"+$(e).find("option:selected").attr("id")+"</p>");
	var p1 = $("<p>"+$(e).find("option:selected").text()+"</p>");
	var p2 = $("<p class='prod_price'>"+$(e).val()+"</p>");
	var divRow = $("<div class='row'>");
	var col10 = $("<div class='col-sm-10'>");
	var input1 = $("<input type='number' class='form-control' name='prod_num' min='0' max='100' value='0' onchange='changeVal(this)'/>")
	col10.append(input1);
	var col2 = $("<div class='col-sm-2'>");
	var span1 = $("<span class='btn btn-default glyphicon glyphicon-remove' onclick='removeDiv(this)'>");
	col2.append(span1);
	divRow.append(col10).append(col2);
	div.append(onoTag).append(p1).append(p2).append(divRow);
	$(".result1").append(div);
	$(e).prop('selectedIndex',0);
	}
var removeDiv = function(e){
	$(e).parent().parent().parent().remove();
	var group_num = $("input[name=prod_num]").length;
	var gnum = new Array(group_num);
	var gprice = new Array(group_num);
	var total = 0;
	for (var i = 0; i < group_num; i++) {
		gnum[i]= $("input[name=prod_num]").eq(i).val();
		gprice[i]=$("input[name=prod_num]").eq(i).val() * $("input[name=prod_num]").eq(i).parent().parent().parent().find(".prod_price").text();
		console.log(gprice[i]);
		total+=gprice[i];
	}
	console.log(total);
	$("#total").html(total);
}
$(document).on("change","input[name=prod_num]",function(e){
	var group_num = $("input[name=prod_num]").length;
	var gnum = new Array(group_num);
	var gprice = new Array(group_num);
	var total = 0;
	for (var i = 0; i < group_num; i++) {
		gnum[i]= $("input[name=prod_num]").eq(i).val();
		gprice[i]=$("input[name=prod_num]").eq(i).val() * $("input[name=prod_num]").eq(i).parent().parent().parent().find(".prod_price").text();
		total+=gprice[i];
	}
	$("#total").html(total);
})
</script>
<div class="container panel panel-info">
<div class="row">
<div class="col-sm-12">
<p class="category form-group">${cate.category} > ${cate.sub_category} > ${cate.sub_sub_category}</p>
</div>
</div>
<div class="row">
<div class="col-sm-8">
<c:set var="upload" value="${pageContext.request.contextPath}/upload/"/>
<c:if test="${dto.simage.indexOf(\"http\")!=-1}">
<c:set var="upload" value=""/>
</c:if>
<img src="${upload}${dto.simage}" alt="상품메인이미지" style="width: 90%;"/>
</div>
<div class="col-sm-4">
<p>${dto.smaker}</p>
<p>${dto.sname}</p>
<p>${dto.ssale}% / ${dto.sprice}</p>
<p>옵션</p>
<!--  select옵션추가 위치    -->
<div class="result">
</div>
<!-- 옵션 div 추가 위치  -->
<div class="result1">
</div>
<div class="row" style="display: contents;">
<p style="text-align: right;"><strong id="total">0</strong> <strong>원</strong></p>
</div>
<div class="row form-group">
<div class="col-sm-12"><input type="button" id="cart" class="form-control btn btn-default" data-toggle="modal" data-target="#myModal" value="장바구니"/></div>
</div>
<div class="row">
<div class="col-sm-12">
<a href="${pageContext.request.contextPath}/SList.st" class="form-control btn btn-info">스토어로 돌아가기</a>
</div>
</div>
<c:if test="${sessionScope.mname==dto.pname}">
<div class="row form-group">
<div class="col-sm-12"><a class="form-control btn btn-info" href="${pageContext.request.contextPath}/SDelete.st?sno=${dto.sno}">삭제</a></div>
</div>
</c:if>
</div>
</div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
<div class="modal-dialog" role="document">
<div class="modal-content">
<div class="modal-header">
<h3>장바구니에 상품을 담았습니다</h3>
<div class="modal-body row">
<div class="form-group">
<a href="${pageContext.request.contextPath}/SCart.st" class="form-control btn btn-info basic_btn">장바구니 보러가기</a>
</div>
<div class="form-group">
<button type="button" class="form-control btn btn-default basic_btn" data-dismiss="modal">확인</button>
</div>
</div>
</div>
</div>
</div>
</div>
<div class="jumbotron" style="background-color:#f9f9f9; width: 100%; border: 0.5px solid #afafaf;">
</div>
<div class="container">
${content}
</div>
<%@ include file="/inc/footer.jsp" %>