package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DonorRegistration {
	private List<Donor> list;
	private DonorReport report;

	private static DonorRegistration reg;

	private DonorRegistration() {
		report = DonorReport.getReport();
		list = new ArrayList<Donor>();
		Connection con = DBConnection.getConnection();
		if (con != null) {
			try {
				PreparedStatement ps = con.prepareStatement("SELECT * FROM donor;");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String id = rs.getString(1);
					String name = rs.getString(2);
					String pass = rs.getString(3);
					String bt = rs.getString(4);
					String dt = rs.getString(5);
					String bp = rs.getString(6);
					String temp = rs.getString(7);
					String prate = rs.getString(8);
					boolean hiv = false, mal = false;
					if (rs.getInt(9) == 0)
						hiv = true;
					if (rs.getInt(10) == 0)
						mal = true;
					list.add(new Donor(id, name, pass, bt, dt, bp, Double.parseDouble(temp), Double.parseDouble(prate),
							hiv, mal));
				}
			} catch (Exception e) {
			}
		}
	}

	public static DonorRegistration getRegistration() {
		if (reg == null)
			reg = new DonorRegistration();
		return reg;
	}

	public void register(String user_id, String username, String password, String bloodType, String donationDate,
			String bloodPressure, double bloodTemperature, double plusRate, boolean hiv, boolean malaria) {
		for (Donor d : list) {
			if (d.getUser_id().equals(user_id)) {
				return;
			}
		}
		try {
			Connection con=DBConnection.getConnection();
			if(con != null) {
				PreparedStatement ps=con.prepareStatement("INSERT INTO donor(userid,uname,pass,bloodType,date,bp,temperature,plusrate,hiv,malaria) VALUES (?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,user_id);
				ps.setString(2,username);
				ps.setString(3,password);
				ps.setString(4,bloodType);
				ps.setString(5,donationDate);
				ps.setString(6,bloodPressure);
				ps.setString(7,""+bloodTemperature);
				ps.setString(8,""+plusRate);
				int hi = 1,mal = 1;
				if(hiv)
					hi = 0;
				if(malaria)
					mal = 0;
				ps.setInt(9, hi);
				ps.setInt(10, mal);
				ps.execute();
			}
		}catch(Exception e) {
		}
		list.add(new Donor(user_id, username, password, bloodType, donationDate, bloodPressure, bloodTemperature,
				plusRate, hiv, malaria));
	}

	public void donated(String user_id) {
		for (Donor d : list) {
			if (d.getUser_id().equals(user_id)) {
				report.addDonated(d);
				break;
			}
		}
	}

	public Donor getDonor(String user_id) {
		for (Donor d : list) {
			if (d.getUser_id().equals(user_id)) {
				return d;
			}
		}
		return null;
	}

	public List<String> getId() {
		List<String> lis = new ArrayList<String>();
		for (Donor d : list) {
			if (!report.checkDonated(d)) {
				lis.add(d.getUser_id());
			}
		}
		return lis;
	}

}
