jQuery(document).ready(function(){
	  jQuery("#delete_btn").click(function(){
		  var isChk = confirm("정말 탈퇴하시겠습니까");
		  if(isChk){
			  var mpass = prompt("당신의 비밀번호를 입력해주세요"+"");
			  location.href=getContextPath()+"/mypage_delete.members?mpass="+mpass;
		  }
	  })
})