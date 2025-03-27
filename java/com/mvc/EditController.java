package com.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("2");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 System.out.println("1");
			String idStr = request.getParameter("id");
			 System.out.println(idStr);
			
		    try {
		        int id = Integer.parseInt(idStr);
		        MainDao mainDao = new MainDao();
		        
	   System.out.println("1");
		        // Retrieve the RegModel from the MainDao
		        RegModel rm = mainDao.getRegById(id);

		        if (rm != null) {
		            // Store the RegModel in the session
		            HttpSession session = request.getSession();
		            session.setAttribute("rm", rm);

		            // Redirect to the edit.jsp page
		            response.sendRedirect("edir.jsp");
		        } else {
		            // Handle the case where no RegModel is found for the given ID
		            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		            response.getWriter().write("No matching record found for the given 'id'.");
		        }
		    } catch (NumberFormatException e) {
		        // Handle the case where the "id" parameter cannot be parsed as an integer
		        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		        response.getWriter().write("Please provide a valid integer 'id' parameter.");
		    }
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("1");
		 doGet(request, response);
	}
}
	


