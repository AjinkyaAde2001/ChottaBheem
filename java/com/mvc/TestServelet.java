package com.mvc;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServelet extends HttpServlet {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        response.getWriter().println("Servlet is working!");
	    }
}
