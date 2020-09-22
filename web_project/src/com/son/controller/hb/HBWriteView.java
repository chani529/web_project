package com.son.controller.hb;

import java.io.IOException; 
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class HBWriteView implements HBAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		if(session.getAttribute("mname")==null) {
			out.println("<script>alert('로그인이 필요합니다');"
					+ "location.href='"+request.getContextPath()+"/login_view.members';</script>");
		}else {
			request.getRequestDispatcher("/board/home_board/home_board_write.jsp").forward(request, response);
		}
	}
}
