package com.son.controller.hb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.dao.HomeBoardDao;
import com.son.dto.HomeBoardDto;

public class HBDetailView implements HBAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HomeBoardDto dto = null;
		HomeBoardDao dao = new HomeBoardDao();
		PrintWriter out = response.getWriter();
		int bno = Integer.parseInt(request.getParameter("bno"));
		int result = dao.updateBhit(bno);
		if(result>0) {
			dto=dao.selectBno(bno);
			System.out.println(dto.getMname());
			dto.setBcontent(dto.getBcontent().replace("\n", "<br/>"));
			request.setAttribute("dto", dto);
			request.getRequestDispatcher("/board/home_board/home_board_detail.jsp").forward(request, response);;
		}else {
			out.println("<script>alert('입력실패 관리자에게 문의하세요');"
					+ "history.go(-1);</script>");
		}

	}

}
