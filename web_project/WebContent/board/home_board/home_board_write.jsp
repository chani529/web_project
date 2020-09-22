<%@page import="com.son.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp"%>
<script src="<%=request.getContextPath()%>/js/hb_js/hb_write_script.js"></script>
<div class="container" id="hb_write_container">
<div class="row">
	<div class="panel hb_accodian">
	<button class="form-control" data-toggle="collapse" data-target="#collapse1">
			<h4 class="panel-title">
				<span class="glyphicon glyphicon-align-left"></span><strong>  집들이 작성 가이드 </strong><span class="small_font">원활한 집들이 발행을 위해 꼭 읽어주세요.</span>
			</h4>
			</button>
		<div id="collapse1" class="panel-collapse collapse">
			<div class="panel-body">
				<ul>
					<li>간단한 자기 소개 후 집에 관한 이야기를 들려주세요. (집 공간 사진 최소 15장 이상)</li>
					<li>도면이 있으면 좋아요. (손그림도 OK)</li>
					<li>사진 속 제품 정보를 본문에 최대한 적어주세요. (제품분류/브랜드/제품명 순서)</li>
					<li>정보를 많이 입력할수록 검색 결과에 많이 노출되어 조회수가 올라갑니다.</li>
					<li>작성해주신 온라인집들이는 오늘의집 에디터 검수를 통해 오픈 여부가 결정되며, 결과 관련해서는 댓글로 안내
						드립니다. (커버사진과 제목은 에디터에 의해 변경될 수 있습니다)</li>
				</ul>
			</div>
		</div>
	</div>
	</div>
	<form action="<%=request.getContextPath()%>/HBWrite.hb" method="post"
		id="write_submit" enctype="multipart/form-data">
		<div class="row">
		<div class="panel hb_accodian">
			<button type="button" class="form-control" data-toggle="collapse" data-target="#collapse2">
			<h4 class="panel-title">
			<span class="glyphicon glyphicon-pencil"></span>
				<strong>  필수 정보 입력  </strong>
				<span class="small_font">공간을 이해하는데 필요한 정보이니 최대한 꼼꼼하게 입력해주세요.</span>
			</h4>
			</button>
			<div id="collapse2" class="panel-collapse collapse">
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-2">공간 *</div>
						<div class="col-sm-4">
							<select id="residence" name="residence" class="form-control">
								<option value="">선택해주세요</option>
								<option value="0">원룸&amp;오피스텔</option>
								<option value="1">아파트</option>
								<option value="2">빌라&amp;연립</option>
								<option value="3">단독주택</option>
								<option value="4">상업공간</option>
								<option value="5">상업공간</option>
								<option value="6">기타</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">평수 *</div>
						<div class="col-sm-4">
							<input type="number" id="realArea" name="realArea"
								class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">분야 *</div>
						<div class="col-sm-4">
							<select id="expertise" name="expertise" class="form-control">
								<option value="">선택해주세요</option>
								<option value="0">리모델링</option>
								<option value="1">홈스타일링</option>
								<option value="2">부분공사</option>
								<option value="3">건축</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">가족형태 *</div>
						<div class="col-sm-10">
							<input type="text" id="family" name="family"
								class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-sm-2">메인이미지 *</div>
						<div class="col-sm-10">
							<input type="file" id="bfile" name="bfile"
								class="form-control" />
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<div class="row">
		<div class="form-group">
			<input type="text" name="btitle" id="btitle"
				placeholder="제목을 입력해주세요." maxlength="30" style="width: 100%; border: 0px 0px 0px 2px;">
			</div>
			<div class="form-group">
			<textarea name="bcontent" id="bcontent" maxlength="2000"
			placeholder="내용을 입력해주세요."></textarea>
			</div>
			<script src="//cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
			 <script> 
			 	 CKEDITOR.replace( 'bcontent' , {
			     filebrowserUploadUrl: '${pageContext.request.contextPath}/fileUpload.upload'
			 }); 
			 </script>
			<div class="form-group">
			<input type="submit" class="btn btn-info" value="보내기">
			</div>
		</div>
	</form>
	</div>
<%@ include file="/inc/footer.jsp"%>
