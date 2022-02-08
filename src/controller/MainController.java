package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginView;
import view.MainView;

public class MainController implements ActionListener{
	private MainView view;
	
	public MainController() {
		view = new MainView(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		LoginView view = new LoginView();
		view.setVisible(true);
		this.view.dispose();
	}
	
	public void setVisible() {
		view.setVisible(true);
	}
}
