package com.son.ajax_servlet.store;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.son.dao.StoreDao;
import com.son.dto.StoreDto;

/**
 * Servlet implementation class StoreListAction
 */
@WebServlet("/StoreScrollAction")
public class StoreScrollAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreScrollAction() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		StoreDao dao = new StoreDao();
		PrintWriter out =response.getWriter();
		int start =Integer.parseInt(request.getParameter("start"))*12;
		if(request.getParameter("cate").equals("스토어")) {
			ArrayList<StoreDto> list =dao.list12(start); 
			Gson gson = new Gson();
			JsonArray jArray = new JsonArray();
			for (int i = 0; i < list.size(); i++) {
				JsonObject storeInfo = new JsonObject();
				storeInfo.addProperty("sno", list.get(i).getSno());
				storeInfo.addProperty("simage", list.get(i).getSimage());
				storeInfo.addProperty("smaker", list.get(i).getSmaker());
				storeInfo.addProperty("sname", list.get(i).getSname());
				storeInfo.addProperty("ssale", list.get(i).getSsale());
				storeInfo.addProperty("sprice", list.get(i).getSprice());
				storeInfo.addProperty("sdelivery", list.get(i).getSdelivery());
				jArray.add(storeInfo);
			}
			System.out.println("전체");
			out.println(gson.toJson(jArray));
		}else {
			String cate = request.getParameter("cate");
			ArrayList<StoreDto> list =dao.cateList12(cate,start); 
			Gson gson = new Gson();
			JsonArray jArray = new JsonArray();
			for (int i = 0; i < list.size(); i++) {
				JsonObject storeInfo = new JsonObject();
				storeInfo.addProperty("sno", list.get(i).getSno());
				storeInfo.addProperty("simage", list.get(i).getSimage());
				storeInfo.addProperty("smaker", list.get(i).getSmaker());
				storeInfo.addProperty("sname", list.get(i).getSname());
				storeInfo.addProperty("ssale", list.get(i).getSsale());
				storeInfo.addProperty("sprice", list.get(i).getSprice());
				storeInfo.addProperty("sdelivery", list.get(i).getSdelivery());
				jArray.add(storeInfo);
			}
			System.out.println("부분");
			out.println(gson.toJson(jArray));
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
