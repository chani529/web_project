package com.son.frontController;

import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.controller.fb.BAction;
import com.son.controller.fb.BDeleteAction;
import com.son.controller.fb.BDetailAction;
import com.son.controller.fb.BEditViewAction;
import com.son.controller.fb.BListAction;
import com.son.controller.fb.BReplyAction;
import com.son.controller.fb.BReplyViewAction;
import com.son.controller.fb.BWriteAction;
import com.son.controller.fb.REditAction;

/**
 * Servlet implementation class ReplyController
 */
@WebServlet("*.reply")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boardAction(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boardAction(request, response);
	}
	private void boardAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String path= request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(path);
		if(path.equals("/list.reply")) {
			BAction command = new BListAction();
			command.execute(request, response);
		}else if(path.equals("/write_view.reply")) {
			request.getRequestDispatcher("/board/free_board/write.jsp").forward(request, response);
		}else if(path.equals("/write.reply")) {
			BAction command = new BWriteAction();
			command.execute(request, response);
		}else if(path.equals("/detail.reply")) {
			BAction command = new BDetailAction();
			command.execute(request, response);
		}else if(path.equals("/edit_view.reply")) {
			BAction command = new BEditViewAction();
			command.execute(request, response);
		}else if(path.equals("/edit.reply")) {
			BAction command = new REditAction();
			command.execute(request, response);
		}else if(path.equals("/reply_view.reply")) {
			BAction command = new BReplyViewAction();
			command.execute(request, response);
		}else if(path.equals("/reply.reply")) {
			BAction command = new BReplyAction();
			command.execute(request, response);
		}else if(path.equals("/delete_view.reply")) {
			request.getRequestDispatcher("/board/free_board/delete.jsp").forward(request, response);
		}else if(path.equals("/delete.reply")) {
			BAction command = new BDeleteAction();
			command.execute(request, response);
		}
		
	}
}
