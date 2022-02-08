package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class DonorReport {
	private List<Donor> donated;
	private static DonorReport report;
	
	private DonorReport() {
		donated = new ArrayList<Donor>();
	}

	public static DonorReport getReport() {
		if (report == null)
			report = new DonorReport();
		return report;
	}
	
	public void addDonated(Donor don) {
		donated.add(don);
		delete(don.getUser_id());
		save(don);
	}
	
	private void delete(String user_id) {
		try {
			Connection con=DBConnection.getConnection();
			if(con != null) {
				PreparedStatement st = con.prepareStatement("DELETE FROM donor WHERE userid = ?");
				st.setString(1, user_id);
				st.execute();
			}
		}catch(Exception e) {
			
		}
	}

	private void save(Donor d) {
		try {
			Connection con=DBConnection.getConnection();
			if(con != null) {
				PreparedStatement ps=con.prepareStatement("INSERT INTO donor(userid,uname,pass,bloodType,date,bp,temperature,plusrate,hiv,malaria) VALUES (?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,d.getUser_id());
				ps.setString(2,d.getUsername());
				ps.setString(3,d.getPassword());
				ps.setString(4,d.getBloodType());
				ps.setString(5,d.getDonationDate());
				ps.setString(6,d.getBloodPressure());
				ps.setString(7,""+d.getBloodTemperature());
				ps.setString(8,""+d.getPlusRate());
				int hi = 1,mal = 1;
				if(d.isHiv())
					hi = 0;
				if(d.isMalaria())
					mal = 0;
				ps.setInt(9, hi);
				ps.setInt(10, mal);
				ps.execute();
			}
		}catch(Exception e) {
		}
	}

	public void removeDonated(Donor don) {
		donated.remove(don);
	}
	
	public List<Donor> getDonated(){
		return donated;
	}
	
	public boolean checkDonated(Donor don) {
		return donated.contains(don);
	}

}
