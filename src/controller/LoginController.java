package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Donor;
import model.DonorRegistration;
import view.DonationReportView;
import view.LoginView;
import view.RegistrationView;

public class LoginController implements ActionListener {
	private DonorRegistration donor;
	private LoginView view;

	public LoginController(LoginView view) {
		donor = DonorRegistration.getRegistration();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (view.isBack(e.getSource())) {
			MainController con = new MainController();
			con.setVisible();
			view.dispose();
		} else {
			if(view.getId().getText().equals("")) {
				view.giveError("No User id entered");
				return;
			}else if(view.getId().getText().equals("")){
				view.giveError("No password entered");
				return;
			}
			if (view.getId().getText().equalsIgnoreCase("Admin")
					&& new String(view.getPwd().getPassword()).equalsIgnoreCase("Admin")) {
				RegistrationView view = new RegistrationView();
				view.setVisible(true);
				this.view.dispose();
			} else {
				String id = view.getId().getText();
				String pwd = new String(view.getPwd().getPassword());
				Donor don = donor.getDonor(id);
				if (don == null) {
					view.giveError("User not found!");
					return;
				} else {
					if (don.getPassword().equals(pwd)) {
						DonationReportView view = new DonationReportView(don);
						view.setVisible(true);
						this.view.dispose();
					} else {
						view.giveError("Wrong Password");
					}
				}
				view.getId().setText("");
				view.getPwd().setText("");
			}
		}
	}

}
