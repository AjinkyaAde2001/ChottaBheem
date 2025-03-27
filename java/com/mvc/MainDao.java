package com.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class MainDao {

	public static int save(RegModel rm) {
		// TODO Auto-generated method stub
		int j=0;
	    try
	    {
	      Connection con=ConnectionProvider.getConnection();
	      String sql="insert into tb_reg (name, email,password, mob,dob,course,gender,address,country,region,pin) values ('"+rm.getName()+"', '"+rm.getEmail()+"', '"+rm.getPassword()+"', '"+rm.getMob()+"', '"+rm.getDob()+"', '"+rm.getCourse()+"', '"+rm.getGender()+"', '"+rm.getAddress()+"', '"+rm.getCountry()+"', '"+rm.getRegion()+"', '"+rm.getPin()+"')";
	      PreparedStatement pst=con.prepareStatement(sql);
	      j=pst.executeUpdate();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    
	    return j;
	 
	    
	}
	
	
	public static int doLogin(LoginModel lm)
	{
		int i=0;
		try {
			Connection con1=ConnectionProvider.getConnection();
			String sql="select * from tb_reg where email='"+lm.getEmail()+"' and password='"+lm.getPassword()+"'";
			PreparedStatement pst1=con1.prepareStatement(sql);
			ResultSet rs=pst1.executeQuery();
			if(rs.next())
			{
				i=1;
			}
			
			
		}catch(Exception r)
		{
			System.out.println(""+r);
		}
		return i;
	}
	
	public static List<RegModel> getList() {
	    // TODO Auto-generated method stub
	    
	    List<RegModel> list=new ArrayList<RegModel>();
	    try
	    {
	      Connection con=ConnectionProvider.getConnection();
	      String sql2="select * from tb_reg";
	      PreparedStatement pst2=con.prepareStatement(sql2);
	      ResultSet rs1=pst2.executeQuery();
	      while(rs1.next()) 
	      {
	        RegModel r=new RegModel();
	        r.setId(rs1.getInt("id"));
	        r.setName(rs1.getString("name"));
	        r.setEmail(rs1.getString("email"));
	        r.setPassword(rs1.getString("password"));
	        r.setMob(rs1.getString("mob"));
	        r.setDob(rs1.getString("dob"));
	        r.setCourse(rs1.getString("course"));
	        r.setGender(rs1.getString("gender"));
	        r.setAddress(rs1.getString("address"));
	        r.setCountry(rs1.getString("country"));
	        r.setRegion(rs1.getString("region"));
	        r.setPin(rs1.getInt("pin"));
	        System.out.println("id to update"+rs1.getInt("id"));
	        list.add(r);
	      }
	    }
	    catch(Exception e)
	    {
	      System.out.println(""+e);
	      
	    }
	    
	return list;
	}
	
	public RegModel getRegById(int id) {
		RegModel rm=new RegModel();
		 try
		    {
		      Connection con=ConnectionProvider.getConnection();
		      String sql2="select * from tb_reg where id='"+id+"' ";
		      PreparedStatement pst2=con.prepareStatement(sql2);
		      ResultSet rs1=pst2.executeQuery();
		      
		      while(rs1.next()) 
		      {
		        //RegModel r=new RegModel();
		    	rm.setId(rs1.getInt("id"));  
		        rm.setName(rs1.getString("name"));
		        rm.setEmail(rs1.getString("email"));
		        rm.setPassword(rs1.getString("password"));
		        rm.setMob(rs1.getString("mob"));
		        rm.setDob(rs1.getString("dob"));
		        rm.setCourse(rs1.getString("course"));
		        rm.setGender(rs1.getString("gender"));
		        rm.setAddress(rs1.getString("address"));
		        rm.setCountry(rs1.getString("country"));
		        rm.setRegion(rs1.getString("region"));
		        rm.setPin(rs1.getInt("pin"));
		        
		        System.out.println("id to update"+rs1.getInt("id"));
		      }
		    }
		    catch(Exception e)
		    {
		      System.out.println(""+e);
		    }
		
		return rm;
	}
		
	


	public static int update(RegModel rm) {
		int rowsUpdated=0;
		 
		System.out.println("ID to update: " + rm.getId());

		try {
			Connection con=ConnectionProvider.getConnection();
			// Assuming you have a connection to your database
			
			// Create the SQL update query
			String str = "UPDATE tb_reg SET name=?, email=?, password=?, mob=?, dob=?, course=?, gender=?, address=?, country=?, region=?, pin=? WHERE id=?";

		
			    // Create a PreparedStatement
			    PreparedStatement preparedStatement = con.prepareStatement(str);

			    // Set the parameters for the PreparedStatement
			    preparedStatement.setString(1, rm.getName());
			    preparedStatement.setString(2, rm.getEmail());
			    preparedStatement.setString(3, rm.getPassword());
			    preparedStatement.setString(4, rm.getMob());
			    preparedStatement.setDate(5, java.sql.Date.valueOf(rm.getDob()));
			    preparedStatement.setString(6, rm.getCourse());
			    preparedStatement.setString(7, rm.getGender());
			    preparedStatement.setString(8, rm.getAddress());
			    preparedStatement.setString(9, rm.getCountry());
			    preparedStatement.setString(10, rm.getRegion());
			    preparedStatement.setInt(11, rm.getPin());

			    // Assuming you have an ID for the user, set it as the last parameter
			    preparedStatement.setInt(12, rm.getId()); // Replace 'userId' with the actual user's ID

			    // Execute the update query
			     rowsUpdated = preparedStatement.executeUpdate();

			    if (rowsUpdated > 0) {
			        System.out.println("Update successful.");
			    } else {
			        System.out.println("No records were updated.");
			    }
			   // return rowsUpdated;
			} catch (Exception e) {
			    e.printStackTrace();
			   
			}
		return rowsUpdated;
		
			
	}
	}

		
	
	
	
	
	
	
	
	

