package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.RegistrationController;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegistrationView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RegistrationController con;
	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField pass;
	private JButton don;
	private JButton reg;
	private JButton log;

	public RegistrationView() {
		con = new RegistrationController(this);
		setTitle("Blood Donation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(396, 254);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel mainLabel = new JLabel("Blood Donation System");
		mainLabel.setBounds(6, 6, 384, 29);
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font("Luminari", Font.BOLD, 30));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(mainLabel);
		
		JLabel uid = new JLabel("User Id");
		uid.setHorizontalAlignment(SwingConstants.LEFT);
		uid.setForeground(Color.WHITE);
		uid.setFont(new Font("Luminari", Font.BOLD, 20));
		uid.setBounds(6, 58, 96, 29);
		contentPane.add(uid);
		
		JLabel uname = new JLabel("User Name");
		uname.setHorizontalAlignment(SwingConstants.LEFT);
		uname.setForeground(Color.WHITE);
		uname.setFont(new Font("Luminari", Font.BOLD, 20));
		uname.setBounds(6, 99, 118, 29);
		contentPane.add(uname);
		
		JLabel pwdLbl = new JLabel("Password");
		pwdLbl.setHorizontalAlignment(SwingConstants.LEFT);
		pwdLbl.setForeground(Color.WHITE);
		pwdLbl.setFont(new Font("Luminari", Font.BOLD, 20));
		pwdLbl.setBounds(6, 140, 118, 29);
		contentPane.add(pwdLbl);
		
		id = new JTextField();
		id.setBounds(124, 58, 248, 26);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(124, 101, 248, 26);
		contentPane.add(name);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(125, 145, 248, 26);
		contentPane.add(pass);
		
		reg = new JButton("Register");
		reg.setBounds(22, 181, 117, 29);
		contentPane.add(reg);
		
		don = new JButton("Donate");
		don.setBounds(138, 181, 117, 29);
		contentPane.add(don);
		
		log = new JButton("Logout");
		log.setBounds(255, 181, 117, 29);
		contentPane.add(log);
		
		reg.addActionListener(con);
		don.addActionListener(con);
		log.addActionListener(con);
	}
	
	public boolean isReg(Object s) {
		return reg.equals(s);
	}
	
	public boolean isDon(Object s) {
		return don.equals(s);
	}
	
	public boolean isLog(Object s) {
		return log.equals(s);
	}

	public boolean isEmpty() {
		return id.getText().equals("") || name.getText().equals("") || pass.getText().equals("");
	}
	
	public String getID() {
		return id.getText();
	}
	
	public String getNamee() {
		return name.getText();
	}
	
	public String getPass() {
		return pass.getText();
	}

	public void clear() {
		id.setText("");
		name.setText("");
		pass.setText("");
	}

	public void giveError(String string) {
		JOptionPane.showMessageDialog(null, string);
	}
}
