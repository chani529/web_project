package com.son.frontController;

import java.io.IOException;    
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.son.mcontroller.DeleteAction;
import com.son.mcontroller.EditAction;
import com.son.mcontroller.EditPassAction;
import com.son.mcontroller.JoinAction;
import com.son.mcontroller.LoginAction;
import com.son.mcontroller.LogoutAction;
import com.son.mcontroller.MAction;
import com.son.mcontroller.MnameSelectAction;
import com.son.mcontroller.MypageAction;

/**
 * Servlet implementation class MfrontController
 */
@WebServlet("*.members")
public class MFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MFrontController() {
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
		response.setContentType("text/html;charset=UTF-8");
		MAction command =null;
		String path= request.getRequestURI().substring(request.getContextPath().length());
		if(path.equals("/join_view.members")) {
			request.getRequestDispatcher("/member/join.jsp").forward(request, response);
		}else if(path.equals("/join.members")) {
			command= new JoinAction();
			command.execute(request, response);
		}else if(path.equals("/login_view.members")) {
			request.getRequestDispatcher("/member/login.jsp").forward(request, response);
		}else if(path.equals("/mypage_view.members")) {
			command = new MypageAction();
			command.execute(request, response);
		}else if(path.equals("/mypage_edit_view.members")) {
			command = new MnameSelectAction();
			command.execute(request, response);
			request.getRequestDispatcher("/member/edit.jsp").forward(request, response);
		}else if(path.equals("/mypage_edit.members")) {
			command = new EditAction();
			command.execute(request, response);
		}else if(path.equals("/mypage_pass_view.members")) {
			request.getRequestDispatcher("/member/edit_pass.jsp").forward(request, response);
		}else if(path.equals("/mypage_pass.members")) {
			command = new EditPassAction();
			command.execute(request, response);
		}else if(path.equals("/mypage_delete.members")) {
			command = new DeleteAction();
			command.execute(request, response);
		}else if(path.equals("/login.members")) {
			command= new LoginAction();
			command.execute(request, response);
		}else if(path.equals("/logout.members")) {
			command= new LogoutAction();
			command.execute(request, response);
		}
		
	}

}
