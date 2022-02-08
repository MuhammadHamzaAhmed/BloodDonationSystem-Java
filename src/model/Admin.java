package model;

public class Admin {
	private String admin_id;
	private String username;
	private String password;

	public Admin(String admin_id, String username, String password) {
		super();
		this.admin_id = admin_id;
		this.username = username;
		this.password = password;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
