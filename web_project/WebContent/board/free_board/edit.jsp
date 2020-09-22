<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="/inc/header.jsp" %>
<!--  END HEADER -->
<!--  END HEADER -->
<!--  END HEADER -->
<%@page import="java.sql.*"%>

<div class="container">
	<h3>자유 게시판 - 글수정</h3>
		<form action="${pageContext.request.contextPath}/edit.reply?bno=${param.bno}" method="post"  id="editForm" >
		   <fieldset>
		   <legend>	UPDATE</legend>
		   <input type="hidden" value="${dto.bgroup}" name = "bgroup"/>
		   <input type="hidden" value="${dto.bstep}" name = "bstep"/>
		   <input type="hidden" value="${dto.bindent}" name = "bindent"/>
			<div class="form-group">
			  <label for="bname"  >이름</label>
			  <input type="text"   name="bname"   id="bname"   class="form-control"   value="${dto.bname}"  disabled> 
			</div>			
			<div class="form-group">
			  <label for="btitle"  >제목</label>
			  <input type="text"   name="btitle"   id="btitle"   class="form-control"  value="${dto.btitle}"> 
			</div>	
			<div class="form-group">
			  <label for="bcontent"  >내용</label>
			  <textarea name="bcontent"  id="bcontent"  cols="60"  rows="10"   class="form-control" >${dto.bcontent}</textarea>
			</div>				
			<div class="form-group  text-right">
				<input type="submit"   value="입력"   class="btn btn-danger"  >  
				<input type="reset"    value="취소"  class="btn btn-default"    >  
				<a href="${pageContext.request.contextPath}/list.reply"   class="btn btn-default"   >목록보기</a>
			</div>
		 </fieldset>		
		</form> <!-- end form -->	
</div>
<script>	
	jQuery(document).ready(function(){
		jQuery("#editForm").submit(function(){
			if(jQuery("#bpass").val()==""){
				alert("비밀번호를 입력하세요");
				$("#bpass").focus();
				return false;
			}
			if(jQuery("#btitle").val()==""){
				alert("제목을 입력하세요");
				$("#btitle").focus();
				return false;
			}
			if(jQuery("#bcontent").val()==""){
				alert("내용을 입력하세요");
				$("#bcontent").focus();
				return false;
			}
		});
	});
</script>
<!-- END FOOTER -->
<!-- END FOOTER -->
<!-- END FOOTER -->
<!-- END FOOTER -->
<%@ include  file="/inc/footer.jsp" %>