package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.LoginController;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LoginController con;
	private JTextField id;
	private JPasswordField pwd;
	private JButton loginButton;
	private JButton back;

	public LoginView() {
		con = new LoginController(this);
		setTitle("Blood Donation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(396, 237);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mainLabel = new JLabel("Blood Donation System");
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font("Luminari", Font.BOLD, 30));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setBounds(6, 6, 384, 29);
		contentPane.add(mainLabel);
		
		JLabel idlbl = new JLabel("User Id: ");
		idlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		idlbl.setForeground(Color.WHITE);
		idlbl.setBounds(25, 70, 83, 16);
		contentPane.add(idlbl);
		
		id = new JTextField();
		id.setBounds(120, 57, 250, 35);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel pwdlbl = new JLabel("Password: ");
		pwdlbl.setForeground(Color.WHITE);
		pwdlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		pwdlbl.setBounds(25, 104, 101, 16);
		contentPane.add(pwdlbl);
		
		pwd = new JPasswordField();
		pwd.setBounds(120, 94, 250, 35);
		contentPane.add(pwd);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(64, 143, 138, 41);
		contentPane.add(loginButton);
		
		back = new JButton("Back");
		back.setBounds(211, 142, 138, 41);
		contentPane.add(back);
		
		loginButton.addActionListener(con);
		back.addActionListener(con);
	}
	
	public JTextField getId() {
		return id;
	}
	
	public JPasswordField getPwd() {
		return pwd;
	}

	public void giveError(String error) {
		JOptionPane.showMessageDialog(null, error);
	}

	public boolean isBack(Object source) {
		return back.equals(source);
	}
}
