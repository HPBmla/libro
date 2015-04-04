package library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JDesktopPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class Member extends JFrame{

	private JPanel contentPane;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtAdd1;
	private JTextField txtAdd2;
	private JTable tblMembr;
	private JTextField txtAge;
	private JTextField txtPath;
	private JFileChooser fileChooser;
	private JButton btnChoose,btnAddMemb;
	private JTable tblViewProfile;
	private JTextField txtViewFnme;
	private JTextField txtViewLnme;
	private JTextField txtViewAdd1;
	private JTextField txtViewAdd2;
	private JTextField txtViewAge;
	private ImageIcon format = null;

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
		 catch(Exception e)
		 {
			 JOptionPane.showMessageDialog(null, "Nimbus cant be found");
		 }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Member frame = new Member();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Member() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\java\\libroIcon.png"));
		setTitle("Registration of members");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1205, 788);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(124, 74, 1135, 618);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("Add Member", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblFname = new JLabel("First Name");
		lblFname.setBounds(120, 78, 71, 14);
		panel.add(lblFname);
		
		JLabel lblLname = new JLabel("Last Name");
		lblLname.setBounds(120, 126, 71, 14);
		panel.add(lblLname);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(120, 172, 71, 14);
		panel.add(lblAddress);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setBounds(120, 314, 46, 14);
		panel.add(lblImage);
		
		txtFname = new JTextField();
		txtFname.setBounds(281, 75, 141, 23);
		panel.add(txtFname);
		txtFname.setColumns(10);
		
		txtLname = new JTextField();
		txtLname.setBounds(281, 123, 141, 23);
		panel.add(txtLname);
		txtLname.setColumns(10);
		
		txtAdd1 = new JTextField();
		txtAdd1.setBounds(281, 169, 141, 23);
		panel.add(txtAdd1);
		txtAdd1.setColumns(10);
		
		txtAdd2 = new JTextField();
		txtAdd2.setBounds(281, 209, 141, 23);
		panel.add(txtAdd2);
		txtAdd2.setColumns(10);
		
		JButton btnChoose = new JButton("Choose Image");
		btnChoose.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\imgSearch.png"));
		btnChoose.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				fileChooser = new JFileChooser("C:\\",FileSystemView.getFileSystemView());
				 fileChooser.setFileFilter(new FileNameExtensionFilter("image files", "jpg","png"));
				 int returnVal = fileChooser.showOpenDialog(contentPane);
				 if(returnVal == JFileChooser.APPROVE_OPTION){
					 String filename = fileChooser.getSelectedFile().getName();
					 String extension = filename.substring(filename.lastIndexOf("."));
					 if(extension.equalsIgnoreCase(".jpg")||extension.equalsIgnoreCase(".png"))
					 {
						 txtPath.setText(fileChooser.getSelectedFile().getPath());
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(null, "kindly select the required file only");
					 }
				 }
				 else
				 {
					 txtPath.setText("no files selected");
				 }
				
			}
		});
		
		btnChoose.setBounds(268, 352, 154, 33);
		panel.add(btnChoose);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(414, 398, 23, -24);
		panel.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(450, 63, 592, 268);
		panel.add(scrollPane);
		
		tblMembr = new JTable();
		tblMembr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
	
			
				try
				{
				int line = tblMembr.getSelectedRow();
				String fname = ( tblMembr.getModel().getValueAt(line, 1)).toString();
				
				String assignQuery = " select member_fname,member_lname,age,add1,add2 from member where member_fname = '"+fname+"'";
				
				DbCon c = new DbCon();
		        java.sql.Connection	dbcn = c.connection;
				PreparedStatement pst = (PreparedStatement) dbcn.prepareStatement(assignQuery);
				ResultSet rs = (ResultSet) pst.executeQuery();
				
						while(rs.next())
						{
							txtFname.setText(rs.getString("member_fname"));
							
							txtLname.setText(rs.getString("member_lname"));
							txtAge.setText(rs.getString("age"));
							txtAdd1.setText(rs.getString("add1"));
							txtAdd2.setText(rs.getString("add2"));
							
						}
					
				pst.close();
				
				
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "coudnt assign values to text boxes");
				}
				
				
			}
		});
		scrollPane.setViewportView(tblMembr);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(120, 260, 46, 14);
		panel.add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setBounds(281, 257, 141, 23);
		panel.add(txtAge);
		txtAge.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(498, 335, -33, 141);
		panel.add(panel_5);
		
		txtPath = new JTextField();
		txtPath.setText(" no file uploaded");
		txtPath.setBounds(281, 311, 139, 23);
		panel.add(txtPath);
		txtPath.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 245, 245));
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(92, 63, 348, 333);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(62, 51, 999, 451);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnView = new JButton("Load");
		btnView.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\load.png"));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Librarian gb1 = new Librarian();
				gb1.viewMemberDetails();
				tblMembr.setModel(DbUtils.resultSetToTableModel(gb1.rs));
			}
		});
		btnView.setBounds(273, 387, 89, 40);
		panel_4.add(btnView);
		
		JButton btnAddMemb_1 = new JButton("Add");
		btnAddMemb_1.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\add.png"));
		btnAddMemb_1.setBounds(42, 387, 89, 40);
		panel_4.add(btnAddMemb_1);
		//saveImage(txtPath.getText());
		
		
		JButton BtnClrTxt = new JButton("Clear");
		BtnClrTxt.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\clear.png"));
		BtnClrTxt.setBounds(153, 387, 100, 40);
		panel_4.add(BtnClrTxt);
		
		//clearing textboxes
		BtnClrTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtFname.setText("");
				txtLname.setText("");
				txtAge.setText("");
				txtAdd1.setText("");
				txtAdd2.setText("");
			}
		});
		
		
		//adding records to database
	btnAddMemb_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			/*	String name1 = txtFname.getText();
				
				String name2 = txtLname.getText();
				String age = txtAge.getText();
				String add1 = txtAdd1.getText();
				String add2 = txtAdd2.getText();
				if(name1.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter member's first name");
				}
				else if(name2.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter member's last name");
				}
				else if(age.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter age");
				}
				else if(add1.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter member's address");
				}
				else
				{
				
				
				int membAge = 0;
				if(!age.isEmpty())
				{
					membAge = Integer.parseInt(age);
				}
				Librarian obj = new Librarian();
			obj.register(name1, name2, membAge, add1, add2);
				
			}*/
				 byte[] rawBytes = null;
				  FileInputStream fis = null;
				  String imgPath = txtPath.getText();
				  
				  if(imgPath.equals("no file uploaded"))
				  {
					  ClassLoader clss = this.getClass().getClassLoader();
					  URL resources = clss.getResource("default.png");
					  imgPath = resources.getFile();
				  }
				  
				  File fileobj = new File(imgPath);
				  try {
					fis = new FileInputStream(fileobj);
					String fname = txtFname.getText();
					String lname = txtLname.getText();
					String mAge = txtAge.getText();
					String memAddr1 = txtAdd1.getText();
					String memAddr2 = txtAdd2.getText();
					int age = 0;
					if(!mAge.isEmpty())
					{
						age = Integer.parseInt(mAge);
					}
					
					DbCon cn = new DbCon();
					 java.sql.Connection	dbcn = cn.connection;
					 String query = "insert into member (member_fname,member_lname,age,add1,add2,image) values(?,?,?,?,?,?)";
						try {
							PreparedStatement pst = (PreparedStatement) dbcn.prepareStatement(query);
							pst.setString(1, fname);
							
							pst.setString(2, lname);
							pst.setLong(3, age);
							pst.setString(4, memAddr1);
							pst.setString(5, memAddr2);
							int imgLength = Integer.parseInt(String.valueOf(fileobj.length()));
							rawBytes = new byte[imgLength];
							try {
								fis.read(rawBytes,0,imgLength);
								pst.setBytes(6, rawBytes);
								int count = pst.executeUpdate();
								if(count > 0)
								{
									JOptionPane.showMessageDialog(null, "data added successfully");
								}
								else
								{
									JOptionPane.showMessageDialog(null, "data coudnt be added");
								}
							} catch (IOException ex) {
								// TODO Auto-generated catch block
								ex.printStackTrace();
							}
							
						} catch (SQLException ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
					
					
				} catch (FileNotFoundException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.controlHighlight);
		tabbedPane.addTab("View Profile", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBounds(60, 47, 455, 447);
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblViewFnme = new JLabel("First Name");
		lblViewFnme.setBounds(27, 45, 95, 14);
		panel_7.add(lblViewFnme);
		
		JLabel lblViewLnme = new JLabel("Last Name");
		lblViewLnme.setBounds(27, 89, 95, 14);
		panel_7.add(lblViewLnme);
		
		JLabel lblViewAdd = new JLabel("Address");
		lblViewAdd.setBounds(27, 140, 95, 14);
		panel_7.add(lblViewAdd);
		
		JLabel lblViewAge = new JLabel("Age");
		lblViewAge.setBounds(27, 216, 46, 14);
		panel_7.add(lblViewAge);
		
		JLabel lblViewProf = new JLabel("Profile Picture");
		lblViewProf.setBounds(27, 284, 106, 14);
		panel_7.add(lblViewProf);
		
		txtViewFnme = new JTextField();
		txtViewFnme.setBounds(203, 42, 123, 23);
		panel_7.add(txtViewFnme);
		txtViewFnme.setColumns(10);
		
		txtViewLnme = new JTextField();
		txtViewLnme.setColumns(10);
		txtViewLnme.setBounds(203, 86, 123, 23);
		panel_7.add(txtViewLnme);
		
		txtViewAdd1 = new JTextField();
		txtViewAdd1.setColumns(10);
		txtViewAdd1.setBounds(203, 137, 123, 23);
		panel_7.add(txtViewAdd1);
		
		txtViewAdd2 = new JTextField();
		txtViewAdd2.setColumns(10);
		txtViewAdd2.setBounds(203, 179, 123, 23);
		panel_7.add(txtViewAdd2);
		
		txtViewAge = new JTextField();
		txtViewAge.setColumns(10);
		txtViewAge.setBounds(203, 213, 123, 23);
		panel_7.add(txtViewAge);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(203, 284, 123, 138);
		panel_7.add(desktopPane);
		
		final JLabel lblViewImg = new JLabel("");
		lblViewImg.setBounds(10, 11, 103, 116);
		desktopPane.add(lblViewImg);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(542, 58, 470, 185);
		panel_1.add(scrollPane_1);
		
		tblViewProfile = new JTable();
		
		
		//to display data and image when clicked
		tblViewProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			
					int line = tblViewProfile.getSelectedRow();
					String fname = ( tblViewProfile.getModel().getValueAt(line, 1)).toString();
					try
					{
					String sql = "select image from member where member_fname = '"+fname+"'";
					DbCon c = new DbCon();
					Connection	db = (Connection) c.connection;
					PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
					ResultSet rs = (ResultSet) pst.executeQuery();
					if(rs.next())
					{
						byte [] imageData = rs.getBytes("image");
						format = new ImageIcon(imageData);
						lblViewImg.setIcon(format);
					}
					
				    }
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "cant display the image");
				}

					try
					{
					int line1 = tblViewProfile.getSelectedRow();
					String fname1 = ( tblViewProfile.getModel().getValueAt(line1, 1)).toString();
					
					String assignQuery = " select member_fname,member_lname,age,add1,add2 from member where member_fname = '"+fname1+"'";
					//JOptionPane.showMessageDialog(null, assignQuery);
					
					DbCon c2 = new DbCon();
			        java.sql.Connection	dbcn2 = c2.connection;
			       // JOptionPane.showMessageDialog(null, "connection");
					PreparedStatement pst2 = (PreparedStatement) dbcn2.prepareStatement(assignQuery);
				//	JOptionPane.showMessageDialog(null, "pst");
					
					ResultSet rs2 = (ResultSet) pst2.executeQuery();
					//JOptionPane.showMessageDialog(null, "rs");
					
							while(rs2.next())
							{
								txtViewFnme.setText(rs2.getString("member_fname"));
								
								txtViewLnme.setText(rs2.getString("member_lname"));
								txtViewAge.setText(rs2.getString("age"));
								txtViewAdd1.setText(rs2.getString("add1"));
								txtViewAdd2.setText(rs2.getString("add2"));
							//	lblViewImg.setText(rs1.getString("image"));
								
							}
						
					pst2.close();
					
					
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "coudnt assign values to text boxes");
					}
				
				
				
				
			}
		});
		scrollPane_1.setViewportView(tblViewProfile);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_6.setBackground(new Color(192, 192, 192));
		panel_6.setBounds(32, 25, 1017, 542);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnViewProfle = new JButton("Load");
		btnViewProfle.setBounds(34, 480, 83, 37);
		panel_6.add(btnViewProfle);
		btnViewProfle.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\load.png"));
		
		JButton btnViewProfEdit = new JButton("Edit");
		btnViewProfEdit.setBounds(146, 480, 83, 37);
		panel_6.add(btnViewProfEdit);
		btnViewProfEdit.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\edit.png"));
		
		JButton btnViewProfleDel = new JButton("Delete");
		btnViewProfleDel.setBounds(253, 480, 95, 37);
		panel_6.add(btnViewProfleDel);
		btnViewProfleDel.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\delete.png"));
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\logout.png"));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Log lgout = new Log();
		int dialogBox  = JOptionPane.showConfirmDialog(null, " do you want to logout? ");
		if(dialogBox == JOptionPane.YES_OPTION)
		{
				lgout.frmLogin.setVisible(true);
		}
				
			}
		});
		btnLogOut.setBounds(367, 478, 105, 40);
		panel_6.add(btnLogOut);
		//delete profiles
		btnViewProfleDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fnme = txtViewFnme.getText();
				int dialogBox = JOptionPane.showConfirmDialog(null, "do you want to delete?");
				if(dialogBox == JOptionPane.YES_OPTION)
				{
				Librarian delprof = new Librarian();
				delprof.deleteProfileDetails(fnme);
				}
				
			}
		});
		//edit data in the textboxes
		btnViewProfEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fname = txtViewFnme.getText();
				String lname = txtViewLnme.getText();
				String mAge = txtViewAge.getText();
				String memAddr1 = txtViewAdd1.getText();
				String memAddr2 = txtViewAdd2.getText();
				
				int age = 0;
				if(!mAge.isEmpty())
				{
					age = Integer.parseInt(mAge);
				}
				int dialogBox = JOptionPane.showConfirmDialog(null, "do you want to edit the record?");
				if(dialogBox == JOptionPane.YES_OPTION)
				{
				Librarian lib = new Librarian();
				lib.editMembrs(fname, lname, age, memAddr1, memAddr2);
				}
				
			}
		});
		btnViewProfle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Librarian gb1 = new Librarian();
				gb1.viewMemberDetails();
				tblViewProfile.setModel(DbUtils.resultSetToTableModel(gb1.rs));
				
			}
		});
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBackground(new Color(245, 245, 245));
		panel_8.setBounds(96, 42, 1190, 694);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblRegistrationOfLibrary = new JLabel("Registration of Library Members");
		lblRegistrationOfLibrary.setBounds(454, 24, 434, 24);
		panel_8.add(lblRegistrationOfLibrary);
		lblRegistrationOfLibrary.setFont(new Font("Vani", Font.PLAIN, 18));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAction obj = new BookAction();
				obj.setVisible(true);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\backButton.png"));
		btnNewButton.setBounds(1207, 0, 52, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				General obj = new General();
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\Forward.png"));
		btnNewButton_1.setBounds(1260, 0, 52, 35);
		contentPane.add(btnNewButton_1);
		
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
	
	
	
	
	/*public void actionPerformed(ActionEvent e)
	{
		JButton btn = (JButton)e.getSource();
		
		if(btn.equals(btnChoose))
		{
			
			
	}
		else if(btn.equals(btnAddMemb))
		{
			saveImage(txtPath.getText());
		}
	}*/
}
