jQuery(document).ready(function(){
	  jQuery("#update_btn").click(function(){
		  if($("#mname").val()==("")){
		  alert("이름가 빈칸입니다");
		  $("#mname").focus();
		  return false;
	  }
		  if($("#mpass").val()==("")){
			  alert("비밀번호가 빈칸입니다");
			  $("#mpass").focus();
			  return false;
		  }
		  if($("#memail").val()==("")){
			  alert("이메일이 빈칸입니다");
			  $("#memail").focus();
			  return false;
		  }
	  })
})