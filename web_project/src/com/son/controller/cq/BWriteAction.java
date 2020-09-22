package com.son.controller.cq;

import java.io.IOException;   

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.son.dao.BoardDao;
import com.son.dto.BoardDto;

public class BWriteAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto();
		HttpSession session = request.getSession();
		dto.setBname((String)session.getAttribute("mname"));
		dto.setBtype(request.getParameter("question_type"));
		dto.setBtitle(request.getParameter("btitle"));
		dto.setBcontent(request.getParameter("bcontent"));
		dao.write(dto);
	}

}
