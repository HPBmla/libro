package library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JSlider;

import java.awt.Toolkit;
import java.awt.SystemColor;

public class SignUp extends JFrame {

	
	private JPanel contentPane;
	private JTextField txtLibFnme;
	private JTextField txtLibLnme;
	private JTextField txtLibAdd1;
	private JTextField txtLibAdd2;
	private JTextField txtLibAdd3;
	private JTextField txtLibTel;
	private JTextField txtLibUser;
	private JTextField txtLibNic;
	private JTextField txtLibPass;

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
					SignUp frame = new SignUp();
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
	public SignUp() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\java\\libroIcon.png"));
		setTitle("Sign Up Form");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 1382, 872);
     setUndecorated(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(350, 69, 690, 611);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBounds(77, 74, 529, 475);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLibFnme = new JLabel("First Name");
		lblLibFnme.setBounds(65, 34, 100, 14);
		panel_1.add(lblLibFnme);
		
		JLabel lblLibLnme = new JLabel("Last Name");
		lblLibLnme.setBounds(65, 85, 100, 14);
		panel_1.add(lblLibLnme);
		
		JLabel lblLibAdd = new JLabel("Address");
		lblLibAdd.setBounds(65, 136, 100, 14);
		panel_1.add(lblLibAdd);
		
		JLabel lblLibTel = new JLabel("Telephone Number");
		lblLibTel.setBounds(65, 286, 137, 14);
		panel_1.add(lblLibTel);
		
		JLabel lblLibNic = new JLabel("National Identity Card No");
		lblLibNic.setBounds(65, 337, 154, 14);
		panel_1.add(lblLibNic);
		
		JLabel lblLibUsername = new JLabel("Username");
		lblLibUsername.setBounds(65, 391, 100, 14);
		panel_1.add(lblLibUsername);
		
		txtLibFnme = new JTextField();
		txtLibFnme.setBounds(247, 31, 137, 23);
		panel_1.add(txtLibFnme);
		txtLibFnme.setColumns(10);
		
		txtLibLnme = new JTextField();
		txtLibLnme.setBounds(247, 82, 137, 23);
		panel_1.add(txtLibLnme);
		txtLibLnme.setColumns(10);
		
		txtLibAdd1 = new JTextField();
		txtLibAdd1.setBounds(247, 133, 137, 23);
		panel_1.add(txtLibAdd1);
		txtLibAdd1.setColumns(10);
		
		txtLibAdd2 = new JTextField();
		txtLibAdd2.setBounds(247, 184, 137, 23);
		panel_1.add(txtLibAdd2);
		txtLibAdd2.setColumns(10);
		
		txtLibAdd3 = new JTextField();
		txtLibAdd3.setBounds(247, 235, 137, 23);
		panel_1.add(txtLibAdd3);
		txtLibAdd3.setColumns(10);
		
		txtLibTel = new JTextField();
		txtLibTel.setBounds(247, 286, 137, 23);
		panel_1.add(txtLibTel);
		txtLibTel.setColumns(10);
		
		txtLibUser = new JTextField();
		txtLibUser.setBounds(247, 388, 137, 23);
		panel_1.add(txtLibUser);
		txtLibUser.setColumns(10);
		
		txtLibNic = new JTextField();
		txtLibNic.setText("");
		txtLibNic.setBounds(247, 337, 137, 23);
		panel_1.add(txtLibNic);
		txtLibNic.setColumns(10);
		
		JLabel lblLibPass = new JLabel("Password");
		lblLibPass.setBounds(65, 442, 100, 14);
		panel_1.add(lblLibPass);
		
		txtLibPass = new JTextField();
		txtLibPass.setBounds(247, 439, 137, 23);
		panel_1.add(txtLibPass);
		txtLibPass.setColumns(10);
		
		JButton btnSign = new JButton("Sign Up");
		btnSign.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\signUp.png"));
		
		//signup method
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String fName = txtLibFnme.getText();
				String lName = txtLibLnme.getText();
				String add1 = txtLibAdd1.getText();
				String add2 = txtLibAdd2.getText();
				String add3 = txtLibAdd3.getText();
				String tel = txtLibTel.getText();
				String nic = txtLibNic.getText();
				String user = txtLibUser.getText();
				String passwrd = txtLibPass.getText();
				if(fName.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "First name is empty");
				}
				else if(lName.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Last name is empty");
				}
				else if(add1.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "address is empty");
				}
				else if(add2.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "address is empty");
				}
				else if(tel.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "contact number is empty");
				}
				else if(nic.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "National identity card number is empty");
				}
				else if(user.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "username is empty");
				}
				else if(passwrd.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "enter a password to proceed");
				}
				else
				{
			Librarian signUpLib = new  Librarian();	
		signUpLib.signUp(fName, lName, add1, add2, add3, tel, nic, user, passwrd);
		
				
				}
				
				
				
			}
		});
		btnSign.setBounds(283, 568, 118, 33);
		panel.add(btnSign);
		
		JButton btnLibClr = new JButton("Clear");
		btnLibClr.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\clear.png"));
		btnLibClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtLibFnme.setText("");
				txtLibLnme.setText("");
				txtLibAdd1.setText("");
				txtLibAdd2.setText("");
				txtLibAdd3.setText("");
				txtLibTel.setText("");
				txtLibNic.setText("");
				txtLibUser.setText("");
				//txtLibPass.setText("");
			}
		});
		btnLibClr.setBounds(469, 568, 112, 33);
		panel.add(btnLibClr);
		
		JLabel lblNewLabel = new JLabel("Sign Up Form");
		lblNewLabel.setFont(new Font("Vani", Font.PLAIN, 18));
		lblNewLabel.setBounds(266, 27, 313, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\libroIcon.png"));
		lblNewLabel_1.setBounds(587, 0, 155, 69);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			dispose();
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\delete.png"));
		btnNewButton.setBounds(1312, 0, 52, 35);
		contentPane.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(303, 0, 787, 766);
		contentPane.add(panel_2);
	}
}
