package com.son.controller.fb;

import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.dao.ReplyDao;
import com.son.dto.ReplyDto;


public class BWriteAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ReplyDao dao = new ReplyDao();
		ReplyDto dto = new ReplyDto();
		PrintWriter out = response.getWriter();
		int result=-1;
		int max = dao.max_read();
		int bgroup = (int)(Math.ceil(max)/(float)1000)+1;
		int bstep = bgroup*1000;
		dto.setBname(request.getParameter("bname"));
		dto.setBtitle(request.getParameter("btitle"));
		dto.setBcontent(request.getParameter("bcontent"));
		dto.setBgroup(bgroup);
		dto.setBstep(bstep);
		result = dao.create(dto);
		if(result>0) {
			out.println("<script>alert('입력 성공');"
					+ "location.href='"+request.getContextPath()+"/list.reply';</script>");
		}else {
			out.println("<script>alert('입력 실패');"
					+ "history.go(-1);</script>");
		}
		
	}

}
