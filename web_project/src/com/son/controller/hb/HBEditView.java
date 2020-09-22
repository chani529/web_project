package com.son.controller.hb;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.son.dao.HomeBoardDao;

public class HBEditView implements HBAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HomeBoardDao dao = new HomeBoardDao();
		int bno = Integer.parseInt(request.getParameter("bno"));
		request.setAttribute("dto", dao.selectBno(bno)); ;
		request.getRequestDispatcher("/board/home_board/home_board_edit.jsp").forward(request, response);
	}
}
