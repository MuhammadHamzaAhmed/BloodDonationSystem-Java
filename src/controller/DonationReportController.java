package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DonationReportView;

public class DonationReportController implements ActionListener{
	private DonationReportView view;
	
	public DonationReportController(DonationReportView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainController con = new MainController();
		con.setVisible();
		this.view.dispose();
	}

}
