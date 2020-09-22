package com.son.controller.st;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.son.dao.CategoryDao;
import com.son.dao.OptionDao;
import com.son.dao.StoreConDao;
import com.son.dao.StoreDao;
import com.son.dto.OptionDto;
import com.son.dto.StoreDto;

public class SWriteAction implements SAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		StoreDao dao = new StoreDao();
		StoreDto dto = new StoreDto();
		String path = "/upload/";
		path= request.getServletContext().getRealPath(path);
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "UTF-8",new DefaultFileRenamePolicy());
		String simage = multi.getFilesystemName("simage");
		if(simage == null) {
			simage = "no.jpg";
		}
		String category = multi.getParameter("category");
		String sub_category = multi.getParameter("sub_category");
		String sub_sub_category = multi.getParameter("sub_sub_category");
		String smaker = multi.getParameter("smaker");
		String sname = multi.getParameter("sname");
		String pname = (String)session.getAttribute("mname");
		String ssale = multi.getParameter("ssale");
		String sprice = multi.getParameter("sprice");
		String sdelivery = multi.getParameter("sdelivery");
		String scontent = multi.getParameter("scontent");
		int cno = new CategoryDao().getCno(category, sub_category, sub_sub_category);
		dto.setSname(sname);
		dto.setPname(pname);
		dto.setSprice(Integer.parseInt(sprice));
		dto.setSsale(Integer.parseInt(ssale));
		dto.setSdelivery(Integer.parseInt(sdelivery));
		dto.setSip(InetAddress.getLocalHost().getHostAddress());
		dto.setSimage(simage);
		dto.setSmaker(smaker);
		dto.setCno(cno);
		int sno = dao.insertStore(dto);
		System.out.println("insert sno : " + sno);
		String[] option_name = multi.getParameterValues("option_name");
		String[] option_content = multi.getParameterValues("option_content");
		String[] option_price = multi.getParameterValues("option_price");
		OptionDao oDao = new OptionDao();
		for (int i = 0; i < option_name.length; i++) {
			oDao.insertOption(new OptionDto(sno, option_name[i], option_content[i],Integer.parseInt(option_price[i])));
		}
		new StoreConDao().insertContent(sno, scontent);
		request.getRequestDispatcher("/SList.st").forward(request, response);
	}

}
