package library;

import java.util.Date;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class RefernceBook extends Book  {
	
	public int refBkId;
	public String refBkName,refAuthrLname;
	
	public void saveRefBook(int refBkId,String name,String auth_name)
	{
		

		String saveSql = " insert into referencebook(bk_id,bk_name,author_lname) "+ 
		"values "+ "('"+ refBkId+"','"+name+"','"+auth_name+"')";
		
		
		try {
			
	
			 pst = connection.createStatement();

			int st = pst.executeUpdate(saveSql);
	      
			
			if(st > 0)
			{
				JOptionPane.showMessageDialog(null, "records inserted");
			}
			else
				JOptionPane.showMessageDialog(null, "coudnt insert");
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			
		}
		
	}
	
	public String loading()
	{
	 String query = "select * from referencebook";
	 return query;
		
	}
	

}
