package com.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class updateController
 */
@WebServlet("/updateController")
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("11");
		String name= request.getParameter("name");
	    String email= request.getParameter("email");
	    String password= request.getParameter("password");
	    String mob= request.getParameter("mob");
	    String dob= request.getParameter("dob");
	    String[] course= request.getParameterValues("course");
	    
	    String c="";
	    for(int i=0; i<course.length; i++)
	    c=c+course[i]+" ";
	    
	    String gender= request.getParameter("gender");
	    String address= request.getParameter("address");
	    String country= request.getParameter("country");
	   
	    String region= request.getParameter("region");
	    String pinst= request.getParameter("pin");
	    int pin=0;

	    pin = Integer.parseInt(pinst);
	    RegModel rm=new RegModel();
	    
	    rm.setName(name);
	    rm.setEmail(email);
	    rm.setPassword(password);
	    rm.setMob(mob);
	    rm.setDob(dob);
	    rm.setCourse(c);
	    rm.setGender(gender);
	    rm.setAddress(address);
	    rm.setCountry(country);
	    
	    rm.setRegion(region);
	    rm.setPin(pin);
	    rm.setId(id);
	    int status=MainDao.update(rm);
	    
	    if(status>0)
	    {
	      HttpSession session =request.getSession();
	      session.setAttribute("sesupdate", "success");
	      response.sendRedirect("dashboard.jsp");
		}
	    else
	    {
	    	System.out.println("null");
	    	System.out.println(status);
	    }
	    response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}

}
