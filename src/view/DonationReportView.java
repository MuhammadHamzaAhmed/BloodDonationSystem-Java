package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.DonationReportController;
import model.Donor;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DonationReportView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField date;
	private JTextField type;
	private JTextField press;
	private JTextField temp;
	private JTextField prate;
	private JTextField hiv;
	private JTextField mal;
	private DonationReportController con;

	public DonationReportView(Donor don) {
		con = new DonationReportController(this);
		setTitle("Blood Donation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(452, 482);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel mainLabel = new JLabel("Blood Donation System");
		mainLabel.setForeground(Color.WHITE);
		mainLabel.setFont(new Font("Luminari", Font.BOLD, 30));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setBounds(6, 6, 440, 29);
		contentPane.add(mainLabel);

		JLabel uid = new JLabel("User ID");
		uid.setHorizontalAlignment(SwingConstants.LEFT);
		uid.setForeground(Color.WHITE);
		uid.setFont(new Font("Luminari", Font.BOLD, 20));
		uid.setBounds(16, 45, 84, 29);
		contentPane.add(uid);

		JLabel uname = new JLabel("User Name");
		uname.setHorizontalAlignment(SwingConstants.LEFT);
		uname.setForeground(Color.WHITE);
		uname.setFont(new Font("Luminari", Font.BOLD, 20));
		uname.setBounds(17, 85, 123, 29);
		contentPane.add(uname);

		JLabel dtlb = new JLabel("Date");
		dtlb.setHorizontalAlignment(SwingConstants.LEFT);
		dtlb.setForeground(Color.WHITE);
		dtlb.setFont(new Font("Luminari", Font.BOLD, 20));
		dtlb.setBounds(19, 165, 84, 29);
		contentPane.add(dtlb);

		JLabel btype = new JLabel("Blood Type");
		btype.setHorizontalAlignment(SwingConstants.LEFT);
		btype.setForeground(Color.WHITE);
		btype.setFont(new Font("Luminari", Font.BOLD, 20));
		btype.setBounds(18, 125, 122, 29);
		contentPane.add(btype);

		JLabel hIv = new JLabel("HIV");
		hIv.setHorizontalAlignment(SwingConstants.LEFT);
		hIv.setForeground(Color.WHITE);
		hIv.setFont(new Font("Luminari", Font.BOLD, 20));
		hIv.setBounds(23, 325, 84, 29);
		contentPane.add(hIv);

		JLabel prte = new JLabel("Plus Rate");
		prte.setHorizontalAlignment(SwingConstants.LEFT);
		prte.setForeground(Color.WHITE);
		prte.setFont(new Font("Luminari", Font.BOLD, 20));
		prte.setBounds(22, 285, 118, 29);
		contentPane.add(prte);

		JLabel tmp = new JLabel("Temperature");
		tmp.setHorizontalAlignment(SwingConstants.LEFT);
		tmp.setForeground(Color.WHITE);
		tmp.setFont(new Font("Luminari", Font.BOLD, 20));
		tmp.setBounds(21, 245, 148, 29);
		contentPane.add(tmp);

		JLabel bp = new JLabel("Blood Pressure");
		bp.setHorizontalAlignment(SwingConstants.LEFT);
		bp.setForeground(Color.WHITE);
		bp.setFont(new Font("Luminari", Font.BOLD, 20));
		bp.setBounds(20, 205, 148, 29);
		contentPane.add(bp);

		JLabel mala = new JLabel("Malaria");
		mala.setHorizontalAlignment(SwingConstants.LEFT);
		mala.setForeground(Color.WHITE);
		mala.setFont(new Font("Luminari", Font.BOLD, 20));
		mala.setBounds(24, 365, 94, 29);
		contentPane.add(mala);

		id = new JTextField();
		id.setEditable(false);
		id.setBounds(177, 40, 246, 39);
		contentPane.add(id);
		id.setColumns(10);

		JButton logout = new JButton("Logout");
		logout.setBounds(162, 413, 117, 29);
		contentPane.add(logout);

		name = new JTextField();
		name.setEditable(false);
		name.setColumns(10);
		name.setBounds(176, 80, 246, 39);
		contentPane.add(name);

		date = new JTextField();
		date.setEditable(false);
		date.setColumns(10);
		date.setBounds(176, 160, 246, 39);
		contentPane.add(date);

		type = new JTextField();
		type.setEditable(false);
		type.setColumns(10);
		type.setBounds(176, 120, 246, 39);
		contentPane.add(type);

		press = new JTextField();
		press.setEditable(false);
		press.setColumns(10);
		press.setBounds(177, 199, 246, 39);
		contentPane.add(press);

		temp = new JTextField();
		temp.setEditable(false);
		temp.setColumns(10);
		temp.setBounds(176, 239, 246, 39);
		contentPane.add(temp);

		prate = new JTextField();
		prate.setEditable(false);
		prate.setColumns(10);
		prate.setBounds(176, 279, 246, 39);
		contentPane.add(prate);

		hiv = new JTextField();
		hiv.setEditable(false);
		hiv.setColumns(10);
		hiv.setBounds(176, 319, 246, 39);
		contentPane.add(hiv);

		mal = new JTextField();
		mal.setEditable(false);
		mal.setColumns(10);
		mal.setBounds(176, 361, 246, 39);
		contentPane.add(mal);

		id.setText(don.getUser_id());
		name.setText(don.getUsername());
		type.setText(don.getBloodType());
		date.setText(don.getDonationDate());
		press.setText(don.getBloodPressure());
		temp.setText("" + don.getBloodTemperature());
		prate.setText("" + don.getPlusRate());
		if (don.getBloodTemperature() == -1) {
			hiv.setText("-");
			mal.setText("-");
		} else {
			if (don.isHiv())
				hiv.setText("Positive");
			else
				hiv.setText("Negative");
			if (don.isMalaria())
				mal.setText("Positive");
			else
				mal.setText("Negative");
		}
		logout.addActionListener(con);

	}

}
