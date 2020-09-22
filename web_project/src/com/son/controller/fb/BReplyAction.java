package com.son.controller.fb;

import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.dao.ReplyDao;
import com.son.dto.ReplyDto;


public class BReplyAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ReplyDao dao = new ReplyDao();
		ReplyDto dto = new ReplyDto();
		PrintWriter out = response.getWriter();
		int result=-1;
		int bgroup = Integer.parseInt(request.getParameter("bgroup"));
		int bstep = Integer.parseInt(request.getParameter("bstep"));
		
		int first = (int)(Math.ceil(bstep/(float)1000)-1)*1000;
		System.out.println(first+"    "+bstep);
		dao.bstepUpdate(first, bstep);
		int bindent = Integer.parseInt(request.getParameter("bindent"))+1;
		dto.setBname(request.getParameter("bname"));
		dto.setBtitle(request.getParameter("btitle"));
		dto.setBcontent(request.getParameter("bcontent"));
		dto.setBgroup(bgroup);
		dto.setBstep(bstep-1);
		dto.setBindent(bindent);
		result = dao.re_create(dto);
		if(result>0) {
			out.println("<script>alert('입력 성공');"
					+ "location.href='"+request.getContextPath()+"/list.reply';</script>");
		}else {
			out.println("<script>alert('입력 실패');"
					+ "history.go(-1);</script>");
		}
	}

}
