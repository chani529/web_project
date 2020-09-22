package com.son.controller.hb;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.son.dao.HomeBoardDao;
import com.son.dao.MemberDao;
import com.son.dto.HomeBoardDto;

public class HBWriteAction implements HBAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HomeBoardDto dto = new HomeBoardDto();
		HomeBoardDao dao = new HomeBoardDao();
		String path="/upload/";
		path= request.getServletContext().getRealPath(path);
		MultipartRequest multi =new MultipartRequest(request, path, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
		int result=0;
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String mname=(String)session.getAttribute("mname");
		dto.setResidence(Integer.parseInt(multi.getParameter("residence")));
		dto.setRealArea(Integer.parseInt(multi.getParameter("realArea")));
		dto.setExpertise(Integer.parseInt(multi.getParameter("expertise")));
		dto.setFamily(multi.getParameter("family"));
		dto.setBtitle(multi.getParameter("btitle"));
		dto.setBcontent(multi.getParameter("bcontent"));
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		dto.setBfile(multi.getFilesystemName("bfile"));
		dto.setMname(mname);
		String mimage=new MemberDao().getMimage(mname);
		dto.setMimage(mimage);
		result = dao.writeAction(dto);
		if(result>0) {
			out.println("<script>alert('글쓰기 성공');"
					+ "location.href='"+request.getContextPath()+"/HBList.hb';</script>");
		}else {
			out.println("<script>alert('입력실패 관리자에게 문의하세요');"
					+ "history.go(-1);</script>");
		}
		
	}

}
