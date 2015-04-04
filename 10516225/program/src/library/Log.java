package library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.Statement;

import library.DbCon;

import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Color;

import javax.swing.border.BevelBorder;

import java.awt.LayoutManager;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import java.awt.FlowLayout;

import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.SystemColor;


public class Log extends DbCon{

	public JFrame frmLogin;
	public JTextField txtUser;
	public JTextField txtPassword;

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
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Log.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "nimbus coudnt be found");
	        }
		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log window = new Log();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	Statement st = null;
	private final JButton btnSignUp = new JButton("SignUp");
	/**
	 * Create the application.
	 */
	public Log() {
		initialize();
		connection = DbCon.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmLogin = new JFrame();
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\java\\libroIcon.png"));
		frmLogin.setBackground(new Color(192, 192, 192));
		frmLogin.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frmLogin.setLocationRelativeTo(null);
		frmLogin.getContentPane().setBackground(SystemColor.activeCaptionBorder);
		frmLogin.setBounds(100, 100, 613, 466);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setExtendedState(frmLogin.MAXIMIZED_BOTH);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setUndecorated(true);
		frmLogin.getContentPane().setLayout(null);
		
		
		JLabel lblUser = new JLabel("Username");
		lblUser.setBounds(550, 410, 80, 14);
		frmLogin.getContentPane().add(lblUser);
		
		JLabel lblPasword = new JLabel("Password");
		lblPasword.setBounds(550, 450, 80, 14);
		frmLogin.getContentPane().add(lblPasword);
		
		txtUser = new JTextField();
		txtUser.setBounds(650, 410, 86, 23);
		txtUser.setColumns(10);
		frmLogin.getContentPane().add(txtUser);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(650, 450, 86, 23);
		txtPassword.setColumns(10);
		frmLogin.getContentPane().add(txtPassword);
		
		
		JButton btnLog = new JButton("Login");
		btnLog.setBounds(650, 490, 94, 38);
		btnLog.setBackground(new Color(169, 169, 169));
		btnLog.setIcon(null);
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String user = txtUser.getText().trim();
				String pass = txtPassword.getText().trim();
				//String passwrd = psswrdPass.getPassword().toString();
				if(user.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "enter the username");
				}
				else if(pass.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "enter the password");
				}
				else
				{
					
				
				Librarian l1 = new Librarian();
				l1.log(user, pass);
				}
			
		/*		bookAction b1 = new bookAction();
				b1.setVisible(true);*/
				Dashboard d1 = new Dashboard();
				d1.setVisible(true);
			}
		});
		frmLogin.getContentPane().add(btnLog);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(340, 400, 108, 145);
		label_2.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\padlock.png"));
		frmLogin.getContentPane().add(label_2);
		
		JLabel lblLibroLibraryManagement = new JLabel("LIBRO  Library Management System");
		lblLibroLibraryManagement.setBounds(490, 280, 349, 30);
		lblLibroLibraryManagement.setForeground(new Color(0, 0, 0));
		lblLibroLibraryManagement.setFont(new Font("Vani", Font.PLAIN, 18));
		frmLogin.getContentPane().add(lblLibroLibraryManagement);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(470, 350, 97, 30);
		lblNewLabel.setFont(new Font("Vani", Font.BOLD, 16));
		frmLogin.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(460, 340, 395, 231);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(192, 192, 192));
		frmLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(36, 40, 315, 160);
		panel_1.add(panel);
		panel.setBackground(new Color(248, 248, 255));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setLayout(null);
		
		
		//signUp method invoking
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			SignUp s = new SignUp();
			s.setVisible(true);
				
			}
		});
		btnSignUp.setBounds(20, 111, 94, 38);
		panel.add(btnSignUp);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(361, 250, 591, 405);
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmLogin.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(550, 153, 155, 73);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\libroIcon.png"));
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		final JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\delete.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.dispose();
				
			}
		});
		btnNewButton.setBounds(1312, 0, 52, 35);
		frmLogin.getContentPane().add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(292, 127, 735, 601);
		frmLogin.getContentPane().add(panel_3);
		
		
	}

	
}
