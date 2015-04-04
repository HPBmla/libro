package library;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.ResultSet;

import java.sql.*;

import javax.swing.*;
public class Librarian extends DbCon implements Person{
	
	public String fname,lname,address,username,dob;
	public int SSN;
	private String password;
	ResultSet rs ;
	
	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public  void log(String user,String pass)
	{
		
		String logQuery = "select username,password from librarian where username = '" + user +"' and  password ='" +pass+ "'";
		try
		{
			
			Statement st = connection.createStatement();
			java.sql.ResultSet rows = st.executeQuery(logQuery);
				
				//declaring a count and check whether how many rows are emerged from the query
				int count = 0;
				
				while(rows.next())
				{
					count = count + 1;
					
					
				}
				
				if(count == 1)
				{
					JOptionPane.showMessageDialog(null, "User found,Access granted");
					
				}
				else if(count > 0)
				{
					JOptionPane.showMessageDialog(null, "Duplicate user,Access denied");
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "User not found!!,check the user name or password");
				}
			
		}
		catch(Exception ex)
		{
			
			JOptionPane.showMessageDialog(null,"check the connection" );
			
		}
		
		
		
		
	}

	
	
	
	public void searchBook(String search)
	{
	
		String searchQuery = " select * from book where b_title = ? ";
		//String searchQuery = " select b_id,b_title,auth_fname,auth_lname,cost,publisher from book where "+search+ "= ? ";
		try {
			PreparedStatement pst = connection.prepareStatement(searchQuery);
			
			pst.setString(1, search);
			
			 rs = (ResultSet) pst.executeQuery();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected void viewMemberDetails()
	 {
		 
		String sql = " select * from member ";
		try
		{
			//Statement st = connection.createStatement();
			PreparedStatement pst = connection.prepareStatement(sql);
			 rs = (ResultSet) pst.executeQuery();
			
			
			
				
			
			
		}
		catch(Exception ex)
		{
			
			JOptionPane.showMessageDialog(null,"check the query");
		}
		 
	 }
	
	
	
	
		
	
		
		
//edit data

	protected void editMembrs(String fname, String lname, int age,String address1,String address2)
	{
		String editMmbrSql = " update member set member_fname ='"+fname+"',member_lname ='"+lname+"',age ='"+age+
				"',add1 = '"+address1+"',add2 = '"+address2+"' where member_fname = '"+fname+"'";
		
		try
		{
		Statement	pst = connection.createStatement();
			int num = pst.executeUpdate(editMmbrSql);
			if(num > 0)
			{
				JOptionPane.showMessageDialog(null, "records were edited");
			}
			else
				JOptionPane.showMessageDialog(null, "coudnt edit the records");
			
			
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "we couldnt edit the details");
		}
		
		
	}
	
	protected int deleteProfileDetails(String mem_fnme)
	{
		
		String profSql = " delete from member where member_fname = '"+mem_fnme+"'";
		try
		{
		Statement	 pst = connection.createStatement();
			int n3 = pst.executeUpdate(profSql);
			
			if( n3 > 0)
			{
			JOptionPane.showMessageDialog(null, "we delete the profile from the database");	
			}
			
		}
		catch(Exception ex)
		{
		JOptionPane.showMessageDialog(null, " we coudnt delete the record ");	
			
		}
		return 1;
	}
	
	public String returnQuery(int bId)
	{
		String query = " select * from book where b_id = '" +bId+ "'";
		return query;
	}
	 public String concatenateName(String fname,String lname)
	 {
		 return fname + lname;
	 }
	 
	 public int signUp(String fnme,String lnme,String add1,String add2,String add3,String tel,String nic,String user,String passwrd)
	 {

			
			
			String addSign = " insert into librarian (fname,lname,address_line1,address_line2,address_line3,tel_no,NIC,username,password) "+ 
			"values "+ "('"+ fnme+"','"+lnme+"','"+add1+"','"+add2+"','"+add3+"','"+tel+"','"+nic+"','"+user+"','"+passwrd+"')";
			
			
			try {
				
		
				Statement pst = connection.createStatement();

				int st = pst.executeUpdate(addSign);
		      
				
				if(st > 0)
				{
					JOptionPane.showMessageDialog(null, "records inserted");
				}
				else
					JOptionPane.showMessageDialog(null, "coudnt");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getMessage();
				
			}
			
		 
		return 1;
		 
	 }
	
	
}
	


