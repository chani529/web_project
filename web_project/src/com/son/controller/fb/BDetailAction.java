package com.son.controller.fb;

import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.dao.ReplyDao;
import com.son.dto.ReplyDto;

public class BDetailAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ReplyDao dao = new ReplyDao();
		int bno = Integer.parseInt(request.getParameter("bno"));
		dao.updateBhit(bno);
		ReplyDto dto = dao.selectBno(bno);
		dto.setBcontent(dto.getBcontent().replace("\r\n","<br/>"));
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("/board/free_board/detail.jsp").forward(request, response);
	}

}
