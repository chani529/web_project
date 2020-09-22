package com.son.controller.st;

import java.io.IOException; 
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.son.dao.BuyDao;
import com.son.dto.BuyDto;


public class SBuyAction implements SAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		HttpSession session = request.getSession();
		String mname=(String) session.getAttribute("mname");
		String[] indexIds= request.getParameterValues("indexId");
		int result=-1;
		if(mname==null) {
			mname="비회원";
		}
		String postcode = request.getParameter("postcode");
		String address = request.getParameter("address");
		String address1 = request.getParameter("address1");
		
		String cookie = request.getHeader("Cookie");
		String cartCookie = null;
		if (cookie != null) {
			Cookie[] cookies = request.getCookies();
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("cart")) {
					cartCookie = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
					break;
				}
			}
		}
		JsonParser jPar = new JsonParser();
		Gson gson = new Gson();
		if(cartCookie!=null) {
		JsonArray arr = (JsonArray)jPar.parse(cartCookie);
		System.out.println(arr.size());
		for (int i = arr.size()-1; i >= 0; i--) {
			boolean chk = true;
			for (int j = 0; j < indexIds.length; j++) {
				if(i==Integer.parseInt(indexIds[j])) {chk=false;break;}
			}
			if(chk) {continue;}
			JsonObject obj = (JsonObject)(arr.get(i));
			BuyDto buyDto = new BuyDto();
			buyDto.setMname(mname);
			buyDto.setPostcode(postcode);
			buyDto.setAddress(address);
			buyDto.setAddress1(address1);
			buyDto.setSno(Integer.parseInt(gson.toJson(obj.get("sno"))));
			buyDto.setOno(Integer.parseInt(gson.toJson(obj.get("ono"))));
			buyDto.setNum(Integer.parseInt(gson.toJson(obj.get("num"))));
			buyDto.setBip(InetAddress.getLocalHost().getHostAddress());
			result =new BuyDao().insertBuy(buyDto);
		}
			out.println("<script>alert('구매 성공\\n상품 주문 번호: "+result+"');"
					+ "location.href='"+request.getContextPath()+"/SList.st';</script>");
	
		}
	}

}
