package people;

public class Admin {

	private int adminID;
	private String firstName;
	private String lastName;
	private String adminPassword;
	private String status;

	public Admin() {

	}

	public Admin(int adminID, String firstName, String lastName, String adminPassword, String status) {
		super();
		this.adminID = adminID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adminPassword = adminPassword;
		this.status = status;

	}
	

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", firstName=" + firstName + ", lastName=" + lastName + ", adminPassword="
				+ adminPassword + ", status=" + status + "]";
	}

	

}
