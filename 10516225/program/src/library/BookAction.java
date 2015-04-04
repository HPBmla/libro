package library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import javax.swing.JFormattedTextField.AbstractFormatter;

import com.mysql.jdbc.Connection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;

public class BookAction extends JFrame {

	private JPanel contentPane;
	private JTextField txtBkTtle;
	private JTextField txtAFname;
	private JTextField txtALname;
	private JTextField txtPub;
	private JTable table;
	private JTextField txtCst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                   UIManager.put("nimbusBase", new Color(146,151,161));
	                 //  UIManager.put("nimbusBlueGray", new Color(205,208,213));
	                 //  UIManager.put("control", new Color(146,151,161));
	                    
	                    break;
	                }
	            }
	        }
		 catch(Exception ex)
		 {
			 JOptionPane.showMessageDialog(null, "Nimbus cant be found");
		 }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAction frame = new BookAction();
					frame.setVisible(true);
					//dbCon c = new dbCon();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection connection = null;
private JTextField txtBId;
private JTextField txtSearch;

	/**
	 * Create the frame.
	 */

public void refreshTable()
{
	
	Book bk = new Book();
	bk.viewBookDetails();
	table.setModel(DbUtils.resultSetToTableModel(bk.rs));
	
	
}
	public BookAction() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\java\\libroIcon.png"));
		setTitle("Book Registration");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1151, 788);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBkTitle = new JLabel("Book Title");
		lblBkTitle.setBounds(200, 88, 64, 14);
		contentPane.add(lblBkTitle);
		
		JLabel lblAthFname = new JLabel("Author First Name");
		lblAthFname.setBounds(200, 132, 105, 14);
		contentPane.add(lblAthFname);
		
		JLabel lblAthLname = new JLabel("Author Last Name");
		lblAthLname.setBounds(200, 173, 110, 14);
		contentPane.add(lblAthLname);
		
		JLabel lblCst = new JLabel("Cost");
		lblCst.setBounds(200, 207, 46, 14);
		contentPane.add(lblCst);
		
		JLabel lblPub = new JLabel("Publisher");
		lblPub.setBounds(200, 243, 64, 14);
		contentPane.add(lblPub);
		
		JLabel lblTypeId = new JLabel("Type ID");
		lblTypeId.setBounds(200, 280, 46, 14);
		contentPane.add(lblTypeId);
		
		txtBkTtle = new JTextField();
		txtBkTtle.setColumns(10);
		txtBkTtle.setBounds(320, 85, 124, 24);
		contentPane.add(txtBkTtle);
		
		txtAFname = new JTextField();
		txtAFname.setColumns(10);
		txtAFname.setBounds(320, 129, 124, 24);
		contentPane.add(txtAFname);
		
		txtALname = new JTextField();
		txtALname.setColumns(10);
		txtALname.setBounds(320, 170, 124, 24);
		contentPane.add(txtALname);
		
		txtPub = new JTextField();
		txtPub.setColumns(10);
		txtPub.setBounds(320, 240, 124, 24);
		contentPane.add(txtPub);
		
		final JComboBox cmbyTpe = new JComboBox();
		cmbyTpe.setModel(new DefaultComboBoxModel(new String[] {"100", "200"}));
		cmbyTpe.setBounds(320, 274, 124, 24);
		contentPane.add(cmbyTpe);
		
		txtCst = new JTextField();
		txtCst.setBounds(320, 204, 124, 24);
		contentPane.add(txtCst);
		txtCst.setColumns(10);
		
		txtBId = new JTextField();
		txtBId.setBounds(320, 56, 124, 24);
		contentPane.add(txtBId);
		txtBId.setColumns(10);
		
		JLabel lblBId = new JLabel("Book ID");
		lblBId.setBounds(200, 62, 46, 14);
		contentPane.add(lblBId);
		
		txtSearch = new JTextField();
		
		
		
		//for the search event handler
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				
				String searchType = txtSearch.getText();
				Librarian l2 = new Librarian();
				// String find = txtSearch.getText(); 
				 
				
				
				l2.searchBook(searchType);
				table.setModel(DbUtils.resultSetToTableModel(l2.rs));
				
				
				
			}
		});
		txtSearch.setBounds(550, 62, 164, 24);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\search.png"));
		lblNewLabel.setBounds(730, 56, 40, 32);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(520, 42, 632, 487);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 82, 564, 199);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				try
				{
				int line = table.getSelectedRow();
				String BkNme = ( table.getModel().getValueAt(line, 1)).toString();
				
				String assignQuery = " select b_id,b_title,auth_fname,auth_lname,cost,publisher from book where b_title = '"+BkNme+"'";
				
				DbCon c = new DbCon();
		        java.sql.Connection	dbcn = c.connection;
				PreparedStatement pst = dbcn.prepareStatement(assignQuery);
				ResultSet rs = pst.executeQuery();
				
						while(rs.next())
						{
							txtBId.setText(rs.getString("b_id"));
							
							txtBkTtle.setText(rs.getString("b_title"));
							txtAFname.setText(rs.getString("auth_fname"));
							txtALname.setText(rs.getString("auth_lname"));
							txtCst.setText(rs.getString("cost"));
							txtPub.setText(rs.getString("publisher"));
						}
					
				pst.close();
				
				
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "coudnt assign values to text boxes");
				}
				
				
				
				
				
				
				
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(180, 42, 290, 271);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(new Color(245, 245, 245));
		panel_2.setBounds(200, 330, 164, 370);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAdd = new JButton("Add Book");
		btnAdd.setBounds(10, 12, 138, 32);
		panel_2.add(btnAdd);
		btnAdd.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\add.png"));
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(10, 56, 138, 32);
		panel_2.add(btnClear);
		btnClear.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\clear.png"));
		
		JButton btnUpdate = new JButton("Edit book");
		btnUpdate.setBounds(10, 100, 138, 32);
		panel_2.add(btnUpdate);
		btnUpdate.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\edit.png"));
		
		JButton btnDel = new JButton("Delete Book");
		btnDel.setBounds(10, 144, 138, 32);
		panel_2.add(btnDel);
		btnDel.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\delete.png"));
		
		JButton btnGenrl = new JButton("Genaral Books");
		btnGenrl.setBounds(10, 188, 138, 32);
		panel_2.add(btnGenrl);
		
		JButton btnRefBk = new JButton("Reference Books");
		btnRefBk.setBounds(10, 232, 138, 32);
		panel_2.add(btnRefBk);
		
		JButton btnLoad = new JButton("Load Records");
		btnLoad.setBounds(10, 276, 138, 32);
		panel_2.add(btnLoad);
		btnLoad.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\load.png"));
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\logout.png"));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Log lgout = new Log();
			int dialogBox =	JOptionPane.showConfirmDialog(null, " do you want to logout? ");
			if(dialogBox == JOptionPane.YES_OPTION)
			{
				lgout.frmLogin.setVisible(true);
				
			}	
			}
		});
		btnLogOut.setBounds(10, 320, 138, 32);
		panel_2.add(btnLogOut);
		
		
		//to load the values of the database into table
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Book bk = new Book();
				bk.viewBookDetails();
				table.setModel(DbUtils.resultSetToTableModel(bk.rs));
				refreshTable();
			}
		});
		btnRefBk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Reference r = new Reference();
				r.setVisible(true);
			}
		});
		btnGenrl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				General g = new General();
				g.setVisible(true);
				
			}
		});
		
		//deleteing a book
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String num = txtBId.getText();
				int bookNum = 0;
				
				if(!num.isEmpty())
				{
				bookNum = Integer.parseInt(num);	
				}
				int dialogBox = JOptionPane.showConfirmDialog(null, "do you want to delete?");
				if(dialogBox == JOptionPane.YES_OPTION)
				{
				Book b4 = new Book();
				b4.deleteBook(bookNum);
				
				
				refreshTable();
				}
				}
				
				
			
			
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int bCost = 0;
				int bType = 0;
				int bNum = 0;
				String bkNum = txtBId.getText();
				
				//converting string into int
				if(!bkNum.isEmpty())
				{
					bNum = Integer.parseInt(bkNum);
				}
				
				String bName = txtBkTtle.getText();
				
				String bFname = txtAFname.getText();
				String bLname = txtALname.getText();
				String bPublisher = txtPub.getText();
				String bTypId = cmbyTpe.getSelectedItem().toString();
				String c = txtCst.getText();
				
				if(!c.isEmpty())
				{
					bCost = Integer.parseInt(c);
				}
				
				if(!bTypId.isEmpty())
				{
					bType = Integer.parseInt(bTypId);
				}
				int bkId = 0;
				
				String bookId = txtBId.getText();
				
				if(!bookId.isEmpty())
				{
					bkId = Integer.parseInt(bookId);
					
				}
				int dialogBox = JOptionPane.showConfirmDialog(null, "do you want to edit the record?");
				if(dialogBox == JOptionPane.YES_OPTION)
				{
				Book b2 = new Book();
				b2.updateRecords(bNum,bName, bFname, bLname, bCost, bPublisher, bType);
				
				refreshTable();
				
				}
				
			}
		});
		
		//event handler for clearing textfields
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtBId.setText("");
				txtBkTtle.setText("");
				txtAFname.setText("");
				txtALname.setText("");
				txtCst.setText("");
				txtPub.setText("");
				
				
			}
		});
		
		//event handler to get the values of textfields
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					
					
					
					
					
					int bkId = 0;
					
					String bookId = txtBId.getText();
					String fname = txtAFname.getText();
					String lname = txtALname.getText();
					String publisher = txtPub.getText();
					String name = txtBkTtle.getText();
					int cost = 0;
					String bcst = txtCst.getText();
					if(!bcst.isEmpty())
					{
					
					 cost = Integer.parseInt(bcst);
					}
					if(!bookId.isEmpty())
					{
						bkId = Integer.parseInt(bookId);
						
					}
					int type = 0;
					String tid = cmbyTpe.getSelectedItem().toString();
					
					if(!tid.isEmpty())
					{
					 
						type = Integer.parseInt(tid);
					
					}
					if(bookId.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Enter the book ID");
					}
					
					else if(name.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Enter the book name");
					}
					
					
					else if(fname.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Enter the author's first name");
					}
					
					else if(lname.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Enter the author's last name");
					}
					
					else if(publisher.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Enter the publisher's name");
					}
				 
					/*SimpleDateFormat formatter = new SimpleDateFormat();
				    String dat = chserDate.getDateFormatString();
				    Date pDate = null;
						if(!dat.isEmpty())
						{
							 try {
								pDate = formatter.parse(dat);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}*/
						
					
					else if(bcst.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Enter the price of the book");
					}
					else 
						
					{
						
				
				
					//making an instance of the book class
					Book b1 = new Book();
					
			 b1.addBook(bkId, name, fname, lname, cost, publisher, type);
			 
			 refreshTable();
					
					}
				
				
				
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(new Color(220, 220, 220));
		panel_3.setBounds(140, 11, 1095, 709);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\delete.png"));
		button.setBounds(1312, 0, 52, 35);
		contentPane.add(button);
		
		
		
	
	}
	
}
