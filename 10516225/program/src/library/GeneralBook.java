package library;

import java.sql.*;

import javax.swing.*;

public class GeneralBook extends Book{
	
	
	public int  gnrlBookId,shelfNo;
	public String gnrlBookName;
	
	
	//inserting record to database
	//overloading method from book class
	public void addBook(int genrlBkId,int bkId,int shelf_id,String gnrlBkName)
	{
		
		String gnBkQuery = "insert into generalbook( general_bk_id,book_id,genaral_bk_name,shelf_id)"+"values"+"('"+genrlBkId+"','"+bkId+"','"+gnrlBkName+"','"+shelf_id+"')" ;
		 try {
			pst = connection.createStatement();
			int rws = pst.executeUpdate(gnBkQuery);
			
			if(rws > 0)
			{
				JOptionPane.showMessageDialog(null, "data regarding general books are added");
				
			}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		     }
	}
	
	//load data to the table
	//overriding the viewBookDetails() in book class
	public void viewBookDetails()
	 {
		 
		String sql = "select * from generalbook";
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
	
	//to assign table values into textboxes
	
	public void assignValues(int name)
	{
		String assignQuery = "select general_bk_id,genaral_bk_name from generalbook where general_bk_id = '"+name+"'";
		try {
		PreparedStatement ps = connection.prepareStatement(assignQuery);
		rs = ps.executeQuery();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//deleting records
	//overloading method in book class
	public void deleteBook(int bNum)
	{
	String delSql = " delete from generalbook where general_bk_id = '" +bNum+ "'";
	try
	{
		JOptionPane.showMessageDialog(null, delSql);	
		 pst = connection.createStatement();
		int n4 = pst.executeUpdate(delSql);
		
		if( n4 > 0)
		{
		JOptionPane.showMessageDialog(null, "we delete the book from the database");	
		}
		
	}
	catch(Exception ex)
	{
	JOptionPane.showMessageDialog(null, "we coudnt delete the record");	
		
	}
	}
	
	//edit data
	//overloading method in book class
	public int updateRecords(int gnBkId,String gnBkNme,int shelfId)
	{
		String editMngSql = " update generalbook set general_bk_id ='"+gnBkId+"',genaral_bk_name ='"+gnBkNme+"',shelf_id ='"+shelfId+"' where general_bk_id = '"+gnBkId+"'";
		
		try
		{
			pst = connection.createStatement();
			int num = pst.executeUpdate(editMngSql);
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
		
		return 1;
	}
	
	

}
