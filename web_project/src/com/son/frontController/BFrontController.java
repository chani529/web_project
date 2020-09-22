package com.son.frontController;

import java.io.IOException;   
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.controller.cq.BAction;
import com.son.controller.cq.BDeleteAction;
import com.son.controller.cq.BDetailAction;
import com.son.controller.cq.BEditAction;
import com.son.controller.cq.BEditViewAction;
import com.son.controller.cq.BListAction;
import com.son.controller.cq.BWriteAction;
import com.son.controller.cq.BWrite_view_action;

/**
 * Servlet implementation class FrontController_ex
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request,response);
	}
	private void actionTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String path = request.getRequestURI().substring(request.getContextPath().length());
		PrintWriter out = response.getWriter();
		BAction command =null;
		System.out.println(path);
		if(path.equals("/BList.do")) {
			command = new BListAction();
			command.execute(request, response);
		}else if(path.equals("/BWrite_view.do")) {
			command = new BWrite_view_action();
			command.execute(request, response);
		}else if(path.equals("/BWrite.do")) {
			//데이터 받아와서 삽입
			command = new BWriteAction();
			command.execute(request, response);
			out.println("<script>alert('쓰기 성공');"
					+ "location.href='BList.do';</script>");
		}else if(path.equals("/BDetail.do")) {
			command = new BDetailAction();
			command.execute(request, response);
		}else if(path.equals("/BEdit_view.do")) {
			command = new BEditViewAction();
			command.execute(request, response);
		}else if(path.equals("/BEdit.do")) {
			command = new BEditAction();
			command.execute(request, response);
		}else if(path.equals("/BDelete_view.do")) {
			request.getRequestDispatcher("/board/customer_question/cq_del.jsp").forward(request, response);
		}else if(path.equals("/BDelete.do")) {
			command = new BDeleteAction();
			command.execute(request, response);
		}
		
	}

}
