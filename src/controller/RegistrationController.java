package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DonorRegistration;
import view.DonationView;
import view.RegistrationView;

public class RegistrationController implements ActionListener {
	private RegistrationView view;

	public RegistrationController(RegistrationView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (view.isReg(e.getSource())) {
			if (!view.isEmpty()) {
				String id = view.getID();
				String name = view.getNamee();
				String pass = view.getPass();
				DonorRegistration.getRegistration().register(id, name, pass, "Nil", "Nil", "Nil", -1, -1, false, false);
				view.clear();
			}else {
				view.giveError("Fill all fields first");
			}
		} else if (view.isDon(e.getSource())) {
			DonationView vi=new DonationView();
			vi.setVisible(true);
			view.dispose();
		} else {
			MainController con = new MainController();
			con.setVisible();
			view.dispose();
		}
	}

}
