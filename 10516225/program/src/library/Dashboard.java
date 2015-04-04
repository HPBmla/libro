package library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Dashboard extends JFrame {

	private JPanel contentPane;

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
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\java\\libroIcon.png"));
		setTitle("Dashboard");
		//dashbord.setExtendedState(dashbord.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(500, 250, 371, 204);
		contentPane.add(panel);
		panel.setLayout(null);
		//dashbord.setExtendedState(dashbord.MAXIMIZED_BOTH);
		JLabel lblSelection = new JLabel("Select The Section");
		lblSelection.setFont(new Font("Vani", Font.PLAIN, 18));
		lblSelection.setBounds(91, 29, 190, 25);
		panel.add(lblSelection);
		
		JButton btnBooks = new JButton(" Books");
		btnBooks.setBounds(111, 103, 89, 48);
		panel.add(btnBooks);
		
		JButton btnMember = new JButton("Members");
		btnMember.setBounds(221, 103, 89, 48);
		panel.add(btnMember);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(63, 88, 274, 84);
		panel.add(panel_1);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon("C:\\bimla\\Dev\\java\\practicals\\src\\library\\src\\images\\delete.png"));
		button.setBounds(1312, 0, 52, 35);
		contentPane.add(button);
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member mem1 = new Member();
				mem1.setVisible(true);
			}
		});
		btnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookAction b2 = new BookAction();
				b2.setVisible(true);
				
			}
		});
	}
}
