package com.son.controller.cq;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.dao.BoardDao;
import com.son.dto.BoardDto;

public class BDetailAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto();
		int bno =Integer.parseInt(request.getParameter("bno"));
		dao.addhit(bno);
		dto = dao.detail(bno);
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("/board/customer_question/cq_detail.jsp").forward(request, response);
	}

}
