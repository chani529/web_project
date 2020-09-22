package com.son.controller.cq;

import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.son.dao.BoardDao;
import com.son.dao.MemberDao;
import com.son.dto.MemberDto;

public class BDeleteAction implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		BoardDao dao = new BoardDao();
		MemberDao mdao = new MemberDao();
		MemberDto mdto = new MemberDto();
		HttpSession session = request.getSession();
		mdto = mdao.selectMname((String)session.getAttribute("mname"));
		int bno= Integer.parseInt(request.getParameter("bno"));
		if(mdto.getMpass().equals(request.getParameter("bpass"))) {
			int result = dao.delete(bno);
			if(result>0) {
				out.println("<script>alert('삭제 성공');"
						+ "location.href='"+request.getContextPath()+"/BList.do';</script>");
			}else {
				out.println("<script>alert('삭제 실패');"
						+ "history.go(-1);</script>");
			}
		}else {
			out.println("<script>alert('비밀번호가 틀렸습니다');"
					+ "history.go(-1);</script>");
		}
		
	}

}
