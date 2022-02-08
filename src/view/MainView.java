package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.MainController;

import javax.swing.JButton;
import java.awt.Font;

public class MainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel mainLabel;
	private JButton adminButton;
	private JButton donorButton;
	private MainController con;

	public MainView(MainController co) {
		this.con = co;
		setTitle("Blood Donation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(396, 237);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainLabel = new JLabel("Blood Donation System");
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font("Luminari", Font.BOLD, 30));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setBounds(6, 6, 384, 29);
		contentPane.add(mainLabel);

		adminButton = new JButton("Admin");
		adminButton.setBounds(112, 47, 172, 55);
		contentPane.add(adminButton);

		donorButton = new JButton("Donor");
		donorButton.setBounds(112, 125, 172, 55);
		contentPane.add(donorButton);

		adminButton.addActionListener(con);
		donorButton.addActionListener(con);
	}

	public boolean isAdmin(Object e) {
		return adminButton.equals(e);
	}
}
