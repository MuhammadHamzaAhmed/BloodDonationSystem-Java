package model;

public class Donor extends User {
	private String bloodType;
	private String donationDate;
	private String bloodPressure;
	private double bloodTemperature;
	private double plusRate;
	private boolean hiv;
	private boolean malaria;

	public Donor(String user_id, String username, String password, String bloodType, String donationDate,
			String bloodPressure, double bloodTemperature, double plusRate, boolean hiv, boolean malaria) {
		super(user_id, username, password);
		this.bloodType = bloodType;
		this.donationDate = donationDate;
		this.bloodPressure = bloodPressure;
		this.bloodTemperature = bloodTemperature;
		this.plusRate = plusRate;
		this.hiv = hiv;
		this.malaria = malaria;
	}

	public String getBloodType() {
		return bloodType;
	}

	public String getDonationDate() {
		return donationDate;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public double getBloodTemperature() {
		return bloodTemperature;
	}

	public double getPlusRate() {
		return plusRate;
	}

	public boolean isHiv() {
		return hiv;
	}

	public boolean isMalaria() {
		return malaria;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public void setDonationDate(String donationDate) {
		this.donationDate = donationDate;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public void setBloodTemperature(double bloodTemperature) {
		this.bloodTemperature = bloodTemperature;
	}

	public void setPlusRate(double plusRate) {
		this.plusRate = plusRate;
	}

	public void setHiv(boolean hiv) {
		this.hiv = hiv;
	}

	public void setMalaria(boolean malaria) {
		this.malaria = malaria;
	}

	
}
