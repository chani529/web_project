package com.son.loginApi;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.son.dao.MemberDao;
import com.son.dto.MemberDto;

/**
 * Servlet implementation class GoogleLogin
 */
@WebServlet("/GoogleLogin")
public class GoogleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoogleLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String foreignid=request.getParameter("foreignid");
		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String mnameChk = dao.foreignidChk(foreignid);
		String mname =request.getParameter("mname");
		String mimage =request.getParameter("mimage");
		String memail = request.getParameter("memail");
		if(mnameChk==null) {
			dto.setMname(mname);
			dto.setMimage(mimage);
			dto.setMemail(memail);
			dto.setForeignid(foreignid);
			dao.foreignJoin(dto);
			session.setAttribute("mname", mname);
		}else {
			session.setAttribute("mname", mnameChk);
		}
		out.println(0);
	}

}
