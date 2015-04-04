package library;
import java.sql.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import com.mysql.jdbc.ResultSet;

import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.border.MatteBorder;

public class General extends JFrame {

	private JPanel contentPane;
	private JTextField txtGnBkId;
	private JTextField txtGnBkNme;
	private JTextField txtMngGnrBkId;
	private JTextField txtMngGnrBkNme;
	private JTable tbleMngGnrlBk;
	private JComboBox cmbMngBId;
	private JComboBox cmbBkId;
	private JSpinner spnGnrl;

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
			 JOptionPane.showMessageDialog(null, "cant ");
		 }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					General frame = new General();
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
	
	public General() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\java\\libroIcon.png"));
		setTitle("General Book Registration");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 873, 747);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(307, 170, 724, 417);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(220, 220, 220));
		tabbedPane.addTab("Add General Books", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblShlfId = new JLabel("Shelf ID");
		lblShlfId.setBounds(33, 159, 46, 14);
		panel.add(lblShlfId);
		JButton btnGnAdd = new JButton("Add Book");
		btnGnAdd.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\add.png"));
		
		//adding general books
		btnGnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID = 0;
				String id = txtGnBkId.getText();
				if(!id.isEmpty())
				{
					 ID = Integer.parseInt(id);
					//JOptionPane.showMessageDialog(id, "enter the id", "Warning", ERROR);
					
					
				}
				else
					JOptionPane.showMessageDialog(null, "enter the Id of general book");
				
				int bkId = 0;
				
				String bID = cmbBkId.getSelectedItem().toString();
				
				if(!bID.isEmpty())
				{
					bkId = Integer.parseInt(bID);
				}
				

    
				String name = txtGnBkNme.getText();
				if(name.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter the book name");
				}
				
				int shelf = (int)spnGnrl.getValue();
				GeneralBook g1 = new GeneralBook();
				g1.addBook(ID, bkId, shelf, name);
				
				
			}
		});
		btnGnAdd.setBounds(33, 196, 115, 36);
		panel.add(btnGnAdd);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, UIManager.getColor("MenuBar.shadow"), null, null));
		panel_2.setBackground(new Color(245, 245, 245));
		panel_2.setBounds(10, 23, 398, 234);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblGnrlBkName = new JLabel("Book Name");
		lblGnrlBkName.setBounds(23, 102, 105, 14);
		panel_2.add(lblGnrlBkName);
		
		JLabel lblBkclssBkId = new JLabel("Book ID");
		lblBkclssBkId.setBounds(23, 63, 46, 14);
		panel_2.add(lblBkclssBkId);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\logout.png"));
		//logout action listener
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Log out = new Log();
			int dialogBox =	JOptionPane.showConfirmDialog(null, " do you want to logout? ");
			if(dialogBox == JOptionPane.YES_OPTION)
			{
				out.frmLogin.setVisible(true);
			}
				
			}
		});
		btnLogOut.setBounds(283, 173, 105, 35);
		panel_2.add(btnLogOut);
		
		JButton btnGnrlClear = new JButton("Clear");
		btnGnrlClear.setBounds(157, 173, 105, 36);
		panel_2.add(btnGnrlClear);
		btnGnrlClear.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\clear.png"));
		
		txtGnBkNme = new JTextField();
		txtGnBkNme.setBounds(157, 98, 93, 24);
		panel_2.add(txtGnBkNme);
		txtGnBkNme.setColumns(10);
		
		final JComboBox cmbBkId = new JComboBox();
		cmbBkId.setBounds(157, 60, 93, 24);
		panel_2.add(cmbBkId);
		cmbBkId.setModel(new DefaultComboBoxModel(new String[] {"10000", "10001", "10002", "10003", "10004", "10005", "10006", "10007", "10008", "10009", "10010", "10011", "10012", "10013", "10014", "10015", "10016", "10017", "10018", "10019", "10020"}));
		
		JLabel lblGenBkId = new JLabel("General Book Id");
		lblGenBkId.setBounds(23, 25, 105, 14);
		panel_2.add(lblGenBkId);
		
		txtGnBkId = new JTextField();
		txtGnBkId.setBounds(157, 20, 93, 25);
		panel_2.add(txtGnBkId);
		txtGnBkId.setColumns(10);
		
		final JSpinner spnGnrl = new JSpinner();
		spnGnrl.setBounds(157, 131, 93, 24);
		panel_2.add(spnGnrl);
		
		//event handler to clear textboxes
		btnGnrlClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtGnBkId.setText("");
				txtGnBkNme.setText("");
				
			}
		});
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabbedPane.addTab("Manage Genaral Books", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblMngGnBkId = new JLabel("General Book Id");
		lblMngGnBkId.setBounds(39, 65, 105, 14);
		panel_1.add(lblMngGnBkId);
		
		JLabel lblMngBkName = new JLabel("Book Name");
		lblMngBkName.setBounds(39, 128, 89, 14);
		panel_1.add(lblMngBkName);
		
		JLabel lblMngShlf = new JLabel("Shelf ID");
		lblMngShlf.setBounds(39, 164, 46, 14);
		panel_1.add(lblMngShlf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(307, 46, 391, 181);
		panel_1.add(scrollPane);
		
		tbleMngGnrlBk = new JTable();
		
		//to assign table values to textfields
		
	tbleMngGnrlBk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
				int line = tbleMngGnrlBk.getSelectedRow();
				String gnMngBkNme = (tbleMngGnrlBk.getModel().getValueAt(line, 2)).toString();
				
				String assignQuery = "select general_bk_id,genaral_bk_name from generalbook where genaral_bk_name = '"+gnMngBkNme+"'";
				
				DbCon c = new DbCon();
		        Connection	dbcn = c.connection;
				PreparedStatement pst = dbcn.prepareStatement(assignQuery);
				ResultSet rs = (ResultSet) pst.executeQuery();
		
						while(rs.next())
						{
							txtMngGnrBkId.setText(rs.getString("general_bk_id"));
							
							txtMngGnrBkNme.setText(rs.getString("genaral_bk_name"));
							//((JLabel) cmbBkId).setText(gb3.rs.getString("book_id"));
						}
					
				
				
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "coudnt assign values to text boxes");
				}
			} 
		});
		scrollPane.setViewportView(tbleMngGnrlBk);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 245, 245));
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 23, 699, 305);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		txtMngGnrBkId = new JTextField();
		txtMngGnrBkId.setBounds(159, 39, 93, 25);
		panel_3.add(txtMngGnrBkId);
		txtMngGnrBkId.setColumns(10);
		
		 JComboBox cmbMngBId = new JComboBox();
		cmbMngBId.setBounds(159, 70, 93, 25);
		panel_3.add(cmbMngBId);
		cmbMngBId.setModel(new DefaultComboBoxModel(new String[] {"10000", "10001", "10002", "10003", "10004", "10005", "10006", "10007", "10008", "10009", "10010", "10011", "10012", "10013", "10014", "10015", "10016", "10017", "10018", "10019", "10020"}));
		
		
		
		txtMngGnrBkNme = new JTextField();
		txtMngGnrBkNme.setBounds(159, 101, 93, 25);
		panel_3.add(txtMngGnrBkNme);
		txtMngGnrBkNme.setColumns(10);
		
		JSpinner spnShlfId = new JSpinner();
		spnShlfId.setBounds(159, 132, 93, 24);
		panel_3.add(spnShlfId);
		
		JButton btnMngDelete = new JButton("Delete");
		btnMngDelete.setBounds(106, 225, 93, 33);
		panel_3.add(btnMngDelete);
		btnMngDelete.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\delete.png"));
		
		JButton btnMngLoad = new JButton("Load");
		btnMngLoad.setBounds(204, 225, 89, 33);
		panel_3.add(btnMngLoad);
		btnMngLoad.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\load.png"));
		
		JLabel lblMngBkId = new JLabel("Book ID");
		lblMngBkId.setBounds(28, 75, 46, 14);
		panel_3.add(lblMngBkId);
		
		JButton btnMngAdd = new JButton("Edit");
		btnMngAdd.setBounds(10, 225, 89, 33);
		panel_3.add(btnMngAdd);
		btnMngAdd.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\edit.png"));
		
		
		//edit records
		btnMngAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int gnMngBkId =0;
				String gnId = txtMngGnrBkId.getText();
				if(!gnId.isEmpty())
				{
					gnMngBkId = Integer.parseInt(gnId);
					
				}
				
				String gnName = txtMngGnrBkNme.getText();
				
				
				int number = 0;
				
		
       /* String bkIds = cmbMngBId.getSelectedItem().toString();
		
		if(!bkIds.isEmpty())
		{
			number = Integer.parseInt(bkIds);
			
		}*/
	     int shelfNum =(Integer)(spnGnrl.getValue()) ;
	     //JOptionPane.showMessageDialog(null, shelfNum);
	       
	     int dialogBox = JOptionPane.showConfirmDialog(null, "do you want to edit the record?");
	     if(dialogBox == JOptionPane.YES_OPTION)
	     {
				
				GeneralBook gnrl = new GeneralBook();
				
				gnrl.updateRecords(gnMngBkId, gnName, shelfNum);
				
				
	     }	
				
			}
		});
		btnMngLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GeneralBook gb1 = new GeneralBook();
				gb1.viewBookDetails();
				tbleMngGnrlBk.setModel(DbUtils.resultSetToTableModel(gb1.rs));
				
				
			}
		});
		
		//deleting records
		btnMngDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String value = txtMngGnrBkId.getText();
				int genrlBk = 0;
				
				if(!value.isEmpty())
				{
				genrlBk = Integer.parseInt(value);	
				}
				int dialogBox = JOptionPane.showConfirmDialog(null, "do you want to delete?");
				if(dialogBox == JOptionPane.YES_OPTION)
				{
					
				
				GeneralBook gb5 = new GeneralBook();
				gb5.deleteBook(genrlBk);
				
				}
			}
		});
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 245, 245));
		panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_4.setBounds(279, 138, 845, 481);
		contentPane.add(panel_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAction obj = new BookAction();
				obj.setVisible(true);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\backButton.png"));
		btnNewButton.setBounds(1208, 0, 52, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reference obj = new Reference();
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
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(212, 45, 985, 637);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("General Book Registration");
		lblNewLabel.setBounds(323, 32, 337, 25);
		panel_5.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Vani", Font.PLAIN, 18));
	}
}
