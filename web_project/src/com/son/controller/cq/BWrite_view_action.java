package com.son.controller.cq;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.son.dao.MemberDao;
import com.son.dto.MemberDto;

public class BWrite_view_action implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String mname =(String)session.getAttribute("mname"); 
		if(mname==null) {
			out.println("<script>alert('로그인이 필요합니다');"
					+ "location.href='"+request.getContextPath()+"/BList.do';</script>");
		}else {
			MemberDao dao= new MemberDao();
			MemberDto dto= new MemberDto();
			dto= dao.selectMname(mname);
			request.setAttribute("dto", dto);
			request.getRequestDispatcher("/board/customer_question/cq_write.jsp").forward(request, response);
		}
	}
}
