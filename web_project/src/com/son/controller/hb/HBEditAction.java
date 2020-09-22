package com.son.controller.hb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.son.dao.HomeBoardDao;
import com.son.dto.HomeBoardDto;

public class HBEditAction implements HBAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HomeBoardDao dao = new HomeBoardDao();
		HomeBoardDto dto = new HomeBoardDto();
		int result = -1;
		PrintWriter out = response.getWriter();
		String path="/upload/";
		path= request.getServletContext().getRealPath(path);
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
		int bno = Integer.parseInt(multi.getParameter("bno"));
		int residence = Integer.parseInt(multi.getParameter("residence"));
		int realArea = Integer.parseInt(multi.getParameter("realArea"));
		int expertise = Integer.parseInt(multi.getParameter("expertise"));
		String family = multi.getParameter("family");
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		if(bfile==null) {
			bfile = multi.getParameter("hidden_bfile");
		}
		dto.setBno(bno);
		dto.setResidence(residence);
		dto.setRealArea(realArea);
		dto.setExpertise(expertise);
		dto.setFamily(family);
		dto.setBtitle(btitle);
		dto.setBcontent(bcontent);
		dto.setBfile(bfile);
		result = dao.update(dto);
		if(result>0) {
			out.println("<script>alert('수정 성공');"
					+ "location.href='"+request.getContextPath()+"/HBList.hb';</script>");
		}else {
			out.println("<script>alert('수정 실패 관리자에게 문의하세요');"
					+ "history.go(-1);</script>");
		}
	}

}
