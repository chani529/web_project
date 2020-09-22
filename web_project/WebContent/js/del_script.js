$(document).ready(function(){
	$("#delete_btn").submit(function(){
		if($("#bpass").val()==("")){
			alert("비밀번호가 빈칸입니다");
			$("#bpass").focus();
			return false;
		}
	})
})