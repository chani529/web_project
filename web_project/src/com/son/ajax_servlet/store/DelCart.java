package com.son.ajax_servlet.store;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class DelCart
 */
@WebServlet("/DelCart")
public class DelCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String[] paramVal=  request.getParameterValues("delNum");
		int[] delNum = new int[paramVal.length];
		for (int i = 0; i < delNum.length; i++) {
			delNum[i]=Integer.parseInt(paramVal[i]);
		}
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
		JsonArray arr = (JsonArray)jPar.parse(cartCookie);
		JsonArray result = new JsonArray();
		for (int i =0; i < arr.size(); i++) {
			boolean del = false;
			for (int j = 0; j < delNum.length; j++) {
				if(i==delNum[j]) {del=true;break;}
			}
			if(del) {continue;}
			JsonObject obj = (JsonObject)(arr.get(i));
			result.add(obj);
		}
		if(gson.toJson(result).equals("[]")) {
			Cookie cart = new Cookie("cart","");
			 cart.setMaxAge(0);
			 response.addCookie(cart);
			 PrintWriter out = response.getWriter();
			 out.println(1);
		}else {
		 Cookie cart = new Cookie("cart",URLEncoder.encode(gson.toJson(result),"UTF-8"));
		 cart.setMaxAge(60*60*24);//하루
		 response.addCookie(cart);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
