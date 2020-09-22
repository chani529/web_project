package com.son.mcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.son.dao.MemberDao;
import com.son.dto.MemberDto;

public class MnameSelectAction implements MAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto();
		HttpSession session = request.getSession();
		String mname = (String)session.getAttribute("mname");
		dto = dao.selectMname(mname);
		request.setAttribute("dto", dto);
	}

}
