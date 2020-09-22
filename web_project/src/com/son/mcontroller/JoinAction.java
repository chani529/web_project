package com.son.mcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.dao.MemberDao;
import com.son.dto.MemberDto;

public class JoinAction implements MAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		MemberDao dao= new MemberDao();
		MemberDto dto = new MemberDto();
		PrintWriter out = response.getWriter();
		String memail = request.getParameter("memail")+"@"+request.getParameter("email_menu");
		dto.setMname(request.getParameter("mname"));
		dto.setMpass(request.getParameter("mpass"));
		dto.setMemail(memail);
		int result = dao.joinAction(dto);
		if(result>0) {
			out.println("<script>alert('회원가입이 완료되었습니다');"
					+ "location.href='"+request.getContextPath()+"/login_view.members';</script>");
		}else {
			out.println("<script>alert('가입 실패\n관리자에게 문의하세요');"
					+ "history.go(-1);</script>");
		}
	}

}
