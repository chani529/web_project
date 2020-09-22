package com.son.frontController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.controller.hb.HBAction;
import com.son.controller.hb.HBDeleteAction;
import com.son.controller.hb.HBDetailView;
import com.son.controller.hb.HBEditAction;
import com.son.controller.hb.HBEditView;
import com.son.controller.hb.HBList;
import com.son.controller.hb.HBWriteAction;
import com.son.controller.hb.HBWriteView;

/**
 * Servlet implementation class HBFrontController
 */
@WebServlet("*.hb")
public class HBFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HBFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request, response);
	}
	
	private void actionTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(path);
		HBAction command = null;
		if(path.equals("/HBList.hb")) {
			command = new HBList();
			command.execute(request, response);
		}else if(path.equals("/HBWrite_view.hb")) {
			command = new HBWriteView();
			command.execute(request, response);
		}else if(path.equals("/HBWrite.hb")) {
			command = new HBWriteAction();
			command.execute(request, response);
		}else if(path.equals("/HBDetail_view.hb")) {
			command = new HBDetailView();
			command.execute(request, response);
		}else if(path.equals("/HBEdit_view.hb")) {
			command = new HBEditView();
			command.execute(request, response);
		}else if(path.equals("/HBEdit.hb")) {
			command = new HBEditAction();
			command.execute(request, response);
		}else if(path.equals("/HBDelete.hb")) {
			command = new HBDeleteAction();
			command.execute(request, response);
		}
	}

}
