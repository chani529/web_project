jQuery(document).ready(function(){
	jQuery("#write_btn").submit(function(){
		if(jQuery("#bname").val()==""){
			alert("이름이 빈칸입니다\n다시입력하세요");
			jQuery("#bname").focus();
			return false;
		}
		if(jQuery("#bpass").val()==""){
			alert("비밀번호가 빈칸입니다\n다시입력하세요");
			jQuery("bpass").focus();
			return false;
		}
		if(jQuery("#btitle").val()==""){
			alert("제목이 빈칸입니다\n다시입력하세요");
			jQuery("#btitle").focus();
			return false;
		}
		if(jQuery("#bcontent").val()==""){
			alert("내용이 빈칸입니다\n다시입력하세요");
			jQuery("#bcontent").focus();
			return false;
		}
	})
})