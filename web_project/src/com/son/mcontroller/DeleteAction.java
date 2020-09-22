package com.son.mcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.son.dao.MemberDao;

public class DeleteAction implements MAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		MemberDao dao= new MemberDao();
		HttpSession session = request.getSession();
		String mname = (String)session.getAttribute("mname");
		String mpass = request.getParameter("mpass");
		if(dao.deleteAction(mname, mpass)>0) {
			session.invalidate();
			out.println("<script>alert('삭제에 성공했습니다');"
					+ "location.href='"+request.getContextPath()+"/login_view.members'</script>");
		}else {
			out.println("<script>alert('비밀번호가 틀렸습니다');"
					+ "location.href='"+request.getContextPath()+"/mypage_view.members'</script>");
		}
		
	}

}
