package com.son.mcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.son.dao.MemberDao;

public class EditPassAction implements MAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		MemberDao dao= new MemberDao();
		HttpSession session = request.getSession();
		String mname = (String)session.getAttribute("mname");
		String mpass = request.getParameter("mpass");
		String mpassChange = request.getParameter("change_mpass");
		PrintWriter out = response.getWriter();
		if(dao.pass_change(mname, mpass, mpassChange)>0) {
				out.println("<script>alert('비밀번호 변경에 성공했습니다');"
						+ "location.href='"+request.getContextPath()+"/mypage_view.members'</script>");
		}else {
			out.println("<script>alert('비밀번호가 틀렸습니다');"
					+ "history.go(-1);</script>");
		}
	}

}
