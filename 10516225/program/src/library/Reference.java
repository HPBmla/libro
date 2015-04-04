package library;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import java.awt.CardLayout;

import javax.swing.JDesktopPane;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JList;

import com.mysql.jdbc.ResultSet;

import java.awt.Toolkit;

import javax.swing.SwingConstants;

import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

import java.awt.Font;



public class Reference extends JFrame {

	private JPanel contentPane;
	private JTextField txtRefId;
	private JTextField txtRefNme;
	private JTextField txtRefAth;
    private JList listName;
   // private JDateChooser dateChooser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		 try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    UIManager.put("nimbusBase", new Color(247,248,250));
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reference frame = new Reference();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   DbCon c = new DbCon();
   Connection con = c.connection;
	
	public void loadList()
	{
		
		RefernceBook obj = new RefernceBook();
	String sql =	obj.loading();
	try
	{
	PreparedStatement ps = con.prepareStatement(sql);
	ResultSet rs = (ResultSet) ps.executeQuery();
		DefaultListModel list = new DefaultListModel();
		
		while(rs.next())
		{
			list.addElement(rs.getString("bk_name"));
			
		}
		listName.setModel(list);
		ps.close();
		rs.close();
	}
	catch(Exception ex)
	{
		
	}
	}
	/**
	 * Create the frame.
	 */
	public Reference() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\java\\libroIcon.png"));
		setTitle("Registration of Reference Books");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1100, 720);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("RadioButton.background"));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(337, 179, 721, 342);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\logout.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Log a = new Log();
			int dialogBox =	 JOptionPane.showConfirmDialog(null, " do you want to logout? ");
				 if(dialogBox == JOptionPane.YES_OPTION)
				 {
					 a.frmLogin.setVisible(true); 
				 }
				 
				
			}
		});
		btnNewButton.setBounds(277, 283, 104, 37);
		panel_1.add(btnNewButton);
		
		JButton btnRefAdd = new JButton("Save");
		btnRefAdd.setBounds(64, 283, 89, 37);
		panel_1.add(btnRefAdd);
		btnRefAdd.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\save.png"));
		
		JButton btnRefClear = new JButton("Clear");
		btnRefClear.setBounds(163, 283, 104, 37);
		panel_1.add(btnRefClear);
		btnRefClear.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\clear.png"));
		btnRefClear.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(64, 41, 287, 212);
		panel_1.add(desktopPane);
		desktopPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		desktopPane.setBackground(SystemColor.inactiveCaptionBorder);
		
		JLabel lblRefId = new JLabel("Reference Book ID");
		lblRefId.setBounds(29, 58, 112, 14);
		desktopPane.add(lblRefId);
		
		JLabel lblRefBkName = new JLabel("Reference Book Name");
		lblRefBkName.setBounds(29, 118, 133, 14);
		desktopPane.add(lblRefBkName);
		
		JLabel lblRefBkAth = new JLabel("Author's Last Name");
		lblRefBkAth.setBounds(29, 172, 133, 14);
		desktopPane.add(lblRefBkAth);
		
		txtRefId = new JTextField();
		txtRefId.setBounds(164, 55, 86, 23);
		desktopPane.add(txtRefId);
		txtRefId.setColumns(10);
		
		txtRefNme = new JTextField();
		txtRefNme.setBounds(164, 112, 86, 23);
		desktopPane.add(txtRefNme);
		txtRefNme.setColumns(10);
		
		txtRefAth = new JTextField();
		txtRefAth.setBounds(164, 169, 86, 23);
		desktopPane.add(txtRefAth);
		txtRefAth.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(458, 25, 178, 295);
		panel_1.add(panel);
		panel.setBackground(new Color(245, 245, 245));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setLayout(null);
		
		 listName = new JList();
		 listName.setBounds(18, 11, 142, 264);
		 panel.add(listName);
		 listName.setVisibleRowCount(20);
		btnRefClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtRefAth.setText("");
				txtRefId.setText("");
				txtRefNme.setText("");
				
				
			}
		});
		btnRefAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	String d1 = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
				java.util.Date date = null;
				try {
					date = format.parse(d1);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				String id = txtRefId.getText();
				int bkId =0;
				
				if(!id.isEmpty())
				{
					bkId = Integer.parseInt(id);
				}
				String name = txtRefNme.getText();
				String auth_name = txtRefAth.getText();
			if(id.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "enter the book id");
				}
				else if(name.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "enter the book name");
				}
				else if(auth_name.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "enter the author's last name");
				}
				else
				{
				
			RefernceBook refAdd = new RefernceBook();
			refAdd.saveRefBook(bkId, name, auth_name);
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAction obj = new BookAction();
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\backButton.png"));
		btnNewButton_1.setBounds(1208, 0, 52, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard obj = new Dashboard();
				obj.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\Forward.png"));
		btnNewButton_2.setBounds(1260, 0, 52, 35);
		contentPane.add(btnNewButton_2);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		dispose();
			}
		});
		button.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\delete.png"));
		button.setBounds(1312, 0, 52, 35);
		contentPane.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.controlHighlight);
		panel_2.setBounds(270, 80, 876, 530);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reference Book Registration");
		lblNewLabel.setBounds(273, 47, 330, 25);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Vani", Font.PLAIN, 18));
		loadList();
	}
}
