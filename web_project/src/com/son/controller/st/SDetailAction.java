package com.son.controller.st;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.dao.CategoryDao;
import com.son.dao.StoreConDao;
import com.son.dao.StoreDao;
import com.son.dto.CategoryDto;
import com.son.dto.StoreDto;

public class SDetailAction implements SAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int sno = Integer.parseInt(request.getParameter("sno"));
		StoreDao dao = new StoreDao();
		int result = dao.hitUpdate(sno);
		if(result<=0) {
			request.getRequestDispatcher("/board/store/store_no.jsp").forward(request, response);
		}
		StoreDto dto = dao.selectSno(sno);
		System.out.println(dto);
		CategoryDao cDao = new CategoryDao();
		CategoryDto cate= cDao.getCategory(dto.getCno());
		System.out.println(cate);
		request.setAttribute("dto", dto);
		request.setAttribute("cate", cate);
		request.setAttribute("content", new StoreConDao().getContent(sno));
		request.getRequestDispatcher("/board/store/store_detail.jsp").forward(request, response);
	}
}
