jQuery(document).ready(function(){
	jQuery("#edit_btn").submit(function(){
		console.log($("#mbirthday").val());
		if($("#bpass").val()==("")){
			alert("패스워드가 빈칸입니다");
			$("#bpass").focus();
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