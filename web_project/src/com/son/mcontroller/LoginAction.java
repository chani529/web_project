package com.son.mcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.son.dao.MemberDao;

public class LoginAction implements MAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset = UTF-8");
		String memail = request.getParameter("memail");
		String mpass = request.getParameter("mpass");
		String chkbox = request.getParameter("id_chkbox");
		System.out.println(memail);
		System.out.println(mpass);
		MemberDao dao= new MemberDao();
		String mname= dao.login(memail, mpass);
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if(mname!=null) {
			session.setAttribute("mname", mname);
			if(chkbox!=null){
				Cookie nameCookie = new Cookie("nameCookie",memail);
				nameCookie.setMaxAge(60000);
				response.addCookie(nameCookie);
			}else{
				  String cookie = request.getHeader("Cookie");
				  if(cookie !=null){
					  Cookie[] cookies= request.getCookies();
					  for(int i =0;i<cookies.length;i++){
						  if(cookies[i].getName().equals("nameCookie")){
							  cookies[i].setMaxAge(0);
							  response.addCookie(cookies[i]);
							  break;
						  }
					  }
				  }
			}
			out.println("<script>alert('로그인 성공');"
					+ "location.href='"+request.getContextPath()+"/mypage_view.members';</script>");
		}else {
			out.println("<script>alert('로그인 실패');"
					+ "history.go(-1);</script>");
		}
	}

}
