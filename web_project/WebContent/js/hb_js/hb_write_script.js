jQuery(document).ready(function(){
	  jQuery("#write_submit").submit(function(){
		  if($("select[name=residence]").val()==""){
			  alert("공간 유형을 선택해주세요");
			  $("#residence").focus();
			  return false;
		  }
		  if($("#realArea").val()==("")){
			  alert("평수가 빈칸입니다");
			  $("#realArea").focus();
			  return false;
		  }
		  if($("select[name=expertise]").val()==""){
			  alert("분야를 선택해주세요");
			  $("#expertise").focus();
			  return false;
		  }
		  if($("#family").val()==("")){
			  alert("가족형태가 빈칸입니다");
			  $("#family").focus();
			  return false;
		  }
		  if($("#btitle").val()==("")){
			  alert("제목이 빈칸입니다");
			  $("#btitle").focus();
			  return false;
		  }
	  })
})