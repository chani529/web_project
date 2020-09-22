package com.son.controller.hb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.dao.HomeBoardDao;

public class HBDeleteAction implements HBAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int bno = Integer.parseInt(request.getParameter("bno"));
		PrintWriter out = response.getWriter();
		HomeBoardDao dao = new HomeBoardDao();
		
		if(dao.deleteAction(bno)>0) {
			out.println("<script>alert('삭제성공');"
					+ "location.href='"+request.getContextPath()+"/HBList.hb';</script>");
		}else {
			out.println("<script>alert('삭제실패');"
					+ "history.go(-1);</script>");
		}
	}
}
