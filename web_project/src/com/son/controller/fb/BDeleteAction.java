package com.son.controller.fb;

import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.dao.ReplyDao;


public class BDeleteAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ReplyDao dao = new ReplyDao();
		int bno = Integer.parseInt(request.getParameter("bno"));
		int result = dao.delete(bno);
		PrintWriter out = response.getWriter();
		if(result>0) {
			out.println("<script>alert('삭제 성공');"
					+ "location.href='"+request.getContextPath()+"/list.reply';</script>");
		}else {
			out.println("<script>alert('삭제 실패');"
					+ "history.go(-1);</script>");
		}
	}

}
