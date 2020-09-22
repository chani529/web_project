package com.son.mcontroller;

import java.io.IOException; 
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.son.dao.BuyDao;
import com.son.dao.MemberDao;
import com.son.dao.OptionDao;
import com.son.dao.StoreDao;
import com.son.dto.BuyDto;
import com.son.dto.MemberDto;
import com.son.dto.MypageCartDto;
import com.son.dto.OptionDto;
import com.son.dto.StoreDto;

public class MypageAction implements MAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		MemberDao dao= new MemberDao();
		MemberDto dto = new MemberDto();
		BuyDao buyDao = new BuyDao();
		BuyDto buyDto = new BuyDto();
		ArrayList<BuyDto> bList = new ArrayList<BuyDto>();
		ArrayList<MypageCartDto> list = new ArrayList<MypageCartDto>();
		HttpSession session = request.getSession();
		String mname = (String)session.getAttribute("mname");
		dto = dao.selectMname(mname);
		buyDto.setMname(mname);
		bList=buyDao.selectAll(buyDto);
		request.setAttribute("dto", dto);
		for (int i = 0; i < bList.size(); i++) {
			StoreDto sDto = new StoreDao().selectSno(bList.get(i).getSno());
			OptionDto oDto = new OptionDao().getOption(bList.get(i).getOno());
			int price=oDto.getOption_price()*bList.get(i).getNum()+sDto.getSdelivery();
			System.out.println("price: "+price);
			list.add(new MypageCartDto(bList.get(i).getBno(), sDto.getSimage(), sDto.getSname(), oDto.getOption_content(), price, bList.get(i).getNum(), bList.get(i).getBdate().substring(0,10),bList.get(i).getAddress(),bList.get(i).getAddress1()));
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/member/mypage.jsp").forward(request, response);
	}

}
