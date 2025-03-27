package com.mvc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	public static Connection getConnection()
	{
		Connection con=null;
	    
	    try
	    {
	      Class.forName("com.mysql.jdbc.Driver");
	     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mvc", "root", "");
	      
	    }
	    catch(Exception ex)
	    {
	      System.out.println("Exception:"+ex);
	    }
		return con;
	}
	
}
