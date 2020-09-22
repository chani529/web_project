<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<script>
$(function(){
	var group_num = $(".prod_num").length;
	var gnum = new Array(group_num);
	var gprice = new Array(group_num);
	var gdelivery = new Array(group_num);
	var total = 0;
	var total_del =0;
	for (var i = 0; i < group_num; i++) {
		gnum[i]= $(".prod_num").eq(i).val();
		gdelivery[i]= parseInt($(".prod_delivery").eq(i).text());
		gprice[i]=$(".prod_num").eq(i).text() * $(".prod_num").eq(i).parent().parent().parent().find(".prod_price").text();
		total_del+=gdelivery[i];
		total+=gprice[i];
	}
	$("#total_del").html(total_del);
	$("#total").html(total);
	$("#total_price").html(total+total_del);
	$("#buy_btn").on("click",function(){
	if ($("#postcode").val() == "") {
		alert("우편번호를 입력해주세요.")
		return false;
	}
	if ($("#address1").val() == "") {
		alert("추가 상세 주소를 입력해주세요.")
		$("#address1").focus();
		return false;
	}
	})
})
</script>
<div class="container cart_list">
<div class="row form-group">
<c:choose>
<c:when test="${sessionScope.mname!=null}"><h3>회원 상품 구매</h3></c:when>
<c:otherwise><h3>비회원 상품 구매</h3></c:otherwise>
</c:choose>

</div>
<form action="<%=request.getContextPath()%>/SBuy.st" method="get">
<fieldset>
<div class="row">
<div class="col-sm-8 result" style="height: auto;">
<div class="row">
<c:forEach var="cart" items="${list}" varStatus="status">
<input type="hidden" name="indexId" value="${cart.indexId}"/>
<div class="well form-group" id="${cart.indexId}" style="display: flex; align-items: center;">
<div class="col-sm-4">
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
<p><span class="prod_price">${cart.option_price}</span><span> 원</span></p>
</div>
<div class="col-sm-3">
<p><span class="prod_num">${cart.num}</span> 개</p>
</div>
</div>
</div>
</div>
</div>
</c:forEach>
</div>
</div>
<div class="col-sm-4" style="height: 300px;">
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
</div>
</div>
<div class="row form-group">
<div class="col-sm-2"><label for="postcode">우편번호</label></div>
<div class="col-sm-4"><input type="text" id="postcode" name="postcode" class="form-control" readonly="readonly"/></div>
<div class="col-sm-6"><input type="button" id="post" name = "post" value="우편번호" class="btn btn-danger"/></div>
</div>
<div class="row form-group">
<div class="col-sm-2"><label for="address">상세주소</label></div>
<div class="col-sm-4"><input type="text" id="address" name="address" class="form-control" readonly="readonly"/></div>
<div class="col-sm-6"><input type="text" id="address1" name="address1" class="form-control" placeholder="추가 상세 주소"/></div>
</div>
<div class="row form-group">
<input type="submit" class="btn btn-info form-control basic_btn" id ="buy_btn" value="구매 확정">
</div>
</fieldset>
</form>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$(function() {
		$("#post").click(function() {
			 new daum.Postcode({
		            oncomplete: function(data) {
					$("#postcode").val(data.zonecode);
					$("#address").val(data.address);
					$("#address1").focus();
				}
			}).open();
		})
	})
</script>


</div>
<%@ include file="/inc/footer.jsp" %>
