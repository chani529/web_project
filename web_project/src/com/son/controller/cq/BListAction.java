package com.son.controller.cq;

import java.io.IOException; 


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.son.dao.BoardDao;
import com.son.dto.PagingDto;

public class BListAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		BoardDao dao = new BoardDao();
		PagingDto dto = new PagingDto();
		int listCnt=dao.listCnt();
		dto.setPageTotal(listCnt);
		int onPageLimit = 10;
		dto.setOnPageLimit(onPageLimit);
		int pageAll=(int) Math.ceil(dto.getPageTotal()/(float)dto.getOnPageLimit());
		dto.setPageAll(pageAll);
		int pno=0;
		if(request.getParameter("pno")!=null) {
			pno = Integer.parseInt(request.getParameter("pno"))*10-10;
		}
		dto.setPno(pno);
		int bottom_current=((int) Math.ceil((pno+1)/(float)onPageLimit));
		dto.setBottom_current(bottom_current);
		int bottomList = 10;
		int botton_start=((int)( Math.floor(bottom_current-1)/(float)bottomList)*bottomList+1);
		dto.setBottom_start(botton_start);
		int botton_end = botton_start+bottomList-1;
		if(pageAll<botton_end) {
			botton_end=pageAll;
		}
		System.out.println("pno: "+pno);
		System.out.println("bottom_current: "+bottom_current);
		System.out.println("botton_start: "+botton_start);
		System.out.println("botton_end: "+botton_end);
		System.out.println("pageAll: "+pageAll);
		dto.setList(dao.list10(pno));
		dto.setBottom_end(botton_end);
		request.setAttribute("list", dto);
		request.getRequestDispatcher("/board/customer_question/cq_list.jsp").forward(request, response);
		}
}
