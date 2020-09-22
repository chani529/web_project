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
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Gson gson = new Gson();
		JsonArray result = new JsonArray();
		PrintWriter out = response.getWriter();
		int sno = Integer.parseInt(request.getParameter("sno"));
		String[] num = request.getParameterValues("prod_num");
		String[] ono = request.getParameterValues("ono");
		boolean cookieChk=false;
		
		String cookie = request.getHeader("Cookie");
		String cartCookie = null;
		  if(cookie!=null){
			  Cookie[] cookies = request.getCookies();
			  for(int i =0;i<cookies.length;i++){
				  if(cookies[i].getName().equals("cart")){
					  JsonParser jPar = new JsonParser();
					  cartCookie=cookies[i].getValue();
					  cartCookie=URLDecoder.decode(cartCookie,"UTF-8");
					  result = (JsonArray)jPar.parse(cartCookie);
					  for (int j = 0; j < ono.length; j++) {
							JsonObject jObj = new JsonObject();
							jObj.addProperty("sno", sno);
							jObj.addProperty("ono", Integer.parseInt(ono[j]));
							jObj.addProperty("num", Integer.parseInt(num[j]));
							result.add(jObj);
							cookieChk=true;
						}
					  break;
				  }
			  }
		  }
		  if(!cookieChk) {
			  for (int j = 0; j < ono.length; j++) {
					JsonObject jObj = new JsonObject();
					jObj.addProperty("sno", sno);
					jObj.addProperty("ono", Integer.parseInt(ono[j]));
					jObj .addProperty("num", Integer.parseInt(num[j]));
					result.add(jObj);
				}
		  }
		  System.out.println("장바구니 쿠키 : "+gson.toJson(result));
		 Cookie cart = new Cookie("cart",URLEncoder.encode(gson.toJson(result),"UTF-8"));
		cart.setMaxAge(60*60*24);//하루
		response.addCookie(cart);
		out.println(gson.toJson(result));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
