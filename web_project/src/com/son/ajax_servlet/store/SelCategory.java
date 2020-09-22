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
import com.son.dao.CategoryDao;

/**
 * Servlet implementation class SelCategory
 */
@WebServlet("/SelCategory")
public class SelCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset = UTF-8");
		CategoryDao dao = new CategoryDao();
		String category = request.getParameter("category");
		System.out.println("cate"+category);
		ArrayList<String> list = dao.selectCategory(category);
		JsonArray jArray = new JsonArray();
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		for (int i = 0; i < list.size(); i++) {
			JsonObject jObj = new JsonObject();
			jObj.addProperty("category", list.get(i));
			jArray.add(jObj);
		}
		out.println(gson.toJson(jArray));
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
