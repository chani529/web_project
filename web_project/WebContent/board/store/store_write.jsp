<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<div class="container">
<div class="row">
<div class="col-sm-8">
<h3>상품 등록</h3>
</div>
</div>
<form action="${pageContext.request.contextPath}/SWrite.st" method="post"
enctype="multipart/form-data" id="post_submit">
<fieldset>
<div class="row">
<div class="col-sm-8">
	<div class="form-group result" id="image_view">
	<img src="${pageContext.request.contextPath}/images/plzUpload.PNG" alt="메인 이미지를 선택해주세요"
	class="store_main_image"/>
	</div>
	<script>
	$(function(){
		$(".store_main_image").on("click",function(){
			$("#simage").click();
		});
		$("#simage").on("change" , function(event){
			var reader = new FileReader();
			reader.onload = function(event) {
				var img = $(".store_main_image").attr("src", event.target.result);
			};
			reader.readAsDataURL(event.target.files[0]);
		});
	});
		</script>
		<div class="row form-group">
		<div class="col-sm-4">
		<input type="file" id = "simage" name = "simage" class="form-control files" style="display:none;"/>
		</div>
	</div>
</div>
<div class="col-sm-4">
<div class="row">
<div class="col-sm-12">
<div class="row form-group">
<div class="row">
	<div class="col-sm-4 form-group">
		<label>상품 분류</label>
	</div>
</div>
	<div class="col-sm-4">
		<select id="category" name="category" class="form-control">
		<option value="">1차 분류</option>
		<option value="가구">가구</option>
		<option value="패브릭">패브릭</option>
		<option value="홈데코/조명">홈데코/조명</option>
		<option value="가전">가전</option>
		<option value="수납/정리">수납/정리</option>
		<option value="생활">생활</option>
		</select>
	</div>
	<script>
	$(function(){
		$("#category").on("change", function(){
				$("#sub_category").empty();
				$("#sub_category").append("<option value=''>2차 분류</option>");
				$.ajax({
					url:"${pageContext.request.contextPath}/SelCategory",
					type:"get",
					data:{"category":$("#category option:selected").val()},
					dataType:"json",
					success:function(json){
						for(var i =0;i<json.length;i++){
							$("#sub_category").append("<option value='"+json[i].category+"'>"+json[i].category+"</option>");
						}
					}
				})
		
		})
		$("#sub_category").on("change", function(){
				$("#sub_sub_category").empty();
				$("#sub_sub_category").append("<option value=''>3차 분류</option>");
				$.ajax({
					url:"${pageContext.request.contextPath}/SelSubCategory",
					type:"get",
					data:{"sub_category":$("#sub_category option:selected").val()},
					dataType:"json",
					success:function(json){
						for(var i =0;i<json.length;i++){
							$("#sub_sub_category").append("<option value='"+json[i].category+"'>"+json[i].category+"</option>");
						}
					}
				})
		
		})
	})
	</script>
	<div class="col-sm-4">
		<select id="sub_category" name="sub_category" class="form-control">
		<option value="">2차 분류</option>
		</select>
	</div>
	<div class="col-sm-4">
		<select id="sub_sub_category" name="sub_sub_category" class="form-control">
		<option value="">3차 분류</option>
		</select>
	</div>
</div>
</div>
</div>
	<div class="row form-group">
		<div class="col-sm-12">
		<label for="smaker">제조사</label>
		<input type="text" id="smaker" name="smaker" class="form-control"/>
		</div>
		</div>

	<div class="row form-group">
		<div class="col-sm-12">
		<label for="sname">제품명</label>
		<input type="text" id="sname" name="sname" class="form-control"/>
		</div>
		</div>
		<div class="row form-group">
		<div class="col-sm-6">
		<label for="ssale">할인률</label>
		<input type="number" id="ssale" name="ssale" class="form-control"/>
		</div>
		<div class="col-sm-6">
		<label for="sprice">기본 상품 가격</label>
		<input type="number" id="sprice" name="sprice" class="form-control"/>
		</div>
		</div>
		<div class="row form-group">
		<div class="col-sm-12">
		<label for="sdelivery">배송비</label>
		<input type="number" id="sdelivery" name="sdelivery" class="form-control"/>
		</div>
		</div>
		
		
</div>
</div>
<!--   옵션 추가 -->
		<div class="row form-group">
		<div class="col-sm-12">
			<table class="table table-striped">
			<thead>
			<tr>
				<th scope = "col">옵션명</th>
				<th scope = "col">옵션값</th>
				<th scope = "col">추가가격</th>
				<th scope = "col">추가/제거</th>
			</tr>
			</thead>
			<tbody>
			<tr>
			<td><input type="text" name="option_name" class="form-control" placeholder="옵션 카테고리"/></td>
			<td><input type="text" name="option_content" class="form-control" placeholder="옵션명"/></td>
			<td><input type="number" name="option_price" class="form-control" min='0' max='10000000' value='0'/></td>
			<td><input type="button" class="btn btn-default add" value="+"/></td>
			</tr>
			</tbody>
			</table>
			<script>
				$('.add').on("click", function(){
					var td1 = $("<td>").html("<input type='text' name='option_name' class='form-control' placeholder='옵션 카테고리'/>");
					var td2 = $("<td>").html("<input type='text' name='option_content' class='form-control'  placeholder='옵션명'/>");
					var td3 = $("<td>").html("<input type='number' class='form-control' name='option_price' min='0' max='10000000' value='0'/>");
					var td4 = $("<td>").html("<input type='button' class='btn btn-default' value='-'/ onclick='removefunc(this)'>");
					var tr= $("<tr>").append(td1).append(td2).append(td3).append(td4);
					$(this).parent().parent().parent().append(tr);
				});
				var removefunc = function(e){
					$(e).parent().parent().empty();
				}
			</script>
		</div>
		</div>
<div class="row form-group">
	<div class="col-sm-12">
		<label for="scontent">상품설명</label>
		<textarea id="scontent" name="scontent" class="form-control"></textarea>
	</div>
	<script src="//cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
		<script> 
			 	 CKEDITOR.replace( 'scontent' , {
			     filebrowserUploadUrl: '${pageContext.request.contextPath}/fileUpload.upload'
			 }); 
		</script>
</div>
<div class="row">
<div class="col-sm-12 text-right">
<input type="submit" class="btn btn-info" value="상품 등록"/>
</div>
</div>
</fieldset>
</form>
</div>
<%@ include file="/inc/footer.jsp" %>