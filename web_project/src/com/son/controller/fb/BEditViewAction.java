package com.son.controller.fb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.dao.ReplyDao;
import com.son.dto.ReplyDto;


public class BEditViewAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ReplyDao dao = new ReplyDao();
		int bno = Integer.parseInt(request.getParameter("bno"));
		ReplyDto dto = dao.selectBno(bno);
		dto.setBcontent(dto.getBcontent());
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("/board/free_board/edit.jsp").forward(request, response);
	}

}
