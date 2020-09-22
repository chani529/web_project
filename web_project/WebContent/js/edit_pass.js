jQuery(document).ready(function(){
	  jQuery("#update_btn").click(function(){
		  if($("#mpass").val()==("")){
		  alert("이전 비밀번호가 빈칸입니다");
		  $("#mpass").focus();
		  return false;
	  }
		  if($("#change_mpass").val()==("")){
			  alert("새 비밀번호가 빈칸입니다");
			  $("#change_mpass").focus();
			  return false;
		  }
		  if($("#change_mpass").val()!=$("#mpass_chk").val()){
			  alert("새 비밀번호가 서로 다릅니다");
			  $("#chagne_mpass").focus();
			  return false;
		  }
	  })
})