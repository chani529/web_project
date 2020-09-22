package com.son.controller.cq;

import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.dao.BoardDao;
import com.son.dto.BoardDto;

public class BEditAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto();
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setBtitle(request.getParameter("btitle"));
		dto.setBtype(request.getParameter("btype"));
		dto.setBcontent(request.getParameter("bcontent"));
		int result = dao.update(dto);
		System.out.println(result);
		if(result>0) {
			out.println("<script>alert('글쓰기 성공');"
					+ "location.href='"+request.getContextPath()+"/BList.do';</script>");
		}else {
			out.println("<script>alert('글쓰기 실패');"
					+ "history.go(-1);</script>");
		}
	}

}
