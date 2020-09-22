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
@WebServlet("/StoreListAction")
public class StoreListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreListAction() {
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
		String cate = request.getParameter("cate");
		ArrayList<StoreDto> list =dao.subCateList12(0, cate); ////////////
		Gson gson = new Gson();
		JsonArray listArray = new JsonArray();
		for (int i = 0; i < list.size(); i++) {
			JsonObject storeInfo = new JsonObject();
			storeInfo.addProperty("sno", list.get(i).getSno());
			storeInfo.addProperty("simage", list.get(i).getSimage());
			storeInfo.addProperty("smaker", list.get(i).getSmaker());
			storeInfo.addProperty("sname", list.get(i).getSname());
			storeInfo.addProperty("ssale", list.get(i).getSsale());
			storeInfo.addProperty("sprice", list.get(i).getSprice());
			storeInfo.addProperty("sdelivery", list.get(i).getSdelivery());
			listArray.add(storeInfo);
		}
		JsonObject allListMenu = new JsonObject();
		allListMenu.add("allList", listArray);
		ArrayList<StoreDto> hitList =dao.cateHitList(cate);////////////
		JsonArray hitListArray = new JsonArray();
		for (int i = 0; i < hitList.size(); i++) {
			JsonObject storeInfo = new JsonObject();
			storeInfo.addProperty("sno", hitList.get(i).getSno());
			storeInfo.addProperty("simage", hitList.get(i).getSimage());
			storeInfo.addProperty("smaker", hitList.get(i).getSmaker());
			storeInfo.addProperty("sname", hitList.get(i).getSname());
			storeInfo.addProperty("ssale", hitList.get(i).getSsale());
			storeInfo.addProperty("sprice", hitList.get(i).getSprice());
			storeInfo.addProperty("sdelivery", hitList.get(i).getSdelivery());
			hitListArray.add(storeInfo);
		}
		JsonObject hitListMenu = new JsonObject();
		hitListMenu.add("hitList", hitListArray);
		JsonArray result = new JsonArray();
		result.add(hitListMenu);
		result.add(allListMenu);
		System.out.println(gson.toJson(result));
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
