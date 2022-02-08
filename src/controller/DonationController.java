package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Donor;
import model.DonorRegistration;
import model.DonorReport;
import view.DonationView;
import view.RegistrationView;

public class DonationController implements ActionListener{
	DonationView view;
	public DonationController(DonationView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(view.isReg(e.getSource())) {
			RegistrationView vie = new RegistrationView();
			vie.setVisible(true);
			view.dispose();
		}else if(view.isDon(e.getSource())) {
			if(!view.isEmpty()) {
				String id = view.getSelectedID();
				Donor d = DonorRegistration.getRegistration().getDonor(id);
				double t=view.getTemperature();
				double p= view.getPlusRate();
				if(t == -1 || p == -1)
					return;
				d.setBloodTemperature(t);
				d.setPlusRate(p);
				d.setBloodPressure(view.getBloodPressure());
				d.setBloodType(view.getBloodType());
				d.setDonationDate(view.getDate());
				d.setHiv(view.isHIV());
				d.setMalaria(view.isMalaria());
				view.clear();
				view.removeId(id);
				DonorReport.getReport().addDonated(d);
			}else {
				view.giveError("Fill the form first! ");
			}
		}else {
			MainController con = new MainController();
			con.setVisible();
			view.dispose();
		}
	}

}
