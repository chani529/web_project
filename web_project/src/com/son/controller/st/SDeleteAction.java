package com.son.controller.st;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.dao.StoreDao;

public class SDeleteAction implements SAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int sno = Integer.parseInt(request.getParameter("sno"));
		PrintWriter out = response.getWriter();
		StoreDao dao = new StoreDao();
		
		if(dao.deleteAction(sno)>0) {
			out.println("<script>alert('삭제성공');"
					+ "location.href='"+request.getContextPath()+"/SList.st';</script>");
		}else {
			out.println("<script>alert('삭제실패');"
					+ "location.href='"+request.getContextPath()+"/SList.st';</script>");
		}
	
		
	}

}
