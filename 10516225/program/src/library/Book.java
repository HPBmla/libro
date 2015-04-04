package library;

import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.sql.*;

import javax.swing.*;

public class Book extends DbCon {
	
	//declaring variables
	
		public int b_id,t_id,cost;
		public String b_title,auth_fname,auth_lname,publisher;
		//public Date date;
		Statement pst = null;
		ResultSet rs = null;
		
		public  void  addBook(int bID,String bName,String aFname,String aLname,int bCst,String pub,int tId )
		{
			
			
			String addSql = " insert into book (b_id,b_title,auth_fname,auth_lname,cost,publisher,type_id) "+ 
			"values "+ "('"+ bID+"','"+bName+"','"+aFname+"','"+aLname+"','"+bCst+"','"+pub+"','"+tId+"')";
			
			
			try {
				
		 pst = connection.createStatement();
         int st = pst.executeUpdate(addSql);
		      
         if(st > 0)
         {
					JOptionPane.showMessageDialog(null, "records inserted");
		 }
				else
					JOptionPane.showMessageDialog(null, "coudnt");
				
				
			} catch (SQLException e) {
				
				e.getMessage();
				
			}
			
		}
		
		protected void viewBookDetails()
		{
			String sql = "select * from book";
			try
			{
				//Statement st = connection.createStatement();
				PreparedStatement pst = connection.prepareStatement(sql);
				 rs = pst.executeQuery();
				
			}
			catch(Exception ex)
			{
				
				JOptionPane.showMessageDialog(null,"check the query");
			}
			
			
		}
		
		//updating fields
		
		protected int updateRecords(int Id, String name,String fName,String lName, int cost, String publisher,int typeId)
		{
			
			String upQuery = "update book set b_id = '"+Id+"',b_title ='" +name+"',auth_fname = '"+fName+"',auth_lname ='"
			+lName+"',cost = '"+cost+"',publisher = '"+publisher+"' where b_id ='"+Id+"'";
			
			try
			{
				 pst = connection.createStatement();
				int n2 = pst.executeUpdate(upQuery);
				if( n2 > 0)
				{
					JOptionPane.showMessageDialog(null, "Updated the query");
				}
				
					
				
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "couldnt update");
			}
			
			return 1;
			
		}
		
		//deleting records from the database
		
		protected void deleteBook(int bNumber)
		{
			
			String delSql = "delete from book where b_id = '"+bNumber+"'";
			try
			{
				 pst = connection.createStatement();
				int n3 = pst.executeUpdate(delSql);
				
				if( n3 > 0)
				{
				JOptionPane.showMessageDialog(null, "we delete the book from the database");	
				}
				
			}
			catch(Exception ex)
			{
			JOptionPane.showMessageDialog(null, "we coudnt delete the record");	
				
			}
		}
		
		
		
			
			
		}


