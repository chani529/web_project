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
import com.son.dao.OptionDao;
import com.son.dto.OptionDto;

/**
 * Servlet implementation class Option
 */
@WebServlet("/Option")
public class Option extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Option() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		OptionDao dao = new OptionDao();
		JsonObject jObj = new JsonObject();
		PrintWriter out = response.getWriter();
		int sno = Integer.parseInt(request.getParameter("sno"));
		ArrayList<String> list = dao.getOptionName(sno);
		System.out.println(list);
		Gson gson = new Gson();
		for (int i = 0; i < list.size(); i++) {
			ArrayList<OptionDto> option_con = null;;
			JsonArray jArray = null;
			option_con = dao.getOptionContent(list.get(i),sno);
			jArray = new JsonArray();
			for (int j = 0; j < option_con.size(); j++) {
				JsonObject option = new JsonObject();
				option.addProperty("option_content", option_con.get(j).getOption_content());
				option.addProperty("option_price", option_con.get(j).getOption_price());
				option.addProperty("ono", option_con.get(j).getOno());
				jArray.add(option);
			}
			System.out.println(gson.toJson(jArray));
			jObj.add(list.get(i), jArray);
		}
		System.out.println(gson.toJson(jObj));
		out.println(gson.toJson(jObj));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
