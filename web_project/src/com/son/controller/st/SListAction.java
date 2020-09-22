package com.son.controller.st;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.dao.StoreDao;


public class SListAction implements SAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		StoreDao dao = new StoreDao();
		request.setAttribute("list", dao.list12(0));
		request.setAttribute("hitList", dao.hitList());
		request.getRequestDispatcher("/board/store/store_list.jsp").forward(request, response);
	}

}
