jQuery(document).ready(function(){
	  jQuery("#edit_submit").submit(function(){
		  if($("select[name=btype]").val()==""){
			  alert("질문 유형을 선택해주세요");
			  $("#mpass").focus();
			  return false;
		  }
		  if($("#btitle").val()==("")){
			  alert("제목이 빈칸입니다");
			  $("#btitle").focus();
			  return false;
		  }
		  if($("#bcontent").val()==("")){
			  alert("내용이 빈칸입니다");
			  $("#bcontent").focus();
			  return false;
		  }
	  })
})