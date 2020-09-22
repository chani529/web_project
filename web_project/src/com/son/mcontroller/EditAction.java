package com.son.mcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.son.dao.MemberDao;
import com.son.dto.MemberDto;

public class EditAction implements MAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		MemberDao dao= new MemberDao();
		MemberDto dto = new MemberDto();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String path="/upload/";
		path= request.getServletContext().getRealPath(path);
		int result=-1;
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
		String mpass=multi.getParameter("mpass");
		String mbirthday=multi.getParameter("mbirthday");
		if(mbirthday.equals("")) {
			mbirthday=null;
		}
		String sessionMname= (String)session.getAttribute("mname");
		result = dao.passChkAction(sessionMname, mpass);
		if(result<1) {
			out.println("<script>alert('비밀번호가 틀렸습니다');"
					+ "history.go(-1);</script>");
		}else {
		String mname=multi.getParameter("mname");
		result=dao.mnameChk(mname);
		if(result>0&&!mname.equals(sessionMname)) {
			out.println("<script>alert('변경할 아이디가 중복입니다');"
					+ "history.go(-1);</script>");
		}else {
		String mimage = multi.getFilesystemName("mimage");
		if(mimage==null) {
			mimage="no.jpg";
		}
		dto.setMname(mname);
		dto.setMimage(mimage);
		dto.setMintro(multi.getParameter("mintro"));
		dto.setMimage(mimage);
		dto.setMbirthday(mbirthday);
		if(dao.editAction(dto,sessionMname)>0) {
			session.setAttribute("mname", mname);
			out.println("<script>alert('수정에 성공했습니다');"
					+ "location.href='"+request.getContextPath()+"/mypage_view.members'</script>");
		}else {
			out.println("<script>alert('수정에 실패했습니다\n관리자에게 문의하세요');"
					+ "history.go(-1);</script>");
		}
		}
		}
	}

}
