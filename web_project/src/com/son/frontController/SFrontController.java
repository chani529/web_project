package com.son.frontController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.controller.st.SAction;
import com.son.controller.st.SBuyAction;
import com.son.controller.st.SBuyViewAction;
import com.son.controller.st.SCartAction;
import com.son.controller.st.SDeleteAction;
import com.son.controller.st.SDeleteViewAction;
import com.son.controller.st.SDetailAction;
import com.son.controller.st.SEditAction;
import com.son.controller.st.SEditViewAction;
import com.son.controller.st.SListAction;
import com.son.controller.st.SWriteAction;
import com.son.controller.st.SWriteViewAction;
import com.son.controller.st.SearchAction;

/**
 * Servlet implementation class SFrontController
 */
@WebServlet("*.st")
public class SFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storeAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storeAction(request,response);
	}
	private void storeAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(path);
		
		if(path.equals("/SList.st")) {
			SAction command = new SListAction();
			command.execute(request, response);
		}else if(path.equals("/SWrite_view.st")) {
			SAction command = new SWriteViewAction();
			command.execute(request, response);
		}else if(path.equals("/SWrite.st")) {
			SAction command = new SWriteAction();
			command.execute(request, response);
		}else if(path.equals("/SDetail.st")) {
			SAction command = new SDetailAction();
			command.execute(request, response);
		}else if(path.equals("/SEdit_view.st")) {
			SAction command = new SEditViewAction();
			command.execute(request, response);
		}else if(path.equals("/SEdit.st")) {
			SAction command = new SEditAction();
			command.execute(request, response);
		}else if(path.equals("/SDelete_view.st")) {
			SAction command = new SDeleteViewAction();
			command.execute(request, response);
		}else if(path.equals("/SDelete.st")) {
			SAction command = new SDeleteAction();
			command.execute(request, response);
		}else if(path.equals("/SCart.st")) {
			SAction command = new SCartAction();
			command.execute(request, response);
		}else if(path.equals("/SBuyView.st")) {
			SAction command = new SBuyViewAction();
			command.execute(request, response);
		}else if(path.equals("/SBuy.st")) {
			SAction command = new SBuyAction();
			command.execute(request, response);
		}else if(path.equals("/Search.st")) {
			SAction command = new SearchAction();
			command.execute(request, response);
		}
	}
}
