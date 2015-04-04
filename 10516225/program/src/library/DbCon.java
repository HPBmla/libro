package library;
import java.sql.*;

import javax.swing.*;
public class DbCon {
	
	



	 
		public  Connection connection = null;
	
		 
		
		public static String driver = "com.mysql.jdbc.Driver";
		public static  String url = "jdbc:mysql://localhost:3306/library";
		
		//db details
		public static String username = "root";
		
	     protected static  String password = "";
	     
	     //constructor
	     public DbCon()
		 {
			 connection = DbCon.dbConnector();
			
		 }
		
		public static Connection dbConnector()
		{
			Connection con = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		//	JOptionPane.showMessageDialog(null, "connection successfull");
			
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
				
			}
			
			return con;
		}

		

	}


