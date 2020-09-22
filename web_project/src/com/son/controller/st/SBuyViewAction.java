package com.son.controller.st;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.son.dao.OptionDao;
import com.son.dao.StoreDao;
import com.son.dto.CartDto;
import com.son.dto.OptionDto;
import com.son.dto.StoreDto;

public class SBuyViewAction implements SAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String[] prod_chk = request.getParameterValues("prod_chk");
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
		ArrayList<CartDto> list = new ArrayList<CartDto>();
		for (int i = arr.size()-1; i >= 0; i--) {
			boolean chk = true;
			for (int j = 0; j < prod_chk.length; j++) {
				if(i==Integer.parseInt(prod_chk[j])) {chk=false;break;}
			}
			if(chk) {continue;}
			JsonObject obj = (JsonObject)(arr.get(i));
			StoreDto sdto = new StoreDao().selectSno(Integer.parseInt(gson.toJson(obj.get("sno"))));
			OptionDto dto = new OptionDao().getOption(Integer.parseInt(gson.toJson(obj.get("ono"))));
			list.add(new CartDto(sdto.getSimage(), sdto.getSname(), sdto.getSdelivery(), dto.getOption_content(), dto.getOption_price(), Integer.parseInt(gson.toJson(obj.get("num"))), i));
		}
		request.setAttribute("list", list);
		}
		request.getRequestDispatcher("/board/store/store_buy.jsp").forward(request, response);
	}

}
