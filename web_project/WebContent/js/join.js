 $(function(){
	 $(".redfont").hide();
	 $(".margin20").hide();
  		$("#mpass").blur(function(){
  			if($("#mpass").val()==""){
  				$(this).parent().find("label").css("color","red");
  				$(this).css("border","1px solid red");
  				$(this).parent().find(".margin20").show();
  			}else{
  				$(this).parent().find("label").css("color","black");
  				$(this).css("border","1px solid #ccc");
  				$(this).parent().find(".margin20").hide();
  			}
  		})
  		$("#mpass_chk").blur(function(){
  			if($("#mpass_chk").val()==""){
  				$(this).parent().find("label").css("color","red");
  				$(this).css("border","1px solid red");
  				$(this).parent().find(".margin20").show();
  			}else{
  				$(this).parent().find("label").css("color","black");
  				$(this).css("border","1px solid #ccc");
  				$(this).parent().find(".margin20").hide();
  			}
  		})
  		$("#mname").blur(function(){
  			if($("#mname").val()==""){
  				$(this).parent().find("label").css("color","red");
  				$(this).css("border","1px solid red");
  				$(this).parent().find(".margin20").show();
  			}else{
  				$(this).parent().find("label").css("color","black");
  				$(this).css("border","1px solid #ccc");
  				$(this).parent().find(".margin20").hide();
  			}
  		})
  		jQuery("#sign_btn").click(function(){
  			if($("#memail").val()==("")){
				alert("이메일이 빈칸입니다");
				$("#memail").focus();
				return false;
			}
  			if($("select[name=email_menu]").val()==("")){
				alert("이메일종류를 선택해주세요");
				$("select").focus();
				return false;
			}
			if($("#mpass").val()==("")){
				alert("비밀번호가 빈칸입니다");
				$("#mpass").focus();
				return false;
			} 
			if($("#mpass_chk").val()!=$("#mpass").val()){
				alert("비빌번호 확인이 틀립니다");
				$("#mpass_chk").focus();
				return false;
			} 
			if($("#mname").val()==("")){
				alert("이름이 빈칸입니다");
				$("#mname").focus();
				return false;
			} 
			if($("input:checkbox[name=chkbox]:checked").length!=3){
				alert("필수 사항을 체크해주세요");
				$("#chkbox").focus();
				return false;
			} 
  		})
  		$("#allCheck").click(function(){
  			if($("#allCheck").prop("checked")){
  				$(".chk").prop("checked",true);
  			}else{
  				$(".chk").prop("checked",false);
  			}
  		})
  	})