package com.son.controller.fb;

import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.dao.ReplyDao;
import com.son.dto.ReplyDto;


public class REditAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ReplyDao dao = new ReplyDao();
		ReplyDto dto = new ReplyDto();
		PrintWriter out = response.getWriter();
		int result=-1;
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setBtitle(request.getParameter("btitle"));
		dto.setBcontent(request.getParameter("bcontent"));
		result = dao.update(dto);
		if(result>0) {
			out.println("<script>alert('수정 성공');"
					+ "location.href='"+request.getContextPath()+"/list.reply';</script>");
		}else {
			out.println("<script>alert('수정 실패');"
					+ "history.go(-1);</script>");
		}

	}

}
