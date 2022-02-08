package view;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.DonationController;
import model.DonorRegistration;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;


public class DonationView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DonationController con;
	private JPanel contentPane;
	private JTextField bloodType;
	private JTextField date;
	private JTextField bp;
	private JButton don;
	private JButton reg;
	private JButton log;
	private JTextField temp;
	private JTextField plusRate;
	private JComboBox<String> comboBox;
	private JCheckBox hiv;
	private JCheckBox malaria;

	public DonationView() {
		con = new DonationController(this);
		setTitle("Blood Donation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(396, 413);
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
		
		JLabel dte = new JLabel("Date");
		dte.setHorizontalAlignment(SwingConstants.LEFT);
		dte.setForeground(Color.WHITE);
		dte.setFont(new Font("Luminari", Font.BOLD, 20));
		dte.setBounds(6, 140, 118, 29);
		contentPane.add(dte);
		
		JLabel pwdLbl = new JLabel("Blood Pressure");
		pwdLbl.setHorizontalAlignment(SwingConstants.LEFT);
		pwdLbl.setForeground(Color.WHITE);
		pwdLbl.setFont(new Font("Luminari", Font.BOLD, 20));
		pwdLbl.setBounds(6, 181, 156, 29);
		contentPane.add(pwdLbl);
		
		bloodType = new JTextField();
		bloodType.setBounds(158, 99, 214, 26);
		contentPane.add(bloodType);
		bloodType.setColumns(10);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(158, 142, 214, 26);
		contentPane.add(date);
		
		bp = new JTextField();
		bp.setColumns(10);
		bp.setBounds(158, 183, 214, 26);
		contentPane.add(bp);
		
		reg = new JButton("Register");
		reg.setBounds(22, 337, 117, 29);
		contentPane.add(reg);
		
		don = new JButton("Donate");
		don.setBounds(138, 337, 117, 29);
		contentPane.add(don);
		
		log = new JButton("Logout");
		log.setBounds(255, 337, 117, 29);
		contentPane.add(log);
		
		JLabel bdtp = new JLabel("Blood Type");
		bdtp.setHorizontalAlignment(SwingConstants.LEFT);
		bdtp.setForeground(Color.WHITE);
		bdtp.setFont(new Font("Luminari", Font.BOLD, 20));
		bdtp.setBounds(6, 99, 118, 29);
		contentPane.add(bdtp);
		
		comboBox = new JComboBox<String>();
		List<String> lis =DonorRegistration.getRegistration().getId();
		for(String s:lis) {
			comboBox.addItem(s);
		}
		comboBox.setBounds(159, 58, 214, 27);
		contentPane.add(comboBox);
		
		temp = new JTextField();
		temp.setColumns(10);
		temp.setBounds(158, 224, 214, 26);
		contentPane.add(temp);
		
		JLabel lblTemperature = new JLabel("Temperature");
		lblTemperature.setHorizontalAlignment(SwingConstants.LEFT);
		lblTemperature.setForeground(Color.WHITE);
		lblTemperature.setFont(new Font("Luminari", Font.BOLD, 20));
		lblTemperature.setBounds(6, 222, 156, 29);
		contentPane.add(lblTemperature);
		
		JLabel pRate = new JLabel("Plus Rate");
		pRate.setHorizontalAlignment(SwingConstants.LEFT);
		pRate.setForeground(Color.WHITE);
		pRate.setFont(new Font("Luminari", Font.BOLD, 20));
		pRate.setBounds(6, 262, 156, 29);
		contentPane.add(pRate);
		
		plusRate = new JTextField();
		plusRate.setColumns(10);
		plusRate.setBounds(158, 264, 214, 26);
		contentPane.add(plusRate);
		
		hiv = new JCheckBox("HIV");
		hiv.setBounds(194, 301, 62, 23);
		contentPane.add(hiv);
		
		malaria = new JCheckBox("Malaria");
		malaria.setBounds(112, 301, 84, 23);
		contentPane.add(malaria);
		
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
		return bloodType.getText().equals("") || date.getText().equals("") || bp.getText().equals("")
				|| temp.getText().equals("") || plusRate.getText().equals("");
	}
	
	public String getID() {
		return bloodType.getText();
	}
	
	public String getNamee() {
		return date.getText();
	}
	
	public String getPass() {
		return bp.getText();
	}

	public void clear() {
		bloodType.setText("");
		date.setText("");
		bp.setText("");
		temp.setText("");
		plusRate.setText("");
	}

	public void giveError(String string) {
		JOptionPane.showMessageDialog(null, string);
	}

	public String getSelectedID() {
		return (String) comboBox.getSelectedItem();
	}

	public String getBloodPressure() {
		return bp.getText();
	}

	public double getTemperature() {
		try {
			double d = Double.parseDouble(temp.getText());
			return d;
		}catch(Exception e) {
			giveError("Tempture should be in numbers");
		}
		return -1;
	}

	public double getPlusRate() {
		try {
			double d = Double.parseDouble(plusRate.getText());
			return d;
		}catch(Exception e) {
			giveError("Plus Rate should be in numbers");
		}
		return -1;
	}

	public String getBloodType() {
		return bloodType.getText();
	}

	public String getDate() {
		return date.getText();
	}

	public boolean isHIV() {
		return hiv.isSelected();
	}

	public boolean isMalaria() {
		return malaria.isSelected();
	}

	public void removeId(String id) {
		comboBox.removeItem(id);
	}
}
