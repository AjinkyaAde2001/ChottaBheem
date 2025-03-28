package com.mvc;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		
		LoginModel lm=new LoginModel();
		lm.setEmail(email);
		lm.setPassword(password);
		
		int Status=MainDao.doLogin(lm);
		if(Status>0)
		{
			  HttpSession session =request.getSession();
		      session.setAttribute("seslogs", "lm.getEmail()");
		      RequestDispatcher rd=request.getRequestDispatcher("ViewController");
		      rd.forward(request, response);
		}
		else
		{
			HttpSession session =request.getSession();
		    session.setAttribute("seslogs", "failed");
		    response.sendRedirect("login.jsp");
		}
		
		doGet(request, response);
		 HttpSession session =request.getSession();
	
		 session.setAttribute("loggedInUsername", email);

 
	}

}
