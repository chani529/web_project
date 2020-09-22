package com.son.ajax_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/fileUpload.upload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String path = "/upload/";
		path= request.getServletContext().getRealPath(path);
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5,"UTF-8",new DefaultFileRenamePolicy());
		String upload = multi.getFilesystemName("upload");
		JsonObject jobj = new JsonObject();
		Gson gson = new Gson();
		jobj.addProperty("uploaded", 1);
		jobj.addProperty("fileName", upload);
		jobj.addProperty("url", request.getContextPath()+"/upload/"+upload);
		System.out.println(gson.toJson(jobj));
		out.println(gson.toJson(jobj));
	}

}
